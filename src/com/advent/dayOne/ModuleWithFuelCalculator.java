package com.advent.dayOne;

public class ModuleWithFuelCalculator implements FuelCalculator {
    @Override
    public int calculateFuel(int mass) {
        int fuel = mass / 3 - 2;
        if (fuel <= 0) {
            return 0;
        } else {
            return fuel + calculateFuel(fuel);
        }
    }
}
