package com.refactoring.ch12.class10.step01;

import java.util.List;

public class Show {

	private final int price;
	private final List<String> owns;

	public Show(int price, List<String> owns) {
		this.price = price;
		this.owns = owns;
	}

	public boolean hasOwnProperty(String property) {
		return owns.contains(property);
	}

	public int getPrice() {
		return price;
	}
}
