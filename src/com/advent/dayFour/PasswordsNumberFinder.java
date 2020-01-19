package com.advent.dayFour;

public class PasswordsNumberFinder {

    private PINMatcher pinMatcher;


    public int calculateNumberOfPINs(int startNumber, int endNumber) {
        int numberOfMatchingPINs = 0;
        int matchingPin;
        pinMatcher = new PINMatcher(startNumber, endNumber);

        matchingPin = pinMatcher.getNextMatchingPIN();
        while(matchingPin != -1) {
            numberOfMatchingPINs++;
            matchingPin = pinMatcher.getNextMatchingPIN();
        }

        return numberOfMatchingPINs;
     }
}
