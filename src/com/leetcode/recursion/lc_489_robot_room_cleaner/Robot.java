package com.leetcode.recursion.lc_489_robot_room_cleaner;

public interface Robot {

    // Returns true if the cell in front is open and robot moves into the cell.
    // Returns false if the cell in front is blocked and robot stays in the current cell.
    boolean move();

    // Each turn will be 90 degrees.
    void turnLeft();
    void turnRight();

    // Clean the current cell.
    void clean();
}