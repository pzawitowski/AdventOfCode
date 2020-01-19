package com.advent.dayThree;

import sun.awt.image.ImageWatched;

import java.util.LinkedList;

public class Wire {
    private LinkedList<Point> path = new LinkedList<>();
    private LinkedList<WireSegment> segments = new LinkedList<>();

    public Wire() {
    }

    public Wire(Point startingPoint) {
        path.add(startingPoint);
    }

    public Wire(String wireText) {
        path.add(new Point(0, 0)); //starting point

        String[] wireSegments = wireText.split(",");
        for (int i = 0; i < wireSegments.length; i++) {
            WireDirection direction = WireDirection.fromString(wireSegments[i].substring(0, 1));
            int distance = Integer.valueOf(wireSegments[i].substring(1));
            addWireWireSegment(direction, distance);
        }
    }

    public Wire addWireWireSegment(WireDirection direction, int length) {
        Point lastPoint = getLastPoint();
        switch (direction) {
            case UP:
                segments.add(new WireSegment(lastPoint, new Point(lastPoint.getX(), lastPoint.getY() + length)));
                break;
            case DOWN:
                segments.add(new WireSegment(lastPoint, new Point(lastPoint.getX(), lastPoint.getY() - length)));
                break;
            case LEFT:
                segments.add(new WireSegment(lastPoint, new Point(lastPoint.getX() - length, lastPoint.getY())));
                break;
            case RIGHT:
                segments.add(new WireSegment(lastPoint, new Point(lastPoint.getX() + length, lastPoint.getY())));
                break;
        }
        return this;
    }

    public Point getLastPoint() {
        if (segments.isEmpty()) {
            return new Point(0, 0);
        } else {
            return segments.getLast().getSecondPoint();
        }
    }


    public LinkedList<Point> getPath() {
        return path;
    }

    public LinkedList<WireSegment> getSegments() {
        return segments;
    }

    public void setSegments(LinkedList<WireSegment> segments) {
        this.segments = segments;
    }
}
