package com.advent.daySix;

import java.util.ArrayList;
import java.util.List;

public class OrbitsTransferCalculator {

    private PlanetarySystem planetarySystem;


    public OrbitsTransferCalculator(PlanetarySystem planetarySystem) {

        this.planetarySystem = planetarySystem;
    }

    public int calculateMinimumNoOfOrbitsTransferBetween(String firstPlanetName, String secondPlanetName) {
        List<String> orbitsPathFirstPlanet = generatePathForPlanet(firstPlanetName);
        List<String> orbitsPathSecondPlanet = generatePathForPlanet(secondPlanetName);

        return calculateNumberOfOrbitsForFirstCrossing(orbitsPathFirstPlanet, orbitsPathSecondPlanet) +
            calculateNumberOfOrbitsForFirstCrossing(orbitsPathSecondPlanet, orbitsPathFirstPlanet);

    }

    private int calculateNumberOfOrbitsForFirstCrossing(List<String> orbitsPathFirstPlanet, List<String> orbitsPathSecondPlanet) {
        int numberOfOrbits = 0;
        for (String planet: orbitsPathFirstPlanet) {
            if (orbitsPathSecondPlanet.contains(planet)) {
                return numberOfOrbits;
            }
            numberOfOrbits++;
        }
        return numberOfOrbits;
    }

    public List<String> generatePathForPlanet(String planetName) {
        List<String> orbitsPath = new ArrayList<>();
        Planet planet = planetarySystem.getPlanetOrbitedBy(planetName);

        while (planet != null) {
            orbitsPath.add(planet.getName());
            planet = planet.getOrbitedPlanet();
        }

        return orbitsPath;
    }



}
