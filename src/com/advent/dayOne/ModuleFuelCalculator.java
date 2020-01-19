package com.advent.dayOne;

public class ModuleFuelCalculator implements FuelCalculator {
    public int calculateFuel(int moduleMass) {
        return moduleMass / 3 - 2;
    }
}
