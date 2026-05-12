package com.tom.echarts.sample.exception;

import java.util.Map;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({ "status", "error", "message", "path" })
public record ErrorResponse(Map<String, String> errorResponse) {

}
