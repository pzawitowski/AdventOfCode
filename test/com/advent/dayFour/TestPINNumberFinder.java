package com.advent.dayFour;

import org.junit.Test;

import static org.junit.Assert.*;

public class TestPINNumberFinder {
    PasswordsNumberFinder pinFinder = new PasswordsNumberFinder();
    @Test
    public void testNumberOfMatchingPins() {


        assertEquals(1, pinFinder.calculateNumberOfPINs(999990, 999999));
        assertEquals(2, pinFinder.calculateNumberOfPINs(899999, 999999));
    }

    @Test
    public void testTwoDigitsMatching() {

        assertEquals(9, pinFinder.calculateNumberOfPINs(10, 99));
    }

    @Test
    public void testThreeDigitsMatching() {

        assertEquals(9, pinFinder.calculateNumberOfPINs(100, 120));
        assertEquals(10, pinFinder.calculateNumberOfPINs(100, 130));
        assertEquals(11, pinFinder.calculateNumberOfPINs(100, 140));
    }

    @Test
    public void testNoMatching() {
        assertEquals(0, pinFinder.calculateNumberOfPINs(999990, 999998));
    }
}
