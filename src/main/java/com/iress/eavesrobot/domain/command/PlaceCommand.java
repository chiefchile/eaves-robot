package com.iress.eavesrobot.domain.command;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import com.iress.eavesrobot.domain.Direction;
import com.iress.eavesrobot.domain.Robot;
import com.iress.eavesrobot.domain.RobotCommand;

public class PlaceCommand implements RobotCommand {
    private Robot robot;
    private String command;

    public static final Pattern PLACE_PATTERN = Pattern.compile("PLACE\\s(\\d+),(\\d+),([A-Z]+)");

    public Robot getRobot() {
        return robot;
    }

    public String getCommand() {
        return command;
    }

    public PlaceCommand(Robot robot, String command) {
        super();
        this.robot = robot;
        this.command = command;
    }

    @Override
    public String execute() {
        Matcher matcher = PLACE_PATTERN.matcher(command);
        if (!matcher.matches()) {
            return "Invalid command " + command;
        }

        Direction f = null;
        try {
            f = Direction.valueOf(matcher.group(3));
        } catch (IllegalArgumentException e) {
            return "Invalid F in command " + command;
        }

        int x = Integer.parseInt(matcher.group(1));
        int y = Integer.parseInt(matcher.group(2));
        robot.place(x, y, f);
        return "";
    }


}
