package com.advent.dayThree;

public class WireDistanceCalculator implements DistanceCalculator {
    private Wire wire1;
    private Wire wire2;

    public WireDistanceCalculator(Wire wire1, Wire wire2) {
        this.wire1 = wire1;
        this.wire2 = wire2;
        calculateWireSegmentDistances(wire1);
        calculateWireSegmentDistances(wire2);
    }

    @Override
    public int getDistanceFromStartPoint(Point point) {
       return getDistanceForWire(wire1, point) + getDistanceForWire(wire2, point);
    }

    private int getDistanceForWire(Wire wire, Point point) {
        int distance = 0;
        for (WireSegment segment: wire.getSegments()) {
            if (segment.containsPoint(point)) {
                distance += segment.getFirstPoint().getDistanceFrom(point);
                return distance;
            } else {
                distance += segment.getLength();
            }
        }

        return distance;
    }

    private void calculateWireSegmentDistances(Wire wire) {
        int distance = 0;
        for (WireSegment wireSegment: wire.getSegments()) {
                wireSegment.setDistanceFromStart(distance);
                distance += wireSegment.getLength();
        }
    }
}
