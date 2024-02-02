package com.leetcode.companies.bloomberg.lc_1274_number_of_ships_in_a_rectangle;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

/**
 * // This is Sea's API interface.
 * // You should not implement it, or speculate about its implementation
 * class Sea {
 *     public boolean hasShips(int[] topRight, int[] bottomLeft);
 * }
 */

class Solution {
    public int countShips(Sea sea, int[] topRight, int[] bottomLeft) {
        // End of recursion
        if (bottomLeft[0] > topRight[0] || bottomLeft[1] > topRight[1]) {
            return 0;
        }
        if (!sea.hasShips(topRight, bottomLeft)) {
            return 0;
        }
        if (topRight[0] == bottomLeft[0] && topRight[1] == bottomLeft[1]) {
            return 1;
        }

        int midX = (topRight[0] + bottomLeft[0]) / 2;
        int midY = (topRight[1] + bottomLeft[1]) / 2;

        // Top left square
        int topLeftSquareBottomLeftX = bottomLeft[0]; // X
        int topLeftSquareBottomLeftY = midY + 1;
        int topLeftSquareTopRightX = midX;
        int topLeftSquareTopRightY = topRight[1]; // Y
        int[] topLeftSquareBottomLeft = {topLeftSquareBottomLeftX, topLeftSquareBottomLeftY};
        int[] topLeftSquareTopRight = {topLeftSquareTopRightX, topLeftSquareTopRightY};

        // Top right square
        int topRightSquareBottomLeftX = midX + 1;
        int topRightSquareBottomLeftY = midY + 1;
        int topRightSquareTopRightX = topRight[0]; // X
        int topRightSquareTopRightY = topRight[1]; // Y
        int[] topRightSquareBottomLeft = {topRightSquareBottomLeftX, topRightSquareBottomLeftY};
        int[] topRightSquareTopRight = {topRightSquareTopRightX, topRightSquareTopRightY};

        // Bottom left square
        int bottomLeftSquareBottomLeftX = bottomLeft[0]; // X
        int bottomLeftSquareBottomLeftY = bottomLeft[1]; // Y
        int bottomLeftSquareTopRightX = midX;
        int bottomLeftSquareTopRightY = midY;
        int[] bottomLeftSquareBottomLeft = {bottomLeftSquareBottomLeftX, bottomLeftSquareBottomLeftY};
        int[] bottomLeftSquareTopRight = {bottomLeftSquareTopRightX, bottomLeftSquareTopRightY};

        // Bottom right square
        int bottomRightSquareBottomLeftX = midX + 1;
        int bottomRightSquareBottomLeftY = bottomLeft[1]; // Y
        int bottomRightSquareTopRightX = topRight[0]; // X
        int bottomRightSquareTopRightY = midY;
        int[] bottomRightSquareBottomLeft = {bottomRightSquareBottomLeftX, bottomRightSquareBottomLeftY};
        int[] bottomRightSquareTopRight = {bottomRightSquareTopRightX, bottomRightSquareTopRightY};

        return countShips(sea, topLeftSquareTopRight, topLeftSquareBottomLeft) +
                countShips(sea, topRightSquareTopRight, topRightSquareBottomLeft) +
                countShips(sea, bottomLeftSquareTopRight, bottomLeftSquareBottomLeft) +
                countShips(sea, bottomRightSquareTopRight, bottomRightSquareBottomLeft);
    }
}