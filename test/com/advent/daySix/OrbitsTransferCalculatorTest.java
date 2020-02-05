package com.advent.daySix;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class OrbitsTransferCalculatorTest {
    PlanetarySystem planetarySystem;

    @Before
    public void setUpPlanetarySystem() {
        planetarySystem = new PlanetarySystem();
        planetarySystem.addOrbitingPlanet("COM)B");
        planetarySystem.addOrbitingPlanet("B)C");
        planetarySystem.addOrbitingPlanet("C)D");
        planetarySystem.addOrbitingPlanet("D)E");
        planetarySystem.addOrbitingPlanet("E)F");
        planetarySystem.addOrbitingPlanet("B)G");
        planetarySystem.addOrbitingPlanet("G)H");
        planetarySystem.addOrbitingPlanet("D)I");
        planetarySystem.addOrbitingPlanet("E)J");
        planetarySystem.addOrbitingPlanet("J)K");
        planetarySystem.addOrbitingPlanet("K)L");
        planetarySystem.addOrbitingPlanet("K)YOU");
        planetarySystem.addOrbitingPlanet("I)SAN");
    }

    @Test
    public void testCalculateNumberOfOrbits() {
        OrbitsTransferCalculator orbitsTransferCalculator = new OrbitsTransferCalculator(planetarySystem);

        assertEquals(4, orbitsTransferCalculator.calculateMinimumNoOfOrbitsTransferBetween("YOU", "SAN"));
        assertEquals(5, orbitsTransferCalculator.calculateMinimumNoOfOrbitsTransferBetween("YOU", "G"));
        assertEquals(6, orbitsTransferCalculator.calculateMinimumNoOfOrbitsTransferBetween("YOU", "H"));
    }
}
