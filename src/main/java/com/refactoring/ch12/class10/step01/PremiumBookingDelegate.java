package com.refactoring.ch12.class10.step01;

import java.util.List;

public class PremiumBookingDelegate {
	private final Booking host;
	private final List<Extra> extras;

	public PremiumBookingDelegate(Booking hostBooking, List<Extra> extras) {
		this.host = hostBooking;
		this.extras = extras;
	}

	public boolean hasTalkback() {
		return host.show.hasOwnProperty("talkback");
	}

	public int extendBasePrice(int base) {
		return base + this.extras.stream()
			.mapToInt(Extra::getFee)
			.sum();
	}

	public boolean hasDinner() {
		return extras.stream()
			.map(Extra::getName)
			.anyMatch(name -> name.equals("dinner"))
			&& !this.host.isPeakDay();
	}
}
