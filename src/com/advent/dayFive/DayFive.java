package com.advent.dayFive;

import com.advent.dayTwo.Opcode;

import java.util.Scanner;

/**
 *
 */
public class DayFive {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Please provide input: ");
        int input = Integer.parseInt(scanner.nextLine());
        System.out.print("Please provide instructions: ");
        String instructions = scanner.nextLine();

        Opcode opcode = Opcode.fromString(instructions);
        opcode.setInput(input);

        opcode.processOpcodes();

        System.out.println(opcode.getOutput());

    }
}
