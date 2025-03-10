package com.refactoring.ch06._08_introduceParameterObject.step01;

/**
 * Introduce Parameter Object (파라미터 객체를 도입한다.)
 * min, max 파라미터가 합쳐진 NumberRange 클래스를 만들고,
 * Station(클래스).readingsOutsideRange(메서드)의 파라미터를 NumberRange로 변경한다.
 */
public class NumberRange {
	private final int min;
	private final int max;

	public NumberRange(int min, int max) {
		this.min = min;
		this.max = max;
	}

	public int getMin() {return min;}
	public int getMax() {return max;}
}
