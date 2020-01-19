package com.advent.dayTwo;

import java.util.Optional;
import java.util.Scanner;

public class DayTwoPartTwo
{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Please provide input: ");
        String input = scanner.nextLine();
        System.out.print("Please provide output to find: ");
        String searchOutput = scanner.nextLine();

        InputPairsFinder finder = new InputPairsFinder(input, Integer.parseInt(searchOutput));

        Optional<Opcode> opcode = finder.search();
        if (opcode.isPresent()) {
            System.out.println("Found input pairs: " + opcode.get().getOpcodes()[1] + " " + opcode.get().getOpcodes()[2]);
        } else {
            System.out.println("Could not found matching input pairs to provided output");
        }
    }
}
