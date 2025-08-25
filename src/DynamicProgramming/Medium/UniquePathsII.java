package DynamicProgramming.Medium;

//You are given an m x n integer array grid. There is a robot initially located at the top-left corner (i.e., grid[0][0]).
// The robot tries to move to the bottom-right corner (i.e., grid[m - 1][n - 1]). The robot can only move either down or
// right at any point in time.
//An obstacle and space are marked as 1 or 0 respectively in grid. A path that the robot takes cannot include any square
// that is an obstacle.
//Return the number of possible unique paths that the robot can take to reach the bottom-right corner.
//The testcases are generated so that the answer will be less than or equal to 2 * 109.
//Example 1:
//Input:
//Output: 2
//Explanation: There is one obstacle in the middle of the 3x3 grid above.
//There are two ways to reach the bottom-right corner:
//1. Right -> Right -> Down -> Down
//2. Down -> Down -> Right -> Right
//Example 2:
//Input: obstacleGrid = [[0,1],[0,0]]
//Output: 1

import java.util.Arrays;

public class UniquePathsII {
    public static void main(String[] args) {
        int[][] obstacleGrid = {{0,0,0},{0,1,0},{0,0,0}};
        System.out.println(uniquePathsWithObstacles(obstacleGrid));
        System.out.println(uniquePathsWithObstaclesTabulation(obstacleGrid));
    }

    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        return uniquePathsWithObstaclesRec(obstacleGrid,0,0);
    }

    private static int uniquePathsWithObstaclesRec(int[][] obstacleGrid,int row,int col){
        if(row>=obstacleGrid.length || col==obstacleGrid[0].length || obstacleGrid[row][col]==1){
            return 0;
        }
        if(row==obstacleGrid.length-1 && col==obstacleGrid[0].length-1){
            return 1;
        }
        return uniquePathsWithObstaclesRec(obstacleGrid,row+1,col)
                + uniquePathsWithObstaclesRec(obstacleGrid,row,col+1);
    }

    private static int uniquePathsWithObstaclesTabulation(int[][] obstacleGrid){
        int rows = obstacleGrid.length;
        int cols = obstacleGrid[0].length;
        int[][] dp = new int[rows][cols];
        if (obstacleGrid[0][0] == 1 || obstacleGrid[rows - 1][cols - 1] == 1) {
            return 0;
        }
        dp[0][0] = 1;
        for (int i = 1; i < rows; i++) {
            if (obstacleGrid[i][0] == 0) {
                dp[i][0] = dp[i - 1][0];
            }
        }
        for (int j = 1; j < cols; j++) {
            if (obstacleGrid[0][j] == 0) {
                dp[0][j] = dp[0][j - 1];
            }
        }
        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < cols; j++) {
                if (obstacleGrid[i][j] == 0) {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                } else {
                    dp[i][j] = 0;
                }
            }
        }
        return dp[rows - 1][cols - 1];
    }
}
