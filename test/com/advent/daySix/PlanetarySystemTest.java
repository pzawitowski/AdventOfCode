package com.advent.daySix;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class PlanetarySystemTest {
    PlanetarySystem planetarySystem;

    @Before
    public void setupPlanetarySystem() {
        planetarySystem = new PlanetarySystem();

        planetarySystem.addOrbitingPlanet("A)B");
        planetarySystem.addOrbitingPlanet("C)D");
        planetarySystem.addOrbitingPlanet("C)E");
        planetarySystem.addOrbitingPlanet("E)F");
    }

    @Test
    public void testAddedPlanets() {
        assertEquals(6, planetarySystem.getAllPlanets().size());

        assertTrue(planetarySystem.getAllPlanets().containsKey("A"));
        assertTrue(planetarySystem.getAllPlanets().containsKey("B"));
        assertTrue(planetarySystem.getAllPlanets().containsKey("C"));
        assertTrue(planetarySystem.getAllPlanets().containsKey("D"));
        assertTrue(planetarySystem.getAllPlanets().containsKey("E"));
        assertTrue(planetarySystem.getAllPlanets().containsKey("F"));
    }

    @Test
    public void testOrbits() {
        assertTrue(planetarySystem.getAllPlanets().get("A").getOrbitedPlanet() == null);
        assertEquals("A", planetarySystem.getAllPlanets().get("B").getOrbitedPlanet().getName());
        assertEquals("C", planetarySystem.getAllPlanets().get("D").getOrbitedPlanet().getName());
        assertEquals("C", planetarySystem.getAllPlanets().get("E").getOrbitedPlanet().getName());

    }

    @Test
    public void testCalculateDirectOrbits() {
        assertEquals(4, planetarySystem.calculateDirectOrbits());
    }

    @Test
    public void testCalculateDirectAndIndirectOrbits() {
        assertEquals(5, planetarySystem.calculateIndirectAndDirectOrbits());
    }

    @Test
    public void testAdventOfCodeExample() {
        PlanetarySystem planetarySystem = new PlanetarySystem();
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

        assertEquals(42, planetarySystem.calculateIndirectAndDirectOrbits());
    }

    @Test
    public void testAdventOfCodeExampleWithDifferentOrder() {
        PlanetarySystem planetarySystem = new PlanetarySystem();
        planetarySystem.addOrbitingPlanet("K)L");
        planetarySystem.addOrbitingPlanet("B)C");
        planetarySystem.addOrbitingPlanet("C)D");
        planetarySystem.addOrbitingPlanet("E)F");
        planetarySystem.addOrbitingPlanet("B)G");
        planetarySystem.addOrbitingPlanet("D)E");
        planetarySystem.addOrbitingPlanet("G)H");
        planetarySystem.addOrbitingPlanet("D)I");
        planetarySystem.addOrbitingPlanet("E)J");
        planetarySystem.addOrbitingPlanet("J)K");

        planetarySystem.addOrbitingPlanet("COM)B");

        assertEquals(42, planetarySystem.calculateIndirectAndDirectOrbits());
    }

}
