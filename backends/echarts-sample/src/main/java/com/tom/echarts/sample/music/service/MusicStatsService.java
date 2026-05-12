package com.tom.echarts.sample.music.service;

import org.springframework.stereotype.Service;

import com.tom.echarts.sample.music.mapper.MusicStatsMapper;
import com.tom.echarts.sample.music.repository.MusicRepository;
import com.tom.echarts.sample.music.repository.StatsRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class MusicStatsService {

	private final MusicRepository musicRepository;
	private final StatsRepository statsRepository;
	private final MusicStatsMapper statsMapper;

	// Parallel Coordinates Graph
	
	

}
