package com.refactoring.ch11.class03.step02;

import java.time.LocalDate;

public class Order {

	private final String deliveryState;
	private final LocalDate placedOn;

	public Order(String deliveryState, LocalDate placedOn) {
		this.deliveryState = deliveryState;
		this.placedOn = placedOn;
	}

	public String getDeliveryState() {
		return deliveryState;
	}

	public LocalDate getPlacedOn() {
		return placedOn;
	}
}
