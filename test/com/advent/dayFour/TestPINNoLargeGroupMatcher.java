package com.advent.dayFour;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestPINNoLargeGroupMatcher {

    @Test
    public void testGetNextMatchingPinNoMatch() {
        PINMatcher pinMatcher = new PINMatcherNoLargeGroup(999999, 999999);

        assertEquals(-1, pinMatcher.getNextMatchingPIN());
    }

    @Test
    public void testGetNextMatchingPin() {
        PINMatcher pinMatcher = new PINMatcherNoLargeGroup(111111, 999999);

        assertEquals(111122, pinMatcher.getNextMatchingPIN());
        assertEquals(111133, pinMatcher.getNextMatchingPIN());
        assertEquals(111144, pinMatcher.getNextMatchingPIN());
        assertEquals(111155, pinMatcher.getNextMatchingPIN());
        assertEquals(111166, pinMatcher.getNextMatchingPIN());
        assertEquals(111177, pinMatcher.getNextMatchingPIN());
        assertEquals(111188, pinMatcher.getNextMatchingPIN());
        assertEquals(111199, pinMatcher.getNextMatchingPIN());
        assertEquals(111223, pinMatcher.getNextMatchingPIN());
        assertEquals(111224, pinMatcher.getNextMatchingPIN());
        assertEquals(111225, pinMatcher.getNextMatchingPIN());
        assertEquals(111226, pinMatcher.getNextMatchingPIN());
        assertEquals(111227, pinMatcher.getNextMatchingPIN());


    }
}
