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

    public Table getTable() {
        return table;
    }

    public void place(int x, int y, Direction f) {
        if (!validatePosition(x, y)) {
            return;
        }

        currX = x;
        currY = y;
        currF = f;

    }

    public boolean validatePosition(int newX, int newY) {
        if (newX < 0 || newX >= table.getWidth() || newY < 0 || newY >= table.getHeight()) {
            return false;
        }

        return true;
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


}
