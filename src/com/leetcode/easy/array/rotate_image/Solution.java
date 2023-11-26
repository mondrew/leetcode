package com.leetcode.easy.array.rotate_image;

public class Solution {

    /**
     * Method: Transpose + verticalMirror
     */
    public static void rotate(int[][] matrix) {
        transpose(matrix);
        mirrorVertical(matrix);
    }
    private static void transpose(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = i + 1; j < matrix[i].length; j++) {
                if (i != j) {
                    int temp = matrix[i][j];
                    matrix[i][j] = matrix[j][i];
                    matrix[j][i] = temp;
                }
            }
        }
    }

    private static void mirrorVertical(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < (matrix.length + 1) / 2; j++) {
                int temp = matrix[i][j];
                int jOpposite = matrix.length - 1 - j;
                matrix[i][j] = matrix[i][jOpposite];
                matrix[i][jOpposite] = temp;
            }
        }
    }

    private static void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j]);
                System.out.print("\t");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
        int[][] matrix2 = {{5,1,9,11},{2,4,8,10},{13,3,6,7},{15,14,12,16}};
        printMatrix(matrix2);
        rotate(matrix2);
        System.out.println("----------");
        printMatrix(matrix2);
    }

}
