package com.tom.echarts.sample.music.repository;

import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.tom.echarts.sample.logic.graphs.MusicGenreProjection;
import com.tom.echarts.sample.music.model.Music;

@Repository
public interface MusicRepository extends JpaRepository<Music, Integer> {

	@Query("""
			SELECT m.trackGenre AS label,
			         AVG(m.popularity) AS avgPopularity,
			         AVG(m.danceability) AS avgDanceability,
			         AVG(m.energy) AS avgEnergy,
			         AVG(m.acousticness) AS avgAcousticness,
			         AVG(m.valence) AS avgValence
			     FROM Music m
			     WHERE m.trackGenre = :genre
			     GROUP BY m.trackGenre
			""")
	MusicGenreProjection findStatsByGenre(@Param("genre") String genre);

	@Query("""
			SELECT m.trackGenre AS label,
			       AVG(m.popularity) AS avgPopularity,
			       AVG(m.danceability) AS avgDanceability,
			       AVG(m.energy) AS avgEnergy,
			       AVG(m.acousticness) AS avgAcousticness,
			       AVG(m.valence) AS avgValence
			FROM Music m
			WHERE m.trackGenre IN :genres
			GROUP BY m.trackGenre
			""")
	List<MusicGenreProjection> findStatsBetweenGenres(@Param("genres") List<String> genres);

	@Query("SELECT DISTINCT m.trackGenre FROM Music m ORDER BY m.trackGenre ASC")
	Set<String> findAllGenres();

}
