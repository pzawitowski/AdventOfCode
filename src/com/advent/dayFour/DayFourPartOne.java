package com.advent.dayFour;

public class DayFourPartOne {
    public static void main(String[] args) {
        PasswordsNumberFinder pinFinder = new PasswordsNumberFinder();

        System.out.println("Number of matching passwords: " + pinFinder.calculateNumberOfPINs(236491, 713787));
    }
}
