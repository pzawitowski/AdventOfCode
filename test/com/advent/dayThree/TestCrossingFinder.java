package com.advent.dayThree;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestCrossingFinder {
    @Test
    public void testFindClosestCrossing() {
        Wire wire1 = new Wire("R8,U5,L5,D3");
        Wire wire2 = new Wire("U7,R6,D4,L4");

        WireCrossingFinder crossingFinder = new WireCrossingFinder(wire1, wire2);
        assertEquals(6, crossingFinder.findClosestCrossingDistance());


        wire1 = new Wire("R75,D30,R83,U83,L12,D49,R71,U7,L72");
        wire2 = new Wire("U62,R66,U55,R34,D71,R55,D58,R83");
        crossingFinder.setWire1(wire1);
        crossingFinder.setWire2(wire2);
        assertEquals(159, crossingFinder.findClosestCrossingDistance());

        wire1 = new Wire("R98,U47,R26,D63,R33,U87,L62,D20,R33,U53,R51");
        wire2 = new Wire("U98,R91,D20,R16,D67,R40,U7,R15,U6,R7");
        crossingFinder.setWire1(wire1);
        crossingFinder.setWire2(wire2);
        assertEquals(135, crossingFinder.findClosestCrossingDistance());
    }

    @Test
    public void testFindClosestCrossingOnWire() {
        Wire wire1 = new Wire("R8,U5,L5,D3");
        Wire wire2 = new Wire("U7,R6,D4,L4");

        WireCrossingFinder crossingFinder = new WireCrossingFinder(wire1, wire2);
        crossingFinder.setDistanceCalculator(new WireDistanceCalculator(wire1, wire2));

        assertEquals(30, crossingFinder.findClosestCrossingDistance());

        wire1 = new Wire("R75,D30,R83,U83,L12,D49,R71,U7,L72");
        wire2 = new Wire("U62,R66,U55,R34,D71,R55,D58,R83");

        crossingFinder = new WireCrossingFinder(wire1, wire2);
        crossingFinder.setDistanceCalculator(new WireDistanceCalculator(wire1, wire2));
        assertEquals(610, crossingFinder.findClosestCrossingDistance());

        wire1 = new Wire("R98,U47,R26,D63,R33,U87,L62,D20,R33,U53,R51");
        wire2 = new Wire("U98,R91,D20,R16,D67,R40,U7,R15,U6,R7");
        crossingFinder = new WireCrossingFinder(wire1, wire2);
        crossingFinder.setDistanceCalculator(new WireDistanceCalculator(wire1, wire2));

        assertEquals(410, crossingFinder.findClosestCrossingDistance());
    }
}
