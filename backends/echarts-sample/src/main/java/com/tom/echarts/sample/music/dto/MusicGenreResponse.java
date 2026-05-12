package com.tom.echarts.sample.music.dto;

public record MusicGenreResponse(

		String label,
		Double avgPopularity,
	    Double avgDanceability,
	    Double avgEnergy,
	    Double avgAcousticness,
	    Double avgValence
		
) {

}
