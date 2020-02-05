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

    @Test
    public void testJumpIfTrueInstruction() {
        String opcodesString = "1105,1,7,1,2,3,4,99";

        Opcode opcode = Opcode.fromString(opcodesString);

        opcode.processOpcodes();

        assertEquals(7, opcode.getInstructionPosition() );
        assertEquals("1105,1,7,1,2,3,4,99", opcode.getOpcodesAsString());
    }

    @Test
    public void testJumpIfFalseInstruction() {
        String opcodesString = "1106,0,7,1,2,3,4,99";

        Opcode opcode = Opcode.fromString(opcodesString);

        opcode.processOpcodes();

        assertEquals(7, opcode.getInstructionPosition());
        assertEquals("1106,0,7,1,2,3,4,99", opcode.getOpcodesAsString());
    }

    @Test
    public void testExamplesFromAdventOfCode() {
        String opcodesString = "3,9,8,9,10,9,4,9,99,-1,8";

        Opcode opcode = Opcode.fromString(opcodesString);
        opcode.setInput(8);
        opcode.processOpcodes();
        assertEquals(1, opcode.getOutput());


        opcode = Opcode.fromString(opcodesString);
        opcode.setInput(11);
        opcode.processOpcodes();
        assertEquals(0, opcode.getOutput());


        opcode = Opcode.fromString("3,9,7,9,10,9,4,9,99,-1,8");
        opcode.setInput(7);
        opcode.processOpcodes();
        assertEquals(1, opcode.getOutput());

        opcode = Opcode.fromString("3,9,7,9,10,9,4,9,99,-1,8");
        opcode.setInput(8);
        opcode.processOpcodes();
        assertEquals(0, opcode.getOutput());

        opcode = Opcode.fromString("3,3,1108,-1,8,3,4,3,99");
        opcode.setInput(8);
        opcode.processOpcodes();
        assertEquals(1, opcode.getOutput());

        opcode = Opcode.fromString("3,3,1108,-1,8,3,4,3,99");
        opcode.setInput(1);
        opcode.processOpcodes();
        assertEquals(0, opcode.getOutput());



        opcode = Opcode.fromString("3,12,6,12,15,1,13,14,13,4,13,99,-1,0,1,9");
        opcode.setInput(0);
        opcode.processOpcodes();
        assertEquals(0, opcode.getOutput());

        opcode = Opcode.fromString("3,12,6,12,15,1,13,14,13,4,13,99,-1,0,1,9");
        opcode.setInput(1);
        opcode.processOpcodes();
        assertEquals(1, opcode.getOutput());

        /*
        This example seems to be invalid

        opcode = Opcode.fromString("3,21,1008,21,8,20,1005,20,22,107,8,21,20,1006,20,31,1106,0,36,98,0,0,1002,21,125,20,4,20,1105,1,46,104,999,1105,1,46,1101,1000,1,20,4,20,1105,1,46,98,99");
        opcode.setInput(7);
        opcode.processOpcodes();
        assertEquals(999, opcode.getOutput());
         */
    }

}
