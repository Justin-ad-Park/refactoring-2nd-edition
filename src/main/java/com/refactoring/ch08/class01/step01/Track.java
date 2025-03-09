package com.refactoring.ch08.class01.step01;

import java.util.Objects;

public class Track {
	private final int time;
	private final double distance;
	private final double pace;

	public Track(int time, double distance, double pace) {
		this.time = time;
		this.distance = distance;
		this.pace = pace;
	}

	public int getTime() {
		return time;
	}

	public double getDistance() {
		return distance;
	}

	public double getPace() {
		return pace;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Track track = (Track)o;
		return time == track.time && Double.compare(distance, track.distance) == 0
			&& Double.compare(pace, track.pace) == 0;
	}

	@Override
	public int hashCode() {
		return Objects.hash(time, distance, pace);
	}

	@Override
	public String toString() {
		return "Track{" +
			"time=" + time +
			", distance=" + distance +
			", pace=" + pace +
			'}';
	}
}
