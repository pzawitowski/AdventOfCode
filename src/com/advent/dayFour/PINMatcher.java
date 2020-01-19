package com.advent.dayFour;

import java.util.Arrays;

public class PINMatcher {
    private int lastMatchingNumber;
    private int startNumber;
    private int endNumber;
    private int currentNumber;

    public PINMatcher(int startNumber, int endNumber) {
        this.startNumber = startNumber;
        this.endNumber = endNumber;

        currentNumber = this.startNumber;
    }

    public int getLastMatchingNumber() {
        return lastMatchingNumber;
    }

    public int getNextMatchingPIN() {
        while (isNumberInRange(currentNumber)) {
            if (hasDecreasingDigits(currentNumber)) {
                currentNumber = getNextNonDecreasingNumber(currentNumber);
            }

            if (hasDoubleDigits(currentNumber)) {
                lastMatchingNumber = currentNumber;
                currentNumber++;
                return lastMatchingNumber;
            }

            currentNumber++;
        }

        return -1;
    }

    private boolean hasDoubleDigits(int number) {
        String numberAsString = String.valueOf(number);
        for (int i = 1; i < numberAsString.length(); i++) {
            if (numberAsString.charAt(i) == numberAsString.charAt(i - 1)) {
                return true;
            }
        }

        return false;
    }

    private boolean hasDecreasingDigits(int number) {
        String numberAsString = String.valueOf(number);
        for (int i = 1; i < numberAsString.length(); i++) {
            if (numberAsString.charAt(i) < numberAsString.charAt(i - 1)) {
                return true;
            }
        }
        return false;
    }

    private int getNextNonDecreasingNumber(int number) {
        String numberAsString = String.valueOf(number);
        for (int i = 1; i < numberAsString.length(); i++) {
            if (numberAsString.charAt(i) < numberAsString.charAt(i - 1)) {
                int nextNumber = getNextNumberForPosition(numberAsString, i);
                if (isNumberInRange(nextNumber)) {
                    return nextNumber;
                }
            }
        }

        return 0;
    }

    private int getNextNumberForPosition(String numberAsString, int i) {
        char[] charArray = numberAsString.toCharArray();
        Arrays.fill(charArray, i -1, numberAsString.length(), numberAsString.charAt(i - 1));
        return Integer.valueOf(new String(charArray));
    }

    private boolean isNumberInRange(int number) {
        return startNumber <= number && number <= endNumber;
    }
}
