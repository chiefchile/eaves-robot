package com.iress.eavesrobot.ui;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import org.junit.Test;

public class RobotCliTest {

    @Test
    public void testStart_AllValid() {
        StringBuilder sb = new StringBuilder();
        sb.append("PLACE 0,0,NORTH\n");
        sb.append("MOVE\n");
        sb.append("RIGHT\n");
        sb.append("MOVE\n");
        sb.append("LEFT\n");
        sb.append("MOVE\n");
        sb.append("REPORT\n");
        sb.append("EXIT\n");
        InputStream inputStream = new ByteArrayInputStream(sb.toString().getBytes());
        OutputStream outputStream = new ByteArrayOutputStream();
        RobotCli robotCli = new RobotCli(inputStream, outputStream);

        robotCli.start();

        String[] splits = outputStream.toString().split("\n");
        String output = splits[splits.length - 1];
        assertThat(output, is("Output: 1,2,NORTH"));
    }

    @Test
    public void testStart_InvalidCommand() {
        StringBuilder sb = new StringBuilder();
        sb.append("JUMP\n");
        sb.append("PLACE 2,3,SOUTH\n");
        sb.append("REPORT\n");
        sb.append("EXIT\n");
        InputStream inputStream = new ByteArrayInputStream(sb.toString().getBytes());
        OutputStream outputStream = new ByteArrayOutputStream();
        RobotCli robotCli = new RobotCli(inputStream, outputStream);

        robotCli.start();

        String[] splits = outputStream.toString().split("\n");
        String errMsg = splits[splits.length - 2];
        String output = splits[splits.length - 1];
        assertThat(errMsg, is("Invalid command JUMP"));
        assertThat(output, is("Output: 2,3,SOUTH"));
    }

}
