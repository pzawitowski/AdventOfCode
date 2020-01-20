package com.advent.dayFour;

public class DayFourPartTwo {
    public static void main(String[] args) {
        PasswordsNumberFinder pinFinder = new PasswordsNumberFinder();
        pinFinder.setPinMatcher(new PINMatcherNoLargeGroup());

        System.out.println("Number of matching passwords: " + pinFinder.calculateNumberOfPINs(236491, 713787));
    }
}
