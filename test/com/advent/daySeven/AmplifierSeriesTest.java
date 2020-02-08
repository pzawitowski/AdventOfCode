package com.advent.daySeven;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AmplifierSeriesTest {
    AmplifierSeries amplifierSeries;
    @Before
    public void setUp() {
        amplifierSeries = new AmplifierSeries(5, "");
    }


    @Test
    public void testPhaseSettingIncrease() {
        increasePhaseSettingBy(4);
        assertEquals(4, amplifierSeries.getAmplifiers().get(0).getPhaseSetting());

        increasePhaseSettingBy(1);
        assertEquals(0, amplifierSeries.getAmplifiers().get(0).getPhaseSetting());
        assertEquals(1, amplifierSeries.getAmplifiers().get(1).getPhaseSetting());
        assertEquals(0, amplifierSeries.getAmplifiers().get(2).getPhaseSetting());
        assertEquals(0, amplifierSeries.getAmplifiers().get(3).getPhaseSetting());
        assertEquals(0, amplifierSeries.getAmplifiers().get(4).getPhaseSetting());

        increasePhaseSettingBy(5);
        assertEquals(0, amplifierSeries.getAmplifiers().get(0).getPhaseSetting());
        assertEquals(2, amplifierSeries.getAmplifiers().get(1).getPhaseSetting());
        assertEquals(0, amplifierSeries.getAmplifiers().get(2).getPhaseSetting());
        assertEquals(0, amplifierSeries.getAmplifiers().get(3).getPhaseSetting());
        assertEquals(0, amplifierSeries.getAmplifiers().get(4).getPhaseSetting());
    }

    @Test
    public void testPhaseSettingIncreaseOverMaximum() {
        amplifierSeries.getAmplifiers().get(0).setPhaseSetting(4);
        amplifierSeries.getAmplifiers().get(1).setPhaseSetting(4);
        amplifierSeries.getAmplifiers().get(2).setPhaseSetting(4);
        amplifierSeries.getAmplifiers().get(3).setPhaseSetting(4);
        amplifierSeries.getAmplifiers().get(4).setPhaseSetting(4);

        increasePhaseSettingBy(1);

        assertEquals(0, amplifierSeries.getAmplifiers().get(0).getPhaseSetting());
        assertEquals(0, amplifierSeries.getAmplifiers().get(1).getPhaseSetting());
        assertEquals(0, amplifierSeries.getAmplifiers().get(2).getPhaseSetting());
        assertEquals(0, amplifierSeries.getAmplifiers().get(3).getPhaseSetting());
        assertEquals(0, amplifierSeries.getAmplifiers().get(4).getPhaseSetting());
    }


    @Test
    public void testAdventOfCodeFirstExample() {
       AmplifierSeries amplifierSeries = new AmplifierSeries(5, "3,15,3,16,1002,16,10,16,1,16,15,15,4,15,99,0,0");
       amplifierSeries.getAmplifiers().get(0).setPhaseSetting(4);
       amplifierSeries.getAmplifiers().get(1).setPhaseSetting(3);
       amplifierSeries.getAmplifiers().get(2).setPhaseSetting(2);
       amplifierSeries.getAmplifiers().get(3).setPhaseSetting(1);
       amplifierSeries.getAmplifiers().get(4).setPhaseSetting(0);

       assertEquals(43210, amplifierSeries.calculateOutputWithCurrentSettings());
    }

    @Test
    public void testAdventOfCodeSecondExample() {
        AmplifierSeries amplifierSeries = new AmplifierSeries(5, "3,23,3,24,1002,24,10,24,1002,23,-1,23,101,5,23,23,1,24,23,23,4,23,99,0,0");
        amplifierSeries.getAmplifiers().get(0).setPhaseSetting(0);
        amplifierSeries.getAmplifiers().get(1).setPhaseSetting(1);
        amplifierSeries.getAmplifiers().get(2).setPhaseSetting(2);
        amplifierSeries.getAmplifiers().get(3).setPhaseSetting(3);
        amplifierSeries.getAmplifiers().get(4).setPhaseSetting(4);

        assertEquals(54321, amplifierSeries.calculateOutputWithCurrentSettings());
    }

    @Test
    public void testAdventOfCodeThirdExample() {
        AmplifierSeries amplifierSeries = new AmplifierSeries(5, "3,31,3,32,1002,32,10,32,1001,31,-2,31,1007,31,0,33,1002,33,7,33,1,33,31,31,1,32,31,31,4,31,99,0,0,0");
        amplifierSeries.getAmplifiers().get(0).setPhaseSetting(1);
        amplifierSeries.getAmplifiers().get(1).setPhaseSetting(0);
        amplifierSeries.getAmplifiers().get(2).setPhaseSetting(4);
        amplifierSeries.getAmplifiers().get(3).setPhaseSetting(3);
        amplifierSeries.getAmplifiers().get(4).setPhaseSetting(2);

        assertEquals(65210, amplifierSeries.calculateOutputWithCurrentSettings());
    }


    @Test
    @Ignore
    public void testAdventOfCodeMainTask() {
        AmplifierSeries amplifierSeries = new AmplifierSeries(5, "3,8,1001,8,10,8,105,1,0,0,21,42,51,76,101,118,199,280,361,442,99999,3,9,101,5,9,9,102,2,9,9,1001,9,4,9,102,2,9,9,4,9,99,3,9,1002,9,3,9,4,9,99,3,9,1002,9,4,9,1001,9,3,9,1002,9,5,9,101,3,9,9,1002,9,2,9,4,9,99,3,9,101,4,9,9,1002,9,2,9,1001,9,3,9,1002,9,3,9,101,4,9,9,4,9,99,3,9,101,3,9,9,1002,9,3,9,101,2,9,9,4,9,99,3,9,1002,9,2,9,4,9,3,9,1001,9,2,9,4,9,3,9,1002,9,2,9,4,9,3,9,102,2,9,9,4,9,3,9,1002,9,2,9,4,9,3,9,1001,9,2,9,4,9,3,9,101,2,9,9,4,9,3,9,1002,9,2,9,4,9,3,9,1002,9,2,9,4,9,3,9,1001,9,1,9,4,9,99,3,9,1001,9,1,9,4,9,3,9,1002,9,2,9,4,9,3,9,1001,9,1,9,4,9,3,9,101,1,9,9,4,9,3,9,1001,9,1,9,4,9,3,9,101,2,9,9,4,9,3,9,1002,9,2,9,4,9,3,9,1001,9,2,9,4,9,3,9,101,2,9,9,4,9,3,9,1002,9,2,9,4,9,99,3,9,1002,9,2,9,4,9,3,9,101,1,9,9,4,9,3,9,1002,9,2,9,4,9,3,9,102,2,9,9,4,9,3,9,1001,9,1,9,4,9,3,9,101,1,9,9,4,9,3,9,102,2,9,9,4,9,3,9,1002,9,2,9,4,9,3,9,1002,9,2,9,4,9,3,9,101,2,9,9,4,9,99,3,9,1002,9,2,9,4,9,3,9,1001,9,1,9,4,9,3,9,1002,9,2,9,4,9,3,9,1002,9,2,9,4,9,3,9,1002,9,2,9,4,9,3,9,1002,9,2,9,4,9,3,9,102,2,9,9,4,9,3,9,1001,9,2,9,4,9,3,9,101,2,9,9,4,9,3,9,101,1,9,9,4,9,99,3,9,1002,9,2,9,4,9,3,9,101,1,9,9,4,9,3,9,102,2,9,9,4,9,3,9,102,2,9,9,4,9,3,9,102,2,9,9,4,9,3,9,1001,9,1,9,4,9,3,9,1001,9,1,9,4,9,3,9,101,2,9,9,4,9,3,9,1002,9,2,9,4,9,3,9,101,2,9,9,4,9,99");
        amplifierSeries.getAmplifiers().get(0).setPhaseSetting(0);
        amplifierSeries.getAmplifiers().get(1).setPhaseSetting(0);
        amplifierSeries.getAmplifiers().get(2).setPhaseSetting(0);
        amplifierSeries.getAmplifiers().get(3).setPhaseSetting(0);
        amplifierSeries.getAmplifiers().get(4).setPhaseSetting(0);

//        amplifierSeries.calculateOutputWithCurrentSettings();
        int output = amplifierSeries.findLargestOutput();
        System.out.println("Largest output: " + output);
    }

    private void increasePhaseSettingBy(int numberOfTimesToIncrease) {
        for (int i = 0; i < numberOfTimesToIncrease; i++) {
            amplifierSeries.increasePhaseSettings();
        }
    }

}
