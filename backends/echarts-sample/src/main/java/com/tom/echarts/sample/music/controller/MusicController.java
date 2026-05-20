package com.tom.echarts.sample.music.controller;

import java.util.List;
import java.util.Set;

import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.tom.echarts.sample.music.dto.MusicGenreResponse;
import com.tom.echarts.sample.music.service.MusicService;

import lombok.RequiredArgsConstructor;

@Validated
@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/music")
public class MusicController {

	private final MusicService service;

	@GetMapping(value = "/stats")
	@ResponseStatus(HttpStatus.OK)
	public MusicGenreResponse findStatsByGenre(@RequestParam String genre) {
		return service.findStatsByGenre(genre);
	}

	@GetMapping(value = "/compare")
	@ResponseStatus(HttpStatus.OK)
	public List<MusicGenreResponse> findStatsBetweenGenres(@RequestParam List<String> genre) {
		return service.findStatsBetweenGenres(genre);
	}

	@GetMapping(value = "/genres")
	@ResponseStatus(HttpStatus.OK)
	public Set<String> findAllGenres() {
		return service.findAllGenres();
	}
}
