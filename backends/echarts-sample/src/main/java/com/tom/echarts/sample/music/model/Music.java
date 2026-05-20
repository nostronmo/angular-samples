package com.tom.echarts.sample.music.model;

import com.tom.echarts.sample.global.Auditable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Index;
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
@Table(name = "spotify_tracks", indexes = {
		@Index(columnList = "track_genre, popularity, danceability, energy", name = "idx_radar_performance"),
		@Index(columnList = "danceability, energy, speechiness, acousticness, instrumentalness, valence", name = "idx_genre_stats") })
public class Music extends Auditable {

	@Id
	@ToString.Include
	@Column(name = "id")
	private Integer id;

	@ToString.Include
	@Column(name = "track_id", nullable = false, unique = true)
	private String trackId;

	@ToString.Include
	@Column(name = "artists", nullable = true)
	private String artists;

	@ToString.Include
	@Column(name = "album_name")
	private String albumName;

	@ToString.Include
	@Column(name = "track_name")
	private String trackName;

	@ToString.Include
	@Column(name = "popularity")
	private Integer popularity;

	@ToString.Include
	@Column(name = "duration_ms")
	private Integer durationMs;

	@ToString.Include
	@Column(name = "explicit")
	private Boolean explicit;

	@ToString.Include
	@Column(name = "danceability")
	private Float danceability;

	@ToString.Include
	@Column(name = "energy")
	private Float energy;

	@ToString.Include
	@Column(name = "key")
	private String key;

	@ToString.Include
	@Column(name = "loudness")
	private Float loudness;

	@ToString.Include
	@Column(name = "mode")
	private Integer mode;

	@ToString.Include
	@Column(name = "speechiness")
	private Float speechiness;

	@ToString.Include
	@Column(name = "acousticness")
	private Float acousticness;

	@ToString.Include
	@Column(name = "instrumentalness")
	private Float instrumentalness;

	@ToString.Include
	@Column(name = "liveness")
	private Float liveness;

	@ToString.Include
	@Column(name = "valence")
	private Float valence;

	@ToString.Include
	@Column(name = "tempo")
	private Float tempo;

	@ToString.Include
	@Column(name = "time_signature")
	private Integer timeSignature;

	@ToString.Include
	@Column(name = "track_genre")
	private String trackGenre;

}
