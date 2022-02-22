package com.iress.eavesrobot.domain;

public class Robot {
    private Table table;
    private Integer currX;
    private Integer currY;
    private Direction currF;

    public Robot(Table table) {
        super();
        this.table = table;
    }

    public void place(int x, int y, Direction f) {
        if (!validatePosition(x, y)) {
            return;
        }

        currX = x;
        currY = y;
        currF = f;
    }

    boolean validatePosition(int x, int y) {
        if (x < 0 || x >= table.getWidth() || y < 0 || y >= table.getHeight()) {
            return false;
        }

        return true;
    }

    public void move() {
        if (currX == null) {
            return;
        }

        Integer newX = currX;
        Integer newY = currY;

        switch (currF) {
            case NORTH:
                newY++;
                break;

            case SOUTH:
                newY--;
                break;

            case EAST:
                newX++;
                break;

            case WEST:
                newX--;
                break;

            default:
                throw new RuntimeException("Invalid direction");
        }

        if (!validatePosition(newX, newY)) {
            return;
        }

        currX = newX;
        currY = newY;
    }

    public void left() {
        currF = currF.rotateCounterClockwise();
    }

    public void right() {
        currF = currF.rotateClockwise();
    }

    public String report() {
        return String.format("Output: %d,%d,%s", currX, currY, currF);
    }

    public Integer getCurrX() {
        return currX;
    }

    public Integer getCurrY() {
        return currY;
    }

    public Direction getCurrF() {
        return currF;
    }

    public Table getTable() {
        return table;
    }

}
