package com.tom.echarts.sample.logic.schedule;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import com.tom.echarts.sample.logic.database.StatsDatabaseRefresh;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class DatabaseInitializer {

	private final StatsDatabaseRefresh databaseRefresh;

	@EventListener(ApplicationReadyEvent.class)
	public void init() {
		databaseRefresh.refreshStats();
	}

}
