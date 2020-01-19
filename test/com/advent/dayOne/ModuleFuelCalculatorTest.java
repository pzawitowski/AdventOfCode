package com.advent.dayOne;

import com.advent.dayOne.FuelCalculator;
import com.advent.dayOne.ModuleFuelCalculator;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ModuleFuelCalculatorTest {

    FuelCalculator fuelCalculator;

    @Before
    public void setUp() {
        fuelCalculator = new ModuleFuelCalculator();
    }

    @Test
    public void testCalculation() {
        assertEquals(2, fuelCalculator.calculateFuel(12));
        assertEquals(2, fuelCalculator.calculateFuel(14));
        assertEquals(654, fuelCalculator.calculateFuel(1969));
        assertEquals(33583, fuelCalculator.calculateFuel(100756));
    }
}
