package com.refactoring.ch07.class09.step01;

import java.util.List;

public class Person {
	private String name;

	public Person(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public static String foundPerson(List<Person> persons){
		List<String> candidates = List.of("Don", "John", "Kent");
		return persons.stream()
			.filter(p->candidates.contains(p.getName()))
			.findFirst()
			.map(Person::getName)
			.orElse("");
	}
}
