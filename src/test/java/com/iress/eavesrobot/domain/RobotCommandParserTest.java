package com.iress.eavesrobot.domain;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import org.junit.Test;

public class RobotCommandParserTest {

    @Test
    public void testParse_InvalidCommandType() {
        Robot robot = Robot.withDefaultTable();
        String result = RobotCommandParser.parse(robot, "JUMP");
        assertThat(result, is("Invalid command JUMP"));

    }

    @Test
    public void testParse_InvalidParams() {
        Robot robot = Robot.withDefaultTable();
        String result = RobotCommandParser.parse(robot, "PLACE a,b,c");
        assertThat(result, is("Invalid command PLACE a,b,c"));

    }

    @Test
    public void testParse_Valid() {
        Robot robot = Robot.withDefaultTable();
        String result = RobotCommandParser.parse(robot, "PLACE 0,0,NORTH");
        assertThat(result, is(""));

    }

    // @Test
    // public void testFindCommandClasses() {
    // List<Class<?>> classes = RobotCommandParser.findCommandClasses();
    // assertThat(classes.size(), is(2));
    // assertTrue(classes.contains(PlaceCommand.class));
    // assertTrue(classes.contains(ReportCommand.class));
    //
    //
    // }

}
