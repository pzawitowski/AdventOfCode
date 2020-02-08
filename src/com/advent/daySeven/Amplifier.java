package com.advent.daySeven;

import com.advent.dayTwo.Opcode;

public class Amplifier {
    private String opcodeString;
    private int phaseSetting = 0;


    public Amplifier(String opcodeString) {
        this.opcodeString = opcodeString;
    }

    public int calculateOutput(int input) {
        Opcode opcode = Opcode.fromString(opcodeString);

        opcode.setInputs(new int[] {phaseSetting, input});
        opcode.processOpcodes();

        return opcode.getOutput();
    }

    public String getOpcodeString() {
        return opcodeString;
    }

    public void setOpcodeString(String opcodeString) {
        this.opcodeString = opcodeString;
    }

    public int getPhaseSetting() {
        return phaseSetting;
    }

    public void setPhaseSetting(int phaseSetting) {
        this.phaseSetting = phaseSetting;
    }

    public int increasePhaseSetting() {
        phaseSetting++;
        if (phaseSetting > 4) {
            phaseSetting = 0;
        }
        return phaseSetting;
    }
}
