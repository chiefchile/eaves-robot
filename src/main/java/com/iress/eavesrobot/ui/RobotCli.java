package com.iress.eavesrobot.ui;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.Scanner;
import com.iress.eavesrobot.domain.Robot;
import com.iress.eavesrobot.domain.RobotCommandParser;

public class RobotCli {
    private InputStream inputStream;
    private OutputStream outputStream;

    RobotCli(InputStream inputStream, OutputStream outsOutputStream) {
        super();
        this.inputStream = inputStream;
        this.outputStream = outsOutputStream;
    }


    InputStream getInputStream() {
        return inputStream;
    }

    OutputStream getOutputStream() {
        return outputStream;
    }

    public static void main(String[] args) {
        RobotCli robotCli = new RobotCli(System.in, System.out);
        robotCli.start();
    }


    void start() {
        try (Scanner in = new Scanner(inputStream)) {
            outputStream.write("EAVES-ROBOT\n".getBytes());
            outputStream.write("Enter command:\n".getBytes());
            Robot robot = Robot.withDefaultTable();
            while (true) {
                String command = in.nextLine().trim();
                if (command.equals("EXIT")) {
                    break;
                }

                String parseResult = RobotCommandParser.parse(robot, command);
                if (!parseResult.isEmpty()) {
                    outputStream.write((parseResult + "\n").getBytes());
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
