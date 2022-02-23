package com.iress.eavesrobot.domain.command;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import org.junit.Test;
import com.iress.eavesrobot.domain.Robot;

public class PlaceCommandTest {

    @Test
    public void testExecute_Valid() {
        Robot robot = Robot.withDefaultTable();
        PlaceCommand placeCommand = new PlaceCommand(robot, "PLACE 0,0,NORTH");

        String result = placeCommand.execute();

        assertThat(result, is(""));
        assertThat(robot.getCurrX(), is(0));
        assertThat(robot.getCurrY(), is(0));
    }

    @Test
    public void testExecute_Invalid() {
        Robot robot = Robot.withDefaultTable();
        PlaceCommand placeCommand = new PlaceCommand(robot, "PLACE a,b,c");

        String result = placeCommand.execute();

        assertThat(result, is("Invalid command PLACE a,b,c"));
    }

    @Test
    public void testExecute_InvalidF() {
        Robot robot = Robot.withDefaultTable();
        PlaceCommand placeCommand = new PlaceCommand(robot, "PLACE 0,0,A");

        String result = placeCommand.execute();

        assertThat(result, is("Invalid F in command PLACE 0,0,A"));
    }

}
