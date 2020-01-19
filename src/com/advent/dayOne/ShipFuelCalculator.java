package com.advent.dayOne;

import java.util.List;

public class ShipFuelCalculator {
    private FuelCalculator fuelCalculator;
    private List<Integer> modulesMasses;

    public ShipFuelCalculator(List<Integer> modulesMasses, FuelCalculator calculator) {
        this.modulesMasses = modulesMasses;
        fuelCalculator = calculator;
    }

    public int getRequiredFuel() {
        return modulesMasses.stream().map(m -> fuelCalculator.calculateFuel(m)).mapToInt(Integer::intValue).sum();
    }


}
