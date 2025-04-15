package com.refactoring.ch11.class06;

public class HeatingPlan_00 {

    private final int min;
    private final int max;
    private final Thermostat thermostat;

    public HeatingPlan_00(int min, int max) {
        this.min = min;
        this.max = max;
        this.thermostat = new Thermostat(25);
    }

    public int targetTemperature( ) {
        if (thermostat.selectedTemperature() > max) {
            return max;
        } else if (thermostat.selectedTemperature() < min) {
            return min;
        }
        return thermostat.selectedTemperature();
    }
}