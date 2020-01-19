package com.advent.dayTwo;

import java.util.Scanner;

public class DayTwoPartOne {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String opcodes = scanner.nextLine();
        Opcode opcode = Opcode.fromString(opcodes);
        opcode.processOpcodes();
        System.out.println(opcode.getOpcodesAsString());
    }
}
