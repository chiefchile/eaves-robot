package com.iress.eavesrobot.ui;

import java.util.Scanner;
import com.iress.eavesrobot.domain.Robot;
import com.iress.eavesrobot.domain.Table;

public class RobotCli {

    // TODO: Add exception handler
    public static void main(String[] args) {
        System.out.println("EAVES-ROBOT");
        System.out.println("Enter command: ");
        Robot robot = Robot.withDefaultTable();
        try (Scanner in = new Scanner(System.in)) {
            while (true) {
                String command = in.nextLine().trim();
                String parseResult = parse(robot, command);
                if () {
                    break;
                }
            }
        }
    }
}
