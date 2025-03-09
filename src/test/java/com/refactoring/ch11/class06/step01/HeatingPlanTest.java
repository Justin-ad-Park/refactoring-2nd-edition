package com.refactoring.ch11.class06.step01;

import com.refactoring.ch11.class06.step01.HeatingPlan;
import com.refactoring.ch11.class06.step01.Thermostat;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class HeatingPlanTest {

	@DisplayName("온도를 설정하지만 목표 온도는 난방 계획 안에 존재한다")
	@Test
	void targetTemperature() {
		// given
		HeatingPlan heatingPlan = new HeatingPlan(20, 30);
		Thermostat thermostat = new Thermostat(25);
		if (heatingPlan.targetTemperature(thermostat.selectedTemperature()) > thermostat.selectedTemperature()) {
			setToHeat();
		} else if (heatingPlan.targetTemperature(thermostat.selectedTemperature())
			< thermostat.selectedTemperature()) {
			setToCold();
		} else {
			setOff();
		}
		// when
		int temperature = heatingPlan.targetTemperature(25);
		// then
		Assertions.assertThat(temperature).isEqualTo(25);
	}

	private void setToHeat() {
		System.out.println("increase hot");
	}

	private void setToCold() {
		System.out.println("increase cold");
	}

	private void setOff() {
		System.out.println("turn off");
	}

}
