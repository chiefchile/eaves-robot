package com.iress.eavesrobot.domain;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class RobotTest {

    @Test
    public void testValidatePosition_XLessThan0() {
        Robot robot = new Robot(new Table(5, 5));
        assertFalse(robot.validatePosition(-1, 1));

    }

    @Test
    public void testValidatePosition_XEqualToTableWidth() {
        int width = 5;
        Robot robot = new Robot(new Table(width, 10));
        assertFalse(robot.validatePosition(width, 0));
    }

    @Test
    public void testValidatePosition_XGreaterThanTableWidth() {
        int width = 5;
        Robot robot = new Robot(new Table(width, 10));
        assertFalse(robot.validatePosition(width + 1, 3));
    }

    @Test
    public void testValidatePosition_YLessThan0() {
        Robot robot = new Robot(new Table(5, 5));
        assertFalse(robot.validatePosition(1, -1));

    }

    @Test
    public void testValidatePosition_YEqualToTableHeight() {
        int height = 10;
        Robot robot = new Robot(new Table(5, height));
        assertFalse(robot.validatePosition(1, height));
    }

    @Test
    public void testValidatePosition_YGreaterThanTableHeight() {
        int height = 2;
        Robot robot = new Robot(new Table(5, height));
        assertFalse(robot.validatePosition(1, height + 1));
    }

    @Test
    public void testValidatePosition_Valid() {
        Robot robot = new Robot(new Table(5, 5));
        assertTrue(robot.validatePosition(1, 1));
    }

    @Test
    public void testPlace_Valid() {
        int width = 5;
        int height = 5;
        Robot robot = new Robot(new Table(width, height));
        int x = 1;
        int y = 1;
        Direction f = Direction.NORTH;

        robot.place(x, y, f);

        assertThat(robot.getCurrX(), is(x));
        assertThat(robot.getCurrY(), is(y));
        assertThat(robot.getCurrF(), is(f));
    }

    @Test
    public void testPlace_Invalid() {
        int width = 5;
        int height = 5;
        Robot robot = new Robot(new Table(width, height));
        Direction f = Direction.NORTH;

        robot.place(width, height, f);

        assertNull(robot.getCurrX());
        assertNull(robot.getCurrY());
        assertNull(robot.getCurrF());
    }

    @Test
    public void testMove_NotPlaced() {
        Robot robot = new Robot(new Table(5, 5));

        robot.move();

        assertNull(robot.getCurrX());
        assertNull(robot.getCurrY());
        assertNull(robot.getCurrF());
    }

    @Test
    public void testMove_InvalidPosition() {
        Robot robot = new Robot(new Table(5, 5));
        int x = 0;
        int y = 0;
        Direction direction = Direction.SOUTH;
        robot.place(x, y, direction);

        robot.move();

        assertThat(robot.getCurrX(), is(x));
        assertThat(robot.getCurrY(), is(y));
    }

    @Test
    public void testMove_FacingNorth() {
        Robot robot = new Robot(new Table(5, 5));
        int x = 0;
        int y = 0;
        Direction direction = Direction.NORTH;
        robot.place(x, y, direction);

        robot.move();

        assertThat(robot.getCurrX(), is(x));
        assertThat(robot.getCurrY(), is(y + 1));
    }

    @Test
    public void testMove_FacingSouth() {
        Robot robot = new Robot(new Table(5, 5));
        int x = 0;
        int y = 1;
        Direction direction = Direction.SOUTH;
        robot.place(x, y, direction);

        robot.move();

        assertThat(robot.getCurrX(), is(x));
        assertThat(robot.getCurrY(), is(y - 1));
    }

    @Test
    public void testMove_FacingEast() {
        Robot robot = new Robot(new Table(5, 5));
        int x = 0;
        int y = 0;
        Direction direction = Direction.EAST;
        robot.place(x, y, direction);

        robot.move();

        assertThat(robot.getCurrX(), is(x + 1));
        assertThat(robot.getCurrY(), is(y));
    }

    @Test
    public void testMove_FacingWest() {
        Robot robot = new Robot(new Table(5, 5));
        int x = 1;
        int y = 0;
        Direction direction = Direction.WEST;
        robot.place(x, y, direction);

        robot.move();

        assertThat(robot.getCurrX(), is(x - 1));
        assertThat(robot.getCurrY(), is(y));
    }

    @Test
    public void testReport() {
        Robot robot = new Robot(new Table(5, 5));
        int x = 1;
        int y = 0;
        Direction direction = Direction.WEST;
        robot.place(x, y, direction);

        String output = robot.report();

        assertThat(output, is("Output: 1,0,WEST"));
    }



}
