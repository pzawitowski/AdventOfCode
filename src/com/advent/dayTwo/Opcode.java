package com.advent.dayTwo;

import com.advent.dayTwo.OpcodeInstruction.Instruction;
import com.advent.dayTwo.OpcodeInstruction.ParameterMode;

import java.util.Arrays;

import static com.advent.dayTwo.OpcodeInstruction.Instruction.INPUT;
import static com.advent.dayTwo.OpcodeInstruction.Instruction.OUTPUT;

public class Opcode {
    public static final int ADD = 1;
    public static final int MULTIPLY = 2;
    public static final int OPERATION_END = 99;

    private int opcodes[];
    private int input;
    private int output;

    public Opcode(int[] opcodes) {
        this.opcodes = opcodes;
    }

    public Opcode(int[] opcodes, int input) {
        this(opcodes);
        this.input = input;
    }

    public void processOpcodes() {
        int startPosition = 0;

        while (opcodes[startPosition] != OPERATION_END) {
            startPosition += processOpcode(startPosition);
        }
    }

    private int processOpcode(int startPosition) {
        int firstArgument;
        int secondArgument;
        int resultPosition;
        int positionMovement = 4;
        OpcodeInstruction opcodeInstruction = new OpcodeInstruction(opcodes[startPosition]);

        if (opcodeInstruction.getInstruction() == INPUT || opcodeInstruction.getInstruction() == OUTPUT) {
            resultPosition =opcodes[startPosition + 1];
        } else {
            resultPosition =opcodes[startPosition + 3];
        }

        firstArgument =  getParameterValue(startPosition + 1, opcodeInstruction.getParameterModes()[2]);

        if (opcodeInstruction.getInstruction() == INPUT) {
            opcodes[opcodes[startPosition + 1]] = input;
            positionMovement = 2;
        } else if (opcodeInstruction.getInstruction() == OUTPUT) {
            output = opcodes[opcodes[startPosition + 1]];
            positionMovement = 2;
        } else if (opcodeInstruction.getInstruction() == Instruction.ADD) {
            secondArgument = getParameterValue(startPosition + 2, opcodeInstruction.getParameterModes()[1]);
            opcodes[resultPosition] = firstArgument + secondArgument;
        } else if (opcodeInstruction.getInstruction()  == Instruction.MULTIPLY){
            secondArgument = getParameterValue(startPosition + 2, opcodeInstruction.getParameterModes()[1]);
            opcodes[resultPosition] = firstArgument * secondArgument;
        }

        return positionMovement;
    }

    private int getParameterValue(int paramPosition, ParameterMode parameterMode) {
        if (parameterMode == ParameterMode.POSITION) {
            return opcodes[opcodes[paramPosition]];
        } else {
            return opcodes[paramPosition];
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

    public void setInput(int input) {

        this.input = input;
    }

    public int getOutput() {
        return output;
    }
}
