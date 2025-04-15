package com.refactoring.ch11.class06;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HeatingPlan_step02Test {

    @DisplayName("온도를 설정하지만 목표 온도는 난방 계획 안에 존재한다")
    @Test
    void targetTemperature() {
        // given
        HeatingPlan_step01 heatingPlanStep01 = new HeatingPlan_step01(20, 30);
        Thermostat thermostat = new Thermostat(25);
        if (heatingPlanStep01.targetTemperature() > thermostat.selectedTemperature()) {
            setToHeat();
        } else if (heatingPlanStep01.targetTemperature()
                < thermostat.selectedTemperature()) {
            setToCold();
        } else {
            setOff();
        }
        // when
        int temperature = heatingPlanStep01.targetTemperature();
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