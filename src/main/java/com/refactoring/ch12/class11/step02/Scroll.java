package com.refactoring.ch12.class11.step02;

import com.refactoring.ch12.class11.CatalogItem;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;

public class Scroll {
	private final int id;
	private final LocalDate lastCleaned;
	private final CatalogItem catalogItem;

	public Scroll(int id, LocalDate dateLastCleaned, int catalogId, Catalog catalog) {
		this.id = id;
		this.catalogItem = catalog.get(catalogId);
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
		return catalogItem.getId();
	}

	public String getTitle() {
		return catalogItem.getTitle();
	}

	public boolean hasTag(String tag) {
		return catalogItem.hasTag(tag);
	}
}
