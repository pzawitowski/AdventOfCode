package com.advent.dayTwo;

import org.junit.Test;

import static org.junit.Assert.*;

public class OpcodeTest {

    @Test
    public void testOpcodeInitialization() {
        String opcodesString = "1,3,5,6,7,99";

        Opcode opcode = Opcode.fromString(opcodesString);
        assertEquals(1, opcode.getOpcodes()[0]);
        assertEquals(3, opcode.getOpcodes()[1]);
        assertEquals(5, opcode.getOpcodes()[2]);
        assertEquals(6, opcode.getOpcodes()[3]);
        assertEquals(7, opcode.getOpcodes()[4]);
        assertEquals(99, opcode.getOpcodes()[5]);
    }

    @Test
    public void testProcessOpcodes() {
        Opcode opcode1  = Opcode.fromString("1,0,0,0,99");
        Opcode opcode2  = Opcode.fromString("2,3,0,3,99");
        Opcode opcode3  = Opcode.fromString("2,4,4,5,99,0");
        Opcode opcode4  = Opcode.fromString("1,1,1,4,99,5,6,0,99");
        Opcode opcode5  = Opcode.fromString("1,9,10,3,2,3,11,0,99,30,40,50");



        opcode1.processOpcodes();
        opcode2.processOpcodes();
        opcode3.processOpcodes();
        opcode4.processOpcodes();
        opcode5.processOpcodes();

        assertEquals("2,0,0,0,99",  opcode1.getOpcodesAsString());
        assertEquals("2,3,0,6,99",  opcode2.getOpcodesAsString());
        assertEquals("2,4,4,5,99,9801",  opcode3.getOpcodesAsString());
        assertEquals("30,1,1,4,2,5,6,0,99",  opcode4.getOpcodesAsString());
        assertEquals("3500,9,10,70,2,3,11,0,99,30,40,50",  opcode5.getOpcodesAsString());
    }
}
