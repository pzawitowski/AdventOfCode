package com.advent.dayTwo;

public class OpcodeInstruction {
    public enum Instruction {
        ADD,
        MULTIPLY,
        INPUT,
        OUTPUT
    }

    public enum ParameterMode {
        POSITION,
        IMMEDIATE;

        public static  ParameterMode fromChar(char modeAsChar) {
            switch (modeAsChar) {
                case '0':
                    return POSITION;
                case '1':
                    return IMMEDIATE;
                default:
                    throw new IllegalArgumentException("Unrecognized parameter mode: " + modeAsChar);
            }
        }
    }

    private int instructionNumber;
    private ParameterMode[] parameterModes = new ParameterMode[3];

    public OpcodeInstruction(int instructionNumber)  {
        this.instructionNumber = instructionNumber;
        String instrAsString = String.format("%05d", instructionNumber);

        parameterModes[0] = ParameterMode.fromChar(instrAsString.charAt(0));
        parameterModes[1] = ParameterMode.fromChar(instrAsString.charAt(1));
        parameterModes[2] = ParameterMode.fromChar(instrAsString.charAt(2));
    }

    public Instruction getInstruction() {
        switch (instructionNumber % 100) {
            case 1:
                return Instruction.ADD;
            case 2:
                return Instruction.MULTIPLY;
            case 3:
                return Instruction.INPUT;
            case 4:
                return Instruction.OUTPUT;
            default:
                throw  new RuntimeException("Not supported instruction encountered");
        }
    }

    public ParameterMode[] getParameterModes() {
        return parameterModes;
    }
}
