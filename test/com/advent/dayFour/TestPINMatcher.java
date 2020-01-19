package com.advent.dayFour;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestPINMatcher {

    @Test
    public void testGetNextMatchingPin() {
        PINMatcher pinMatcher = new PINMatcher(111111, 999999);

        assertEquals(111111, pinMatcher.getNextMatchingPIN());
        assertEquals(111112, pinMatcher.getNextMatchingPIN());
        assertEquals(111113, pinMatcher.getNextMatchingPIN());
        assertEquals(111114, pinMatcher.getNextMatchingPIN());
        assertEquals(111115, pinMatcher.getNextMatchingPIN());
        assertEquals(111116, pinMatcher.getNextMatchingPIN());
        assertEquals(111117, pinMatcher.getNextMatchingPIN());
        assertEquals(111118, pinMatcher.getNextMatchingPIN());
        assertEquals(111119, pinMatcher.getNextMatchingPIN());
        assertEquals(111122, pinMatcher.getNextMatchingPIN());
        assertEquals(111123, pinMatcher.getNextMatchingPIN());
        assertEquals(111124, pinMatcher.getNextMatchingPIN());
        assertEquals(111125, pinMatcher.getNextMatchingPIN());
        assertEquals(111126, pinMatcher.getNextMatchingPIN());
        assertEquals(111127, pinMatcher.getNextMatchingPIN());
        assertEquals(111128, pinMatcher.getNextMatchingPIN());
        assertEquals(111129, pinMatcher.getNextMatchingPIN());
        assertEquals(111133, pinMatcher.getNextMatchingPIN());
    }

    @Test
    public void testGetNextMatchingPinNoMatch() {
        PINMatcher pinMatcher = new PINMatcher(999999, 999999);

        assertEquals(999999, pinMatcher.getNextMatchingPIN());
        assertEquals(-1, pinMatcher.getNextMatchingPIN());
    }

    @Test
    public void testGetNextMatchingPinIfAllDigitSmaller() {
        PINMatcher pinMatcher = new PINMatcher(900000, 999999);

        assertEquals(999999, pinMatcher.getNextMatchingPIN());
    }
}
