package com.advent.daySeven;

import java.util.Scanner;

public class DaySevenPartOne {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line;
        line = scanner.nextLine();
        AmplifierSeries amplifierSeries = new AmplifierSeries(5, line);

        System.out.println("Largest output: " + amplifierSeries.findLargestOutput());
    }
}
