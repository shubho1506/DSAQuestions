package POTD;

//Given an m x n matrix mat, return an array of all the elements of the array in a diagonal order.
//Example 1:
//Input: mat = [[1,2,3],[4,5,6],[7,8,9]]
//Output: [1,2,4,7,5,3,6,8,9]

//Example 2:
//Input: mat = [[1,2],[3,4]]
//Output: [1,2,3,4]

import java.util.Arrays;

public class DiagonalTraverse {
    public static void main(String[] args) {
        int[][] mat = {{1,2,3},{4,5,6},{7,8,9}};
        System.out.println(Arrays.toString(findDiagonalOrder(mat)));
    }

    public static int[] findDiagonalOrder(int[][] mat) {
        int rows = mat.length;
        int cols = mat[0].length;
        int[] nums = new int[rows*cols];
        int idx = 0;
        int row = 0;
        int col = 0;
        boolean upward = true;
        while (idx < rows * cols) {
            nums[idx++] = mat[row][col];
            if (upward) {
                if (col == cols - 1) {
                    row++;
                    upward = false;
                } else if (row == 0) {
                    col++;
                    upward = false;
                } else {
                    row--;
                    col++;
                }
            } else {
                if (row == rows - 1) {
                    col++;
                    upward = true;
                } else if (col == 0) {
                    row++;
                    upward = true;
                } else {
                    row++;
                    col--;
                }
            }
        }
        return nums;
    }
}
