use std::fs::File;

use axum::{Json, extract::Query};
use minmaxlttb::Point;
use polars::{
    io::SerReader,
    prelude::{CsvReader, DataType},
};

use crate::models::pagination::Pagination;

pub async fn get_chart_data(Query(pagination): Query<Pagination>) -> Json<Vec<[f64; 2]>> {
    let file_path = "data/dataset.csv";
    let threshold = pagination.limit as usize;

    let file = File::open(file_path).expect("Could not open file");
    let df = CsvReader::new(file)
        .infer_schema(None)
        .has_header(true)
        .with_ignore_errors(true)
        .truncate_ragged_lines(true)
        .finish()
        .expect("Error reading CSV");

    let sorted_df = df.sort(["tempo"], false, false).expect("Sort failed");

    let sliced_df = sorted_df.slice(pagination.offset as i64, 1000.max(threshold * 2) as usize);

    let casted_tempo = sliced_df
        .column("tempo")
        .unwrap()
        .cast(&DataType::Float64)
        .unwrap();
    let casted_pop = sliced_df
        .column("popularity")
        .unwrap()
        .cast(&DataType::Float64)
        .unwrap();

    let tempo_col = casted_tempo.f64().unwrap();
    let pop_col = casted_pop.f64().unwrap();

    let mut last_x = f64::NEG_INFINITY;
    let mut points: Vec<Point> = Vec::new();

    for (t, p) in tempo_col.into_iter().zip(pop_col.into_iter()) {
        if let (Some(tempo), Some(pop)) = (t, p) {
            if tempo > last_x {
                points.push(Point::new(tempo, pop));
                last_x = tempo;
            }
            if points.len() >= threshold * 2 {
                break;
            }
        }
    }

    let final_points = if points.len() >= threshold && threshold > 2 {
        minmaxlttb::minmaxlttb(&points, threshold, 2)
            .unwrap_or_else(|_| points.iter().take(threshold).cloned().collect())
    } else {
        points.into_iter().take(threshold).collect()
    };

    let output: Vec<[f64; 2]> = final_points.into_iter().map(|p| [p.x(), p.y()]).collect();
    Json(output)
}
