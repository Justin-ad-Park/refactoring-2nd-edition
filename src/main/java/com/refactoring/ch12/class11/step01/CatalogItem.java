package com.refactoring.ch12.class11.step01;

import java.util.List;

public class CatalogItem {
	private final int id;
	private final String title;
	private final List<String> tags;

	public CatalogItem(int id, String title, List<String> tags) {
		this.id = id;
		this.title = title;
		this.tags = tags;
	}

	public int getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public boolean hasTag(String tag) {
		return tags.contains(tag);
	}
}
