package com.tom.echarts.sample.music.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import com.tom.echarts.sample.music.model.MusicAttributeStats;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface MusicStatsMapper {

	MusicAttributeStats build(String attributeName, Double minValue, Double maxValue);

	
	
}
