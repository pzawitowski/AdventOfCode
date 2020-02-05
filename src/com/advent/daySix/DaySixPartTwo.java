package com.advent.daySix;

import java.util.Scanner;

public class DaySixPartTwo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line;
        PlanetarySystem planetarySystem = new PlanetarySystem();
        while (!(line = scanner.nextLine()).equals("OVER")) {
            planetarySystem.addOrbitingPlanet(line);
        }
        String firstPlanet;
        String secondPlanet;

        System.out.println("Please provide first planet name:");
        firstPlanet = scanner.nextLine();
        System.out.println("Please provide second planet name:");
        secondPlanet = scanner.nextLine();

        OrbitsTransferCalculator orbitsTransferCalculator = new OrbitsTransferCalculator(planetarySystem);
        System.out.println("Minimum number of orbits transfer: " + orbitsTransferCalculator.calculateMinimumNoOfOrbitsTransferBetween(firstPlanet, secondPlanet));
    }
}
