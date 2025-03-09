package com.refactoring.ch12.class11.step01;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;

public class Scroll {
	private final int id;
	private final LocalDate lastCleaned;
	private final CatalogItem catalogItem;

	public Scroll(int id, String title, List<String> tags, LocalDate dateLastCleaned) {
		this.id = id;
		this.catalogItem = new CatalogItem(id, title, tags);
		this.lastCleaned = dateLastCleaned;
	}

	public boolean needsCleaning(LocalDate targetDate) {
		int threshold = this.hasTag("revered") ? 700 : 1500;
		return this.daysSinceLastCleaning(targetDate) > threshold;
	}

	private long daysSinceLastCleaning(LocalDate targetDate) {
		return this.lastCleaned.until(targetDate, ChronoUnit.DAYS);
	}

	public int getId() {
		return this.id;
	}

	public String getTitle() {
		return catalogItem.getTitle();
	}

	public boolean hasTag(String tag) {
		return catalogItem.hasTag(tag);
	}
}
