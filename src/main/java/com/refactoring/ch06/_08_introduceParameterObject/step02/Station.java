package com.refactoring.ch06._08_introduceParameterObject.step02;

import java.util.List;

public class Station {
	private String name;
	private List<Temperature> readings;

	public Station(String name, List<Temperature> readings) {
		this.name = name;
		this.readings = readings;
	}

	/**
	 * min, max의 허용 범위를 계산하던 로직을 NumberRange의 contains 메서드로 옮겨서
	 * OCP(Open Closed Principle) 원칙을 준수함.
	 * 결과적으로 readingsOutsideRange 메서드의 로직도 간결하게 됨
	 *
	 * @param range
	 * @return
	 */
	public List<Temperature> readingsOutsideRange(NumberRange range) {
		return readings.stream()
			.filter(t->!range.contains(t.getTemperature()))
			.toList();
	}
}
