package com.advent.dayTwo;

import java.util.Arrays;

public class Opcode {
    public static final int ADD = 1;
    public static final int MULTIPLY = 2;
    public static final int OPERATION_END = 99;

    int opcodes[];

    public Opcode(int[] opcodes) {
        this.opcodes = opcodes;
    }

    public void processOpcodes() {
        int startPosition = 0;

        while (opcodes[startPosition] != OPERATION_END) {
            processOpcode(startPosition);
            startPosition += 4;
        }
    }

    private void processOpcode(int startPosition) {
        int resultPosition = opcodes[startPosition + 3];
        int firstArgument = opcodes[opcodes[startPosition + 1]];
        int secondArgument = opcodes[opcodes[startPosition + 2]];
        if (opcodes[startPosition] == ADD) {
            opcodes[resultPosition] = firstArgument + secondArgument;
        } else {
            opcodes[resultPosition] = firstArgument * secondArgument;
        }
    }


    public static Opcode fromString(String opcode) {
        return new Opcode((Arrays.asList(opcode.split(",")).stream().mapToInt(Integer::parseInt).toArray()));
    }

    public int[] getOpcodes() {
        return opcodes;
    }

    public String getOpcodesAsString() {
        return Arrays.toString(opcodes).replaceAll("[\\[\\] ]", "");
    }


}
