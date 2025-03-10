package com.refactoring.ch06._08_introduceParameterObject.step02;

public class NumberRange {
	private final int min;
	private final int max;

	public NumberRange(int min, int max) {
		this.min = min;
		this.max = max;
	}

	/**
	 * NumberRange 내부 멤버값의 의존성이 높은 범위 연산 로직을
	 * NuberRange 클래스로 옮긴다.
	 * - OCP : Open Closed Priciple 개방폐쇄의 원칙
	 *
	 * @param value
	 * @return
	 */
	public boolean contains(int value) {
		return value >= min && value <= max;
	}
}
