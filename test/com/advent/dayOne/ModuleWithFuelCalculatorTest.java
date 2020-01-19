package com.advent.dayOne;

import com.advent.dayOne.FuelCalculator;
import com.advent.dayOne.ModuleWithFuelCalculator;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ModuleWithFuelCalculatorTest {
    FuelCalculator fuelCalculator;

    @Before
    public void setUp() {
        fuelCalculator = new ModuleWithFuelCalculator();
    }

    @Test
    public void calculateRequiredFuelWithFuelMass() {

        assertEquals(2, fuelCalculator.calculateFuel(14));
        assertEquals(966, fuelCalculator.calculateFuel(1969));
        assertEquals(50346, fuelCalculator.calculateFuel(100756));

    }
}
