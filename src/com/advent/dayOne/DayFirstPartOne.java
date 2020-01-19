package com.advent.dayOne;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DayFirstPartOne {

    public static void main(String[] args) {
        String line;
        Scanner scanner = new Scanner(System.in);
        List<Integer> modules = new ArrayList<>();
        while (!(line = scanner.nextLine()).equals("END") ) {
            modules.add(Integer.valueOf(line));
        }
        FuelCalculator calculator = new ModuleFuelCalculator();
        ShipFuelCalculator shipFuelCalculator = new ShipFuelCalculator(modules, calculator);
        System.out.println("Required fuel: " + shipFuelCalculator.getRequiredFuel());
    }
}
