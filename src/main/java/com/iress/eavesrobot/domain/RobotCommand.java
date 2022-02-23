package com.iress.eavesrobot.domain;

public interface RobotCommand {

    // Returns "" if successful otherwise returns the error msg
    public String execute();
}
