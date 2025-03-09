package com.refactoring.ch11.class01.step01;

import org.apache.logging.log4j.util.Strings;

import java.util.List;

public class VillainDetector {
	public String findMiscreant(List<String> people) {
		for (String p : people){
			if (p.equals("jocker")){
				return "jocker";
			}
			if (p.equals("saruman")){
				return "saruman";
			}
		}
		return Strings.EMPTY;
	}

	public void alertForMiscreant(List<String> people) {
		if (findMiscreant(people).isEmpty()){
			return;
		}
		sendAlert();
	}

	private void sendAlert() {
		System.out.println("alert villain!!");
	}
}
