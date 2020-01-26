package com.advent.dayFive;

import com.advent.dayTwo.OpcodeInstruction;
import org.junit.Test;

import static com.advent.dayTwo.OpcodeInstruction.ParameterMode.IMMEDIATE;
import static com.advent.dayTwo.OpcodeInstruction.ParameterMode.POSITION;
import static org.junit.Assert.assertEquals;

public class OpcodeInstructionTest {
    @Test
    public void testNoParameterModes() {
        OpcodeInstruction opcodeInstruction = new OpcodeInstruction(1);
        assertEquals(POSITION, opcodeInstruction.getParameterModes()[1]);
        assertEquals(POSITION, opcodeInstruction.getParameterModes()[0]);
        assertEquals(POSITION, opcodeInstruction.getParameterModes()[2]);
    }
    @Test
    public void testParameterModes() {
        OpcodeInstruction opcodeInstruction = new OpcodeInstruction(11101);
        assertEquals(IMMEDIATE, opcodeInstruction.getParameterModes()[0]);
        assertEquals(IMMEDIATE, opcodeInstruction.getParameterModes()[1]);
        assertEquals(IMMEDIATE, opcodeInstruction.getParameterModes()[2]);

        opcodeInstruction = new OpcodeInstruction(00001);
        assertEquals(POSITION, opcodeInstruction.getParameterModes()[0]);
        assertEquals(POSITION, opcodeInstruction.getParameterModes()[1]);
        assertEquals(POSITION, opcodeInstruction.getParameterModes()[2]);
    }


    @Test
    public void testInstruction() {
        OpcodeInstruction opcodeInstruction = new OpcodeInstruction(11002);

        assertEquals(OpcodeInstruction.Instruction.MULTIPLY, opcodeInstruction.getInstruction());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testUnknownParameter() {
        OpcodeInstruction opcodeInstruction = new OpcodeInstruction(21002);
    }
}
