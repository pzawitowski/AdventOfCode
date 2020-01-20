package com.advent.dayFour;

public class PINMatcherNoLargeGroup extends PINMatcher {
    private static int DEFAULT_GROUP_SIZE = 2;
    private int maxGroupSize = DEFAULT_GROUP_SIZE;

    public PINMatcherNoLargeGroup() {

    }

    public PINMatcherNoLargeGroup(int startNumber, int endNumber) {
        super(startNumber, endNumber);
    }

    protected boolean hasDoubleDigitsMeetingRule(int number) {
        String numberAsString = String.valueOf(number);
        for (int i = 1; i < numberAsString.length(); i++) {
            if (numberAsString.charAt(i) == numberAsString.charAt(i - 1)) {
                if (!isDigitPartOfLargerGroup(numberAsString, numberAsString.charAt(i))) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean isDigitPartOfLargerGroup(String number, char digit) {
        int firstIndex = number.indexOf(digit);
        int lastIndex = number.lastIndexOf(digit);
        return lastIndex - firstIndex >= maxGroupSize;
    }

    public int getMaxGroupSize() {
        return maxGroupSize;
    }

    public void setMaxGroupSize(int maxGroupSize) {
        this.maxGroupSize = maxGroupSize;
    }
}
