package com.refactoring.ch08.class07;

import java.util.List;

public class Calculator {
	// 전체 급여와 가장 나이가 적은 값을 계산한다
	public String calculateYoungestAndTotalSalary(List<Person> people) {
		return String.format("youngest: %d, totalSalary: %d", youngestAge(people), totalSalary(people));
	}

	private int youngestAge(List<Person> people) {
		return people.stream()
			.mapToInt(Person::getAge)
			.min()
			.orElse(Integer.MAX_VALUE);
	}

	private int totalSalary(List<Person> people) {
		return people.stream()
			.mapToInt(Person::getSalary)
			.sum();
	}
}
