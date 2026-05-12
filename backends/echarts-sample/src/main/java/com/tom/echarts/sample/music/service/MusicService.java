package com.tom.echarts.sample.music.service;

import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tom.echarts.sample.music.dto.MusicGenreResponse;
import com.tom.echarts.sample.music.mapper.MusicMapper;
import com.tom.echarts.sample.music.repository.MusicRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class MusicService {

	private final MusicRepository musicRepository;
	private final MusicMapper musicMapper;

	// Radar Graph

	@Transactional(readOnly = true)
	public MusicGenreResponse findStatsByGenre(String query) {
		var music = musicRepository.findStatsByGenre(query);
		return musicMapper.toResponse(music);
	}

	@Transactional(readOnly = true)
	public List<MusicGenreResponse> findStatsBetweenGenres(List<String> query) {
		var music = musicRepository.findStatsBetweenGenres(query);
		return musicMapper.toResponse(music);
	}

	@Transactional(readOnly = true)
	public Set<String> findAllGenres() {
		var music = musicRepository.findAllGenres();
		return music;
	}

}
