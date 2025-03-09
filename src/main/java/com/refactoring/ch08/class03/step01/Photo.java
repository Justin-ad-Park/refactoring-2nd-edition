package com.refactoring.ch08.class03.step01;

import java.time.LocalDate;

public class Photo {
	private String title;
	private String location;
	private String url;
	private LocalDate date;

	public Photo(String title, String location, String url, LocalDate date) {
		this.title = title;
		this.location = location;
		this.url = url;
		this.date = date;
	}

	public String getTitle() {
		return title;
	}

	public String getLocation() {
		return location;
	}

	public String getUrl() {
		return url;
	}

	public LocalDate getData() {
		return date;
	}
}
