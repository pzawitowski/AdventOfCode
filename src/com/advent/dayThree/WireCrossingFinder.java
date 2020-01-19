package com.advent.dayThree;

import java.util.List;

public class WireCrossingFinder {
    private Wire wire1;
    private Wire wire2;

    private DistanceCalculator distanceCalculator = new ManhattanDistanceCalculator();

    public WireCrossingFinder(Wire wire1, Wire wire2) {
        this.wire1 = wire1;
        this.wire2 = wire2;
    }

    public int findClosestCrossingDistance() {
        Point zeroPoint = new Point(0, 0);
        int closestCrossing = 0;

        for (WireSegment segment1: wire1.getSegments()) {
            for (WireSegment segment2: wire2.getSegments()) {
                List<Point> crossingPoints = segment1.getCrossingPointsWith(segment2);
                if (!crossingPoints.isEmpty()) {
                    for (Point crossingPoint: crossingPoints) {
                        int distance = distanceCalculator.getDistanceFromStartPoint(crossingPoint);
                        if (closestCrossing == 0) {
                            closestCrossing = distance;
                        } else if (closestCrossing > distance) {
                            closestCrossing = distance;
                        }
                    }

                }
             }
        }
        return closestCrossing;
    }

    public Wire getWire1() {
        return wire1;
    }

    public void setWire1(Wire wire1) {
        this.wire1 = wire1;
    }

    public Wire getWire2() {
        return wire2;
    }

    public void setWire2(Wire wire2) {
        this.wire2 = wire2;
    }

    public void setDistanceCalculator(DistanceCalculator distanceCalculator) {
        this.distanceCalculator = distanceCalculator;
    }
}
