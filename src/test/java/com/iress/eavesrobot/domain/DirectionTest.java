package com.iress.eavesrobot.domain;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import org.junit.Test;

public class DirectionTest {

    @Test
    public void testRotateClockwise() {
        Direction rotated = Direction.WEST.rotateClockwise();
        assertThat(rotated, is(Direction.NORTH));
    }

    @Test
    public void testRotateCounterClockwise() {
        Direction rotated = Direction.EAST.rotateCounterClockwise();
        assertThat(rotated, is(Direction.NORTH));
    }

}
