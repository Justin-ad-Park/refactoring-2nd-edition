package com.refactoring.ch10.class04.step01;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class BirdAnalyzer {

	public Map<String, String> plumages(List<Bird> birds){
		return birds.stream()
			.map(this::createBird)
			.collect(Collectors.toMap(Bird::getName, Bird::plumage));
	}

	private Bird createBird(Bird bird) {
		return switch (bird.getType()){
			case "유럽 제비" -> new EuropeanSwallow(bird);
			case "아프리카 제비" -> new AfricanSwallow(bird);
			case "노르웨이 파란 앵무" -> new NorwegianBlueParrot(bird);
			default -> new Bird(bird);
		};
	}

	public Map<String, Integer> speeds(List<Bird> birds){
		return birds.stream()
			.map(this::createBird)
			.collect(Collectors.toMap(Bird::getName, Bird::airSpeedVelocity));
	}
}
