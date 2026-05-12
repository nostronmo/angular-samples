package com.tom.echarts.sample.logic;

import java.util.Optional;

import org.springframework.data.domain.AuditorAware;

public class ApplicationAuditAware implements AuditorAware<String> {

	@Override
	public Optional<String> getCurrentAuditor() {
		return Optional.empty();
	}

}
