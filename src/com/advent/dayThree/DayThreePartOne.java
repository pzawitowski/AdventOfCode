package com.advent.dayThree;

import java.util.Scanner;

public class DayThreePartOne {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Please provide first wire: ");
        String wire1Input = scanner.nextLine();
        System.out.print("Please provide second wire: ");
        String wire2Input = scanner.nextLine();

        Wire wire1 = new Wire(wire1Input);
        Wire wire2 = new Wire(wire2Input);

        WireCrossingFinder crossingFinder = new WireCrossingFinder(wire1, wire2);
        int closestDistance = crossingFinder.findClosestCrossingDistance();
        System.out.println("Closest crossing distance is: " + closestDistance); // should be 1084
    }
}
