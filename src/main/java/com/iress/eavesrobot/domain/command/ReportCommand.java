package com.iress.eavesrobot.domain.command;

import com.iress.eavesrobot.domain.Robot;
import com.iress.eavesrobot.domain.RobotCommand;

public class ReportCommand implements RobotCommand {
    private Robot robot;
    private String command;

    public ReportCommand(Robot robot, String command) {
        super();
        this.robot = robot;
        this.command = command;
    }

    public Robot getRobot() {
        return robot;
    }

    public String getCommand() {
        return command;
    }

    @Override
    public String execute() {
        return robot.report();
    }

}
