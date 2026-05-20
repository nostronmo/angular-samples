package com.tom.echarts.sample.music.model;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@ToString(onlyExplicitlyIncluded = true)
@Table(name = "correlation_heatmap")
@IdClass(CorrelationHeatmap.CorrelationId.class)
public class CorrelationHeatmap {

	@Id
	@Column(name = "feature_x")
	private String featureX;

	@Id
	@Column(name = "feature_y")
	private String featureY;

	@Column(name = "correlation_value")
	private Double correlationValue;

	@Getter
	@Setter
	@NoArgsConstructor
	@AllArgsConstructor
	public static class CorrelationId implements Serializable {
		private String featureX;
		private String featureY;
	}
}
