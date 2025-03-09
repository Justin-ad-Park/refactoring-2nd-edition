package com.refactoring.ch06.class08;

import java.time.LocalDateTime;

public class Temperature {
	private int temperature;
	private LocalDateTime time;

	public Temperature(int temperature, LocalDateTime time) {
		this.temperature = temperature;
		this.time = time;
	}

	public int getTemperature() {
		return temperature;
	}
}
