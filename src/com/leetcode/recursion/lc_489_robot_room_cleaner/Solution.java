package com.leetcode.recursion.lc_489_robot_room_cleaner;

import java.util.AbstractMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * // This is the robot's control interface.
 * // You should not implement it, or speculate about its implementation
 * interface Robot {
 *     // Returns true if the cell in front is open and robot moves into the cell.
 *     // Returns false if the cell in front is blocked and robot stays in the current cell.
 *     public boolean move();
 *
 *     // Robot will stay in the same cell after calling turnLeft/turnRight.
 *     // Each turn will be 90 degrees.
 *     public void turnLeft();
 *     public void turnRight();
 *
 *     // Clean the current cell.
 *     public void clean();
 * }
 */

public class Solution {

    private static final int UP = 0;
    private static final int RIGHT = 1;
    private static final int DOWN = 2;
    private static final int LEFT = 3;
    private static final int[][] directions = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    private Set<Map.Entry<Integer, Integer>> visited = new HashSet<>();
    private Robot robot;

    private int calculateNextRow(int row, int direction) {
        return row + directions[direction][0];
    }

    private int calculateNextCol(int col, int direction) {
        return col + directions[direction][1];
    }

    private int getNextDirection(int currentDirection) {
        return switch (currentDirection) {
            case UP -> RIGHT;
            case RIGHT -> DOWN;
            case DOWN -> LEFT;
            case LEFT -> UP;
            default -> UP;
        };
    }

    private void goBack() {
        robot.turnRight();
        robot.turnRight();
        robot.move();
        robot.turnRight();
        robot.turnRight();
    }

    private void backtrack(int row, int col, int direction) {
        visited.add(new AbstractMap.SimpleEntry<>(row, col));
        robot.clean();
        for (int i = 0; i < 4; i++) {
            int nextRow = calculateNextRow(row, direction);
            int nextCol = calculateNextCol(col, direction);

            if (!visited.contains(new AbstractMap.SimpleEntry<>(nextRow, nextCol)) &&
                    robot.move()) {
                backtrack(nextRow, nextCol, direction);
                goBack();
            }
            robot.turnRight();
            direction = getNextDirection(direction);
        }
    }

    public void cleanRoom(Robot robot) {
        this.robot = robot;
        backtrack(0, 0, UP);
    }
}