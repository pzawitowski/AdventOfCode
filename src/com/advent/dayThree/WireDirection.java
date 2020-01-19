package com.advent.dayThree;

public enum WireDirection {
    UP("U"),
    DOWN("D"),
    RIGHT("R"),
    LEFT("L");

    private String textRepresentation;

    WireDirection(String textRepresentation) {
        this.textRepresentation = textRepresentation;
    }

    public static WireDirection fromString(String direction) {
        if ("D".equals(direction)) {
            return DOWN;
        }
        else if ("U".equals(direction)) {
            return UP;
        }
        else if ("R".equals(direction)) {
            return RIGHT;
        }
        else if ("L".equals(direction)) {
            return LEFT;
        }
        throw new IllegalArgumentException("Invalid direction: " + direction);
    }
}
