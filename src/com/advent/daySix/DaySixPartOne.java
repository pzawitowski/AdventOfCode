package com.advent.daySix;

import java.util.Scanner;

public class DaySixPartOne {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line;
        PlanetarySystem planetarySystem = new PlanetarySystem();
        while (!(line = scanner.nextLine()).equals("OVER")) {
            planetarySystem.addOrbitingPlanet(line);
        }

        System.out.println("Orbits number: " + planetarySystem.calculateIndirectAndDirectOrbits());
    }
}
