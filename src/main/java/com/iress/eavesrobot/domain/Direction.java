package com.iress.eavesrobot.domain;

import java.util.Arrays;
import java.util.List;

public enum Direction {
    NORTH, SOUTH, EAST, WEST;

    private static final List<Direction> CLOCKWISE = Arrays.asList(NORTH, EAST, SOUTH, WEST);

    private static final List<Direction> COUNTERCLOCKWISE = Arrays.asList(NORTH, WEST, SOUTH, EAST);

    public Direction rotateClockwise() {
        int index = CLOCKWISE.indexOf(this);
        return CLOCKWISE.get((index + 1) % Direction.values().length);
    }

    public Direction rotateCounterClockwise() {
        int index = COUNTERCLOCKWISE.indexOf(this);
        return COUNTERCLOCKWISE.get((index + 1) % Direction.values().length);
    }
}
