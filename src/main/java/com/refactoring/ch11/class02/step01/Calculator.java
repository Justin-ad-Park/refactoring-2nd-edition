package com.refactoring.ch11.class02.step01;

public class Calculator {
	public int tenPercentRaise(Person person){
		return raise(person, 0.1);
	}

	public int fivePercentRaise(Person person){
		return raise(person, 0.05);
	}

	private int raise(Person person, double factor) {
		return (int)(person.getSalary() * (1 + factor));
	}
}
