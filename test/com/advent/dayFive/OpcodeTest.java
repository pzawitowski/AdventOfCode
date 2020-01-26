package com.advent.dayFive;

import com.advent.dayTwo.Opcode;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class OpcodeTest {
    @Test
    public void immediateModeTest() {
        String opcodesString = "1002,4,3,4,33";

        Opcode opcode = Opcode.fromString(opcodesString);
        opcode.processOpcodes();

        assertEquals("1002,4,3,4,99", opcode.getOpcodesAsString());
    }

    @Test
    public void testInputInstruction() {
        String opcodesString = "3,0,99";

        Opcode opcode = Opcode.fromString(opcodesString);
        opcode.processOpcodes();

        assertEquals("0,0,99", opcode.getOpcodesAsString());

    }

    @Test
    public void testOutputInstruction() {
        String opcodesString = "4,3,99,77";

        Opcode opcode = Opcode.fromString(opcodesString);
        opcode.processOpcodes();

        assertEquals(77, opcode.getOutput());
    }


    @Test
    public void testInputAndOutputInstruction() {
        String opcodesString = "3,0,4,0,99";

        Opcode opcode = Opcode.fromString(opcodesString);
        opcode.setInput(77);
        opcode.processOpcodes();

        assertEquals(77, opcode.getOutput());
    }

}
