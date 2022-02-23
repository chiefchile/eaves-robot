package com.iress.eavesrobot.domain;

import java.lang.reflect.Constructor;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.reflections.Reflections;
import org.reflections.scanners.SubTypesScanner;

public class RobotCommandParser {
    private static final Map<String, Class<?>> COMMANDS_MAP = populateMap();

    private static Map<String, Class<?>> populateMap() {
        Map<String, Class<?>> map = new HashMap<>();
        findCommandClasses("com.iress.eavesrobot.domain.command").forEach(clazz -> map
                .put(clazz.getSimpleName().toUpperCase().replace("COMMAND", ""), clazz));
        return map;
    }

    private static List<Class<?>> findCommandClasses(String packageName) {
        Reflections reflections = new Reflections(packageName, new SubTypesScanner(false));
        return reflections.getSubTypesOf(Object.class).stream().collect(Collectors.toList());
    }

    // Returns "" if successful. Returns "Output..." if reporting. Any other return value is an
    // error.
    public static String parse(Robot robot, String command) {
        try {
            String commandType = command.split(" ")[0];
            Class<?> clazz = COMMANDS_MAP.get(commandType);
            if (clazz == null) {
                return "Invalid command " + command;
            }

            Constructor<?> constructor = clazz.getConstructor(Robot.class, String.class);
            RobotCommand robotCommand = (RobotCommand) constructor.newInstance(robot, command);
            return robotCommand.execute();

        } catch (Exception e) {
            throw new RuntimeException(e.getMessage(), e);
        }
    }

    public static void main(String[] args) {

    }
}
