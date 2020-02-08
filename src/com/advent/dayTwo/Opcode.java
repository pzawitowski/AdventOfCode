package com.advent.dayTwo;

import com.advent.dayTwo.OpcodeInstruction.ParameterMode;

import java.util.Arrays;

import static com.advent.dayTwo.OpcodeInstruction.Instruction.INPUT;
import static com.advent.dayTwo.OpcodeInstruction.Instruction.OUTPUT;

public class Opcode {
    public static final int OPERATION_END = 99;

    private int opcodes[];
    private int inputs[] = new int[] {0, 0, 0, 0, 0};
    private int output;

    private int inputNumber = 0;
    private boolean stopAtOutput = false;

    private int instructionPosition = 0;

    public Opcode(int[] opcodes) {
        this.opcodes = opcodes;
    }

    public Opcode(int[] opcodes, int input) {
        this(opcodes);
        this.inputs = new int[] {input};
    }

    public void processOpcodes() {
        instructionPosition = 0;

        while (opcodes[instructionPosition] != OPERATION_END) {
            processOpcode();
        }
    }

    private void processOpcode() {
        int firstArgument;
        int secondArgument;
        int resultPosition;
        int firstArgumentPosition = instructionPosition + 1;
        int secondArgumentPosition = instructionPosition + 2;

        OpcodeInstruction opcodeInstruction = new OpcodeInstruction(opcodes[instructionPosition]);

        resultPosition = getResultPosition(opcodeInstruction);

        firstArgument =  getParameterValue(firstArgumentPosition, opcodeInstruction.getParameterModes()[2]);

        switch (opcodeInstruction.getInstruction()) {
            case INPUT:
                opcodes[opcodes[firstArgumentPosition]] = inputs[inputNumber];
                instructionPosition += 2;
                inputNumber++;
                break;
            case OUTPUT:
                output = opcodes[opcodes[firstArgumentPosition]];
                instructionPosition += 2;
                break;
            case ADD:
                secondArgument = getParameterValue(secondArgumentPosition, opcodeInstruction.getParameterModes()[1]);
                opcodes[resultPosition] = firstArgument + secondArgument;
                instructionPosition += 4;
                break;
            case MULTIPLY:
                secondArgument = getParameterValue(secondArgumentPosition, opcodeInstruction.getParameterModes()[1]);
                opcodes[resultPosition] = firstArgument * secondArgument;
                instructionPosition += 4;
                break;
            case JUMP_IF_TRUE:
                secondArgument = getParameterValue(secondArgumentPosition, opcodeInstruction.getParameterModes()[1]);
                if (firstArgument != 0) {
                    instructionPosition = secondArgument;
                } else {
                    instructionPosition += 3;
                }
                break;
            case JUMP_IF_FALSE:
                secondArgument = getParameterValue(secondArgumentPosition, opcodeInstruction.getParameterModes()[1]);
                if (firstArgument == 0) {
                    instructionPosition = secondArgument;
                } else {
                    instructionPosition += 3;
                }
                break;
            case LESS_THAN:
                secondArgument = getParameterValue(secondArgumentPosition, opcodeInstruction.getParameterModes()[1]);
                if (firstArgument < secondArgument) {
                    opcodes[resultPosition] = 1;
                } else {
                    opcodes[resultPosition] = 0;
                }
                instructionPosition += 4;
                break;
            case EQUALS:
                secondArgument = getParameterValue(secondArgumentPosition, opcodeInstruction.getParameterModes()[1]);
                if (firstArgument == secondArgument) {
                    opcodes[resultPosition] = 1;
                } else {
                    opcodes[resultPosition] = 0;
                }
                instructionPosition += 4;
                break;
        }
    }

    private int getResultPosition(OpcodeInstruction opcodeInstruction) {
        int resultPosition;
        if (opcodeInstruction.getInstruction() == INPUT || opcodeInstruction.getInstruction() == OUTPUT) {
            resultPosition =opcodes[instructionPosition + 1];
        } else {
            resultPosition =opcodes[instructionPosition + 3];
        }
        return resultPosition;
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
        if (inputs == null) {
            inputs = new int[] {input};
        } else {
            inputs[0] = input;
        }
    }

    public void setInputs(int inputs[]) {
        this.inputs = inputs;
    }

    public int getOutput() {
        return output;
    }

    public int getInstructionPosition() {

        return instructionPosition;
    }

    public boolean isStopAtOutput() {
        return stopAtOutput;
    }

    public void setStopAtOutput(boolean stopAtOutput) {
        this.stopAtOutput = stopAtOutput;
    }
}
