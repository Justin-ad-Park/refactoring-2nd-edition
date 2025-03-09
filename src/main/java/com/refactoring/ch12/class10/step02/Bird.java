package com.refactoring.ch12.class10.step02;

public class Bird {

	private final String name;
	private final String plumage; // 깃털
	private final SpeciesDelegate speciesDelegate;

	public Bird(BirdInfo data) {
		this.name = data.getName();
		this.plumage = data.getPlumage();
		this.speciesDelegate = this.selectSpeciesDelegate(data);
	}

	private SpeciesDelegate selectSpeciesDelegate(BirdInfo data) {
		return switch (data.getType()) {
			case "유럽 제비" -> new EuropeanSwallowDelegate(this);
			case "아프리카 제비" -> new AfricanSwallowDelegate(data, this);
			case "노르웨이 파란 앵무" -> new NorwegianBlueParrotDelegate(data, this);
			default -> new SpeciesDelegate(data, this);
		};
	}

	public static Bird createBird(BirdInfo data) {
		return new Bird(data);
	}

	public String getName() {
		return name;
	}

	public String getPlumage() {
		return this.speciesDelegate.getPlumage();
	}

	public int getAirSpeedVelocity() {
		return this.speciesDelegate.getAirSpeedVelocity();
	}

	public Object getSpeciesDelegate() {
		return speciesDelegate;
	}
}
