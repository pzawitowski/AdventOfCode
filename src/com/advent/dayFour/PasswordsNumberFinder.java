package com.advent.dayFour;

public class PasswordsNumberFinder {

    private PINMatcher pinMatcher;

    public int calculateNumberOfPINs(int startNumber, int endNumber) {
        int numberOfMatchingPINs = 0;
        int matchingPin;

        initializeMatcher(startNumber, endNumber);

        matchingPin = pinMatcher.getNextMatchingPIN();
        while(matchingPin != -1) {
            numberOfMatchingPINs++;
            matchingPin = pinMatcher.getNextMatchingPIN();
        }

        return numberOfMatchingPINs;
     }

    private void initializeMatcher(int startNumber, int endNumber) {
        if (pinMatcher == null) {
            pinMatcher = new PINMatcher(startNumber, endNumber);
        } else {
            pinMatcher.setStartNumber(startNumber);
            pinMatcher.setEndNumber(endNumber);
            pinMatcher.reset();
        }
    }

    public PINMatcher getPinMatcher() {
        return pinMatcher;
    }

    public void setPinMatcher(PINMatcher pinMatcher) {
        this.pinMatcher = pinMatcher;
    }
}
