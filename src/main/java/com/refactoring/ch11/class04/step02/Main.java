package com.refactoring.ch11.class04.step02;

public class Main {
	public static void main(String[] args) {
		Room room = new Room(new TemperatureRange(19, 20));
		TemperatureRange tempRange = room.getDaysTempRange();
		HeatingPlan heatingPlan = new HeatingPlan(new TemperatureRange(20, 30));
		boolean isWithinRange = heatingPlan.withinRange(tempRange);
		if (!isWithinRange){
			System.out.println("방 온도가 지정 범위를 벗어났습니다.");
		}
	}
}
