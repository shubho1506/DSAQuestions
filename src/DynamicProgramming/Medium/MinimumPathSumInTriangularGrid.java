package DynamicProgramming.Medium;

//Given a triangle array, return the minimum path sum from top to bottom.
//For each step, you may move to an adjacent number of the row below. More formally, if you are on index i on the
//current row, you may move to either index i or index i + 1 on the next row.

//Example 1:
//Input: triangle = [[2],[3,4],[6,5,7],[4,1,8,3]]
//Output: 11
//Explanation: The triangle looks like:
//   2
//  3 4
// 6 5 7
//4 1 8 3
//The minimum path sum from top to bottom is 2 + 3 + 5 + 1 = 11 (underlined above).

//Example 2:
//Input: triangle = [[-10]]
//Output: -10

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MinimumPathSumInTriangularGrid {
    public static void main(String[] args) {
        List<List<Integer>> triangle = new ArrayList<>();
        triangle.add(List.of(2));
        triangle.add(Arrays.asList(3, 4));
        triangle.add(Arrays.asList(6, 5, 7));
        triangle.add(Arrays.asList(4, 1, 8, 3));

        System.out.println("Minimum Path Sum = " + minimumTotal(triangle));
        System.out.println("Minimum Path Sum = " + minimumTotalTabulation(triangle));

    }

    public static int minimumTotal(List<List<Integer>> triangle) {
        return minimumTotalRec(triangle,0,0);
    }

    private static int minimumTotalRec(List<List<Integer>> triangle,int row,int col){
        if (row == triangle.size() - 1) {
            return triangle.get(row).get(col);
        }
        int down = minimumTotalRec(triangle, row + 1, col);
        int downRight = minimumTotalRec(triangle, row + 1, col + 1);
        return triangle.get(row).get(col) + Math.min(down, downRight);
    }

    public static int minimumTotalTabulation(List<List<Integer>> triangle){
        int n = triangle.size();
        int[][] dp = new int[n][n];
        for (int j = 0; j < n; j++) {
            dp[n - 1][j] = triangle.get(n - 1).get(j);
        }
        for (int i = n - 2; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                dp[i][j] = triangle.get(i).get(j) +
                        Math.min(dp[i + 1][j], dp[i + 1][j + 1]);
            }
        }
        return dp[0][0];
    }

    public static int minimumTotalTabOptimized(List<List<Integer>> triangle) {
        int n = triangle.size();
        // dp will store min path sums for the "row below"
        int[] dp = new int[n];

        // Initialize dp with the last row of triangle
        for (int j = 0; j < n; j++) {
            dp[j] = triangle.get(n - 1).get(j);
        }

        // Build dp array from bottom-2 row upwards
        for (int row = n - 2; row >= 0; row--) {
            for (int col = 0; col <= row; col++) {
                dp[col] = triangle.get(row).get(col) + Math.min(dp[col], dp[col + 1]);
            }
        }

        // dp[0] will have the result
        return dp[0];
    }
}
