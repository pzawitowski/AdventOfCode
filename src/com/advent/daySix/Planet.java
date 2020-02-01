package com.advent.daySix;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Planet {
    private String name;
    private int orbitHeight = 0;

    private Planet orbitedPlanet;

    private List<Planet> orbitedByPlanets = new ArrayList<>();

    public Planet(String name) {
        this.name = name;
        this.orbitHeight = orbitHeight;
    }

    public Planet getOrbitedPlanet() {
        return orbitedPlanet;
    }

    public void setOrbitedPlanet(Planet orbitedPlanet) {
        this.orbitedPlanet = orbitedPlanet;
    }

    public List<Planet> getOrbitedByPlanets() {
        return orbitedByPlanets;
    }

    public void setOrbitedByPlanets(List<Planet> orbitedByPlanets) {
        this.orbitedByPlanets = orbitedByPlanets;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean orbitsPlanet() {
        return orbitedPlanet != null;
    }

    public void addOrbitingPlanet(Planet planet) {
        orbitedByPlanets.add(planet);
        planet.setOrbitedPlanet(this);
        planet.setOrbitHeight(orbitHeight + 1);
        planet.updateOrbits(orbitHeight);
    }

    private void updateOrbits(int orbitHeight) {
        this.orbitHeight = orbitHeight + 1;
        for (Planet planet: orbitedByPlanets) {
            planet.updateOrbits(this.orbitHeight);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Planet planet = (Planet) o;
        return Objects.equals(name, planet.name);
    }

    public void setOrbitHeight(int orbitHeight) {
        this.orbitHeight = orbitHeight;
    }

    public int getOrbitHeight() {
        return orbitHeight;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
