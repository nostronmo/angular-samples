package com.tom.echarts.sample.music.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tom.echarts.sample.music.model.MusicAttributeStats;

@Repository
public interface StatsRepository extends JpaRepository<MusicAttributeStats, String> {

}
