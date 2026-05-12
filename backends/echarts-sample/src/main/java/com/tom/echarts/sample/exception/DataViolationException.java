package com.tom.echarts.sample.exception;

import org.springframework.http.HttpStatus;

@SuppressWarnings("serial")
public class DataViolationException extends GlobalRuntimeException {

	public DataViolationException(String message) {
		super(message, HttpStatus.CONFLICT);
	}

	public DataViolationException(String message, Throwable cause) {
		super(message, cause, HttpStatus.CONFLICT);
	}
}
