package com.advent.dayThree;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class TestWireSegment {
    @Test
    public void testCrossing() {
        WireSegment segment1 =  new WireSegment(new Point(3, 2), new Point(3, 6));
        WireSegment segment2 = new WireSegment(new Point(2, 3), new Point(6, 3));
        List<Point> crossingPoints = segment1.getCrossingPointsWith(segment2);

        assertEquals(1, crossingPoints.size());
        assertEquals(3, crossingPoints.get(0).getX());
        assertEquals(3, crossingPoints.get(0).getY());

        crossingPoints = segment2.getCrossingPointsWith(segment1);
        assertEquals(3, crossingPoints.get(0).getX());
        assertEquals(3, crossingPoints.get(0).getY());


        segment1 =  new WireSegment( new Point(3, 6), new Point(3, 2));
        segment2 = new WireSegment(new Point(2, 3), new Point(6, 3));

        crossingPoints = segment2.getCrossingPointsWith(segment1);

        assertEquals(1, crossingPoints.size());
        assertEquals(3, crossingPoints.get(0).getX());
        assertEquals(3, crossingPoints.get(0).getY());

        segment1 =  new WireSegment( new Point(-2, 1), new Point(-2, 8));
        segment2 = new WireSegment(new Point(-3, 7), new Point(6, 7));
        crossingPoints = segment2.getCrossingPointsWith(segment1);
        assertEquals(1, crossingPoints.size());
        assertEquals(-2, crossingPoints.get(0).getX());
        assertEquals(7, crossingPoints.get(0).getY());
   }

    @Test
    public void testCrossingOutOfTheLine() {
        WireSegment segment1 =  new WireSegment(new Point(7, 2), new Point(7, 6));
        WireSegment segment2 = new WireSegment(new Point(2, 3), new Point(6, 3));
        List<Point> crossingPoints = segment1.getCrossingPointsWith(segment2);

        assertTrue(crossingPoints.isEmpty());


        crossingPoints = segment2.getCrossingPointsWith(segment1);

        assertTrue(crossingPoints.isEmpty());

        segment1 =  new WireSegment( new Point(0, 0), new Point(8, 0));
        segment2 = new WireSegment(new Point(6, 7), new Point(6, 3));
        crossingPoints = segment2.getCrossingPointsWith(segment1);

        assertTrue(crossingPoints.isEmpty());
    }

    @Test
    public void testOverlappedCrossing() {
        WireSegment segment1 =  new WireSegment(new Point(2, 4), new Point(7, 4));
        WireSegment segment2 = new WireSegment(new Point(4, 4), new Point(6, 4));
        List<Point> crossingPoints = segment1.getCrossingPointsWith(segment2);

        assertEquals(3, crossingPoints.size());
        assertEquals(4, crossingPoints.get(0).getX());
        assertEquals(5, crossingPoints.get(1).getX());
        assertEquals(6, crossingPoints.get(2).getX());

        assertEquals(4, crossingPoints.get(0).getY());
        assertEquals(4, crossingPoints.get(1).getY());
        assertEquals(4, crossingPoints.get(2).getY());

        segment1 =  new WireSegment(new Point(5, 1), new Point(5, 8));
        segment2 = new WireSegment(new Point(5, 3), new Point(5, 7));
        crossingPoints = segment1.getCrossingPointsWith(segment2);
        assertEquals(5, crossingPoints.size());


        assertEquals(5, crossingPoints.get(0).getX());
        assertEquals(5, crossingPoints.get(1).getX());
        assertEquals(5, crossingPoints.get(2).getX());
        assertEquals(5, crossingPoints.get(3).getX());
        assertEquals(5, crossingPoints.get(4).getX());

        assertEquals(3, crossingPoints.get(0).getY());
        assertEquals(4, crossingPoints.get(1).getY());
        assertEquals(5, crossingPoints.get(2).getY());
        assertEquals(6, crossingPoints.get(3).getY());
        assertEquals(7, crossingPoints.get(4).getY());
    }
}
