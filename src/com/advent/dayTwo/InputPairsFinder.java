package com.advent.dayTwo;

import java.util.Optional;

public class InputPairsFinder {

    private String startingInput;

    private int searchingOutput;

    public InputPairsFinder(String startingInput, int searchingOutput) {
        this.startingInput = startingInput;
        this.searchingOutput = searchingOutput;
    }

    public String getStartingInput() {
        return startingInput;
    }

    public void setStartingInput(String startingInput) {
        this.startingInput = startingInput;
    }

    public Optional<Opcode> search() {
        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 100; j++) {
                Opcode opcode = processOpcode(i, j);

                if (opcode.getOpcodes()[0] == searchingOutput) {
                    return Optional.of(opcode);
                }
            }
        }

        return Optional.empty();
    }

    private Opcode processOpcode(int i, int j) {
        Opcode opcode = Opcode.fromString(startingInput);
        opcode.getOpcodes()[1] = i;
        opcode.getOpcodes()[2] = j;

        opcode.processOpcodes();

        return opcode;
    }


}
