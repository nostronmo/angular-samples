package com.tom.echarts.sample.music.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import com.tom.echarts.sample.logic.graphs.MusicGenreProjection;
import com.tom.echarts.sample.music.dto.MusicGenreResponse;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface MusicMapper {

	MusicGenreResponse toResponse(MusicGenreProjection projection);

	List<MusicGenreResponse> toResponse(List<MusicGenreProjection> projection);

}
