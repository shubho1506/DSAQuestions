package DynamicProgramming.Medium;

//Given an m x n grid filled with non-negative numbers, find a path from top left to bottom right, which minimizes the
// sum of all numbers along its path.
//Note: You can only move either down or right at any point in time.
//Example 1:
//Input: grid = [[1,3,1],[1,5,1],[4,2,1]]
//Output: 7
//Explanation: Because the path 1 → 3 → 1 → 1 → 1 minimizes the sum.
//Example 2:
//Input: grid = [[1,2,3],[4,5,6]]
//Output: 12

public class MinimumPathSum {
    public static void main(String[] args) {
        int[][] grid = {{1,3,1},{1,5,1},{4,2,1}};
        System.out.println(minPathSum(grid));
        System.out.println(minPathSumTabulation(grid));
    }

    public static int minPathSum(int[][] grid) {
        return minPathSumRecursion(grid,0,0);
    }

    private static int minPathSumRecursion(int[][] grid,int row,int col){
        if(row>=grid.length || col>=grid[0].length){
            return Integer.MAX_VALUE;
        }
        if(row==grid.length-1 && col==grid[0].length-1){
            return grid[row][col];
        }
        int right = minPathSumRecursion(grid,row,col+1);
        int down = minPathSumRecursion(grid,row+1,col);
        return grid[row][col] + Math.min(right, down);
    }

    public static int minPathSumTabulation(int[][] grid){
        int rows = grid.length;
        int cols = grid[0].length;
        int[][] dp = new int[rows][cols];
        dp[0][0] = grid[0][0];
        for (int j = 1; j < cols; j++) {
            dp[0][j] = grid[0][j] + dp[0][j-1];
        }
        for (int i = 1; i < rows; i++) {
            dp[i][0] = grid[i][0] + dp[i-1][0];
        }
        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < cols; j++) {
                dp[i][j] = grid[i][j] + Math.min(dp[i-1][j], dp[i][j-1]);
            }
        }

        return dp[rows-1][cols-1];
    }
}
