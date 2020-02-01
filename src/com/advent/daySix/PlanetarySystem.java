package com.advent.daySix;

import java.util.HashMap;
import java.util.Map;

public class PlanetarySystem {
    private Map<String, Planet> allPlanets = new HashMap<>();


    public void addOrbitingPlanet(String orbitRepresentation) {
        String planetNames[] = orbitRepresentation.split("\\)");
        if (planetNames.length != 2) {
            throw  new IllegalArgumentException("Invalid orbit representation");
        }

        Planet orbitedPlanet = allPlanets.get(planetNames[0]);
        Planet orbitingPlanet = allPlanets.get(planetNames[1]);

        if (orbitedPlanet == null) {
            orbitedPlanet = new Planet(planetNames[0]);
            allPlanets.put(planetNames[0], orbitedPlanet);
        }

        if (orbitingPlanet == null) {
            orbitingPlanet = new Planet(planetNames[1]);
            allPlanets.put(planetNames[1], orbitingPlanet);
        }

        orbitedPlanet.addOrbitingPlanet(orbitingPlanet);
    }

    public Map<String, Planet> getAllPlanets() {
        return allPlanets;
    }



    public int calculateDirectOrbits() {
        int orbitsNumber = 0;
        for (Planet planet: allPlanets.values()) {
            if (planet.orbitsPlanet()) {
                orbitsNumber++;
            }
        }
        return orbitsNumber;
    }

    public int calculateIndirectOrbits() {
        return 0;
    }

    public int calculateIndirectAndDirectOrbits() {
        int numberOfOrbits = 0;
        for (Planet planet: allPlanets.values()) {
            if (planet.getOrbitedPlanet() == null) {
                numberOfOrbits += calculateOrbits(planet);
            }
        }

        return numberOfOrbits;
    }

    private int calculateOrbits(Planet planet){
        int numberOfOrbits = planet.getOrbitHeight();
        if(!planet.getOrbitedByPlanets().isEmpty()) {
            for (Planet orbitingPlanet: planet.getOrbitedByPlanets()) {
                numberOfOrbits += calculateOrbits(orbitingPlanet);
            }
        }

        return numberOfOrbits;
    }
}
