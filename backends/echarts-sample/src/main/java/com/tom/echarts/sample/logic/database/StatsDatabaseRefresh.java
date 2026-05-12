package com.tom.echarts.sample.logic.database;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.tom.echarts.sample.music.mapper.MusicStatsMapper;
import com.tom.echarts.sample.music.repository.MusicRepository;
import com.tom.echarts.sample.music.repository.StatsRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
@RequiredArgsConstructor
public class StatsDatabaseRefresh {

	private final MusicRepository musicRepository;
	private final StatsRepository statsRepository;
	private final MusicStatsMapper statsMapper;

	@Transactional
	public void refreshStats() {
		
	}

	private void updateStats(String name, Double min, Double max) {
		statsRepository.save(statsMapper.build(name, min, max));
	}

}
