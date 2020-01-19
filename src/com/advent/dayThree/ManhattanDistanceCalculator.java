package com.advent.dayThree;

public class ManhattanDistanceCalculator implements DistanceCalculator{
    Point startPoint = new Point(0, 0);
    @Override
    public int getDistanceFromStartPoint(Point point) {
        return startPoint.getDistanceFrom(point);
    }
}
