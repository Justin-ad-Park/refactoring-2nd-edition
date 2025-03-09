package com.refactoring.ch08.class05;

import java.util.List;

public class State {
	private String name;

	public State(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public static void main(String[] args) {
		List<State> states = List.of(new State("MA"), new State("NY"), new State("CA"));
		boolean appliesToMass = isAppliesToMass(states, "MA");
		System.out.println("appliesToMass = " + appliesToMass);
	}

	private static boolean isAppliesToMass(List<State> states, String name) {
		return states.stream()
			.map(State::getName)
			.anyMatch(n->n.equals(name));
	}
}
