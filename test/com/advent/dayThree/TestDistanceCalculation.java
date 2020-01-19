package com.advent.dayThree;

import org.junit.Test;

import static org.junit.Assert.*;

public class TestDistanceCalculation {

    Point p1;
    Point p2;

    @Test
    public void testZeroDistance() {
        p1 = new Point(0, 0);
        p2 = new Point(0, 0);

        assertEquals(0, p1.getDistanceFrom(p2));
        assertEquals(0, p2.getDistanceFrom(p1));
    }

    @Test
    public void testDistanceX() {
        p1 = new Point(0, 0);
        p2 = new Point(10, 0);
        assertEquals(10, p1.getDistanceFrom(p2));
        assertEquals(10, p2.getDistanceFrom(p1));

        p1 = new Point(-10, 0);
        p2 = new Point(10, 0);
        assertEquals(20, p1.getDistanceFrom(p2));
        assertEquals(20, p2.getDistanceFrom(p1));
    }

    @Test
    public void testDistanceDiagonal() {
        p1 = new Point(0, 0);
        p2 = new Point(10, 5);

        assertEquals(15, p1.getDistanceFrom(p2));
        assertEquals(15, p2.getDistanceFrom(p1));
    }

    @Test
    public void testWireDistance() {
        Wire wire1 = new Wire("R8,U5,L5,D3");
        Wire wire2 = new Wire("U7,R6,D4,L4");

        Point point1 = new Point(3, 3);
        Point point2 = new Point(6, 5);

        WireDistanceCalculator distanceCalculator = new WireDistanceCalculator(wire1, wire2);

        assertEquals(40, distanceCalculator.getDistanceFromStartPoint(point1));
        assertEquals(30, distanceCalculator.getDistanceFromStartPoint(point2));
    }



}
