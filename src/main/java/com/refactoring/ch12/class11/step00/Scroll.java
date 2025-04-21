package com.refactoring.ch12.class11.step00;

import com.refactoring.ch12.class11.CatalogItem;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;

public class Scroll extends CatalogItem {
	private final LocalDate lastCleaned;

	public Scroll(int id, String title, List<String> tags, LocalDate dateLastCleaned) {
		super(id, title, tags);
		this.lastCleaned = dateLastCleaned;
	}

	public boolean needsCleaning(LocalDate targetDate) {
		int threshold = this.hasTag("revered") ? 700 : 1500;
		return this.daysSinceLastCleaning(targetDate) > threshold;
	}

	private long daysSinceLastCleaning(LocalDate targetDate) {
		return this.lastCleaned.until(targetDate, ChronoUnit.DAYS);
	}
}
