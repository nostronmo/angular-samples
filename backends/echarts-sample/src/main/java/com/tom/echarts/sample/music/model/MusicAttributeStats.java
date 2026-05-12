package com.tom.echarts.sample.music.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
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
@Table(name = "music_attribute_stats")
public class MusicAttributeStats {

	@Id
	@ToString.Include
	@Column(name = "attribute_name")
	private String attributeName;

	@ToString.Include
	@Column(name = "min_value", nullable = false)
	private Double minValue;

	@ToString.Include
	@Column(name = "max_value", nullable = false)
	private Double maxValue;

}
