package com.spittr.web.bean;

import java.util.Date;

public class Spittle {
	private Long Id;
	private final String message;
	private final Date time;
	private Double longitude;
	private Double latitude;

	public Spittle(Long id, String message, Date time) {
		this(message,time);
		this.Id = id;
	}

	public Spittle(String message, Date time) {
		this(message, time, null, null);
	}

	public Spittle(String message, Date time, Double longitude, Double latitude) {
		this.Id = null;
		this.message = message;
		this.time = time;
		this.longitude = longitude;
		this.latitude = latitude;
	}

	public Double getLongitude() {
		return longitude;
	}

	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}

	public Double getLatitude() {
		return latitude;
	}

	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}

	public Long getId() {
		return Id;
	}

	public String getMessage() {
		return message;
	}

	public Date getTime() {
		return time;
	}

}
