package com.refactoring.ch06._06_encapsulateVariable;

public class SpaceShip {
	private Owner owner;

	public SpaceShip(Owner owner) {
		this.owner = owner;
	}

	public Owner getOwner() {
		return owner;
	}

	public void setOwner(Owner owner) {
		this.owner = owner;
	}
}
