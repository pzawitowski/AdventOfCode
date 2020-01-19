package com.advent.dayThree;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class WireSegment {
    private Point firstPoint;
    private Point secondPoint;
    private int length;
    private Integer distanceFromStart;

    private List<Point> crossingPoints = new ArrayList<>();

    public WireSegment(Point firstPoint, Point secondPoint) {
        this.firstPoint = firstPoint;
        this.secondPoint = secondPoint;

        if (isHorizontal()) {
            length = Math.abs(firstPoint.getX() - secondPoint.getX());
        } else {
            length = Math.abs(firstPoint.getY() - secondPoint.getY());
        }
    }

    public Point getFirstPoint() {
        return firstPoint;
    }

    public void setFirstPoint(Point firstPoint) {
        this.firstPoint = firstPoint;
    }

    public Point getSecondPoint() {
        return secondPoint;
    }

    public void setSecondPoint(Point secondPoint) {
        this.secondPoint = secondPoint;
    }

    public Optional<Point> getCrossingPointWithSegment(WireSegment segment) {


        return Optional.empty();
    }

    public List<Point> getCrossingPointsWith(WireSegment segment) {
        Point crossingPoint;
        List<Point> crossingPoints = new ArrayList<>();
        if (isVertical() && segment.isVertical()) { // assume it is not possible
            if (firstPoint.getX() == segment.getFirstPoint().getX()) {
                int minY = Math.min(Math.min(firstPoint.getY(), secondPoint.getY()), Math.min(segment.getFirstPoint().getY(), segment.getSecondPoint().getY()));
                int maxY = Math.max(Math.max(firstPoint.getY(), secondPoint.getY()), Math.max(segment.getFirstPoint().getY(), segment.getSecondPoint().getY()));

                for (int i = minY; i <= maxY ; i++) {
                    crossingPoint = new Point(firstPoint.getX(), i);
                    if (containsPoint(crossingPoint) && segment.containsPoint(crossingPoint)) {
                        crossingPoints.add(crossingPoint);
                    }
                }
            }

            return crossingPoints;
        } else if (isHorizontal() && segment.isHorizontal()) {

            if (firstPoint.getY() == segment.getFirstPoint().getY()) {

                int minX = Math.min(Math.min(firstPoint.getX(), secondPoint.getX()), Math.min(segment.getFirstPoint().getX(), segment.getSecondPoint().getX()));
                int maxX = Math.max(Math.max(firstPoint.getX(), secondPoint.getX()), Math.max(segment.getFirstPoint().getX(), segment.getSecondPoint().getX()));

                for (int i = minX; i <= maxX ; i++) {
                    crossingPoint = new Point(i, firstPoint.getY());
                    if (containsPoint(crossingPoint) && segment.containsPoint(crossingPoint)) {
                        crossingPoints.add(crossingPoint);
                    }

                }
            }

            return crossingPoints;
        } else if (isHorizontal() && segment.isVertical()) {
            crossingPoint = new Point(segment.firstPoint.getX(), firstPoint.getY());
            if (containsPoint(crossingPoint) && segment.containsPoint(crossingPoint)) {
                crossingPoints.add(crossingPoint);
                return crossingPoints;
            }
        } else {
            crossingPoint = new Point(firstPoint.getX(),segment.firstPoint.getY());
            if (containsPoint(crossingPoint) && segment.containsPoint(crossingPoint)) {
                crossingPoints.add(crossingPoint);
                return crossingPoints;
            }
        }
        return crossingPoints;
    }

    public boolean isHorizontal() {
        return firstPoint.getY() == secondPoint.getY();
    }

    public boolean isVertical() {
        return firstPoint.getX() == secondPoint.getX();
    }

    public boolean containsPoint(Point point) {
        return  (
                    (firstPoint.getX() >= point.getX() && secondPoint.getX() <= point.getX())  ||
                    (firstPoint.getX() <= point.getX() && secondPoint.getX() >= point.getX())
                )
                    &&
                (
                    (firstPoint.getY() >= point.getY() && secondPoint.getY() <= point.getY())  ||
                    (firstPoint.getY() <= point.getY() && secondPoint.getY() >= point.getY())
                );
    }

    public List<Point> getCrossingPoints() {
        return crossingPoints;
    }

    public void setCrossingPoints(List<Point> crossingPoints) {
        this.crossingPoints = crossingPoints;
    }

    public int getLength() {
        return length;
    }


    public Integer getDistanceFromStart() {
        return distanceFromStart;
    }

    public void setDistanceFromStart(Integer distanceFromStart) {
        this.distanceFromStart = distanceFromStart;
    }
}
