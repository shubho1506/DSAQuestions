package DynamicProgramming.Easy;

//There is a robot on an m x n grid. The robot is initially located at the top-left corner (i.e., grid[0][0]).
// The robot tries to move to the bottom-right corner (i.e., grid[m - 1][n - 1]). The robot can only move either down
// or right at any point in time.
//Given the two integers m and n, return the number of possible unique paths that the robot can take to reach the
// bottom-right corner.
//The test cases are generated so that the answer will be less than or equal to 2 * 109.
//Example 1:
//Input: m = 3, n = 7
//Output: 28
//Example 2:
//Input: m = 3, n = 2
//Output: 3
//Explanation: From the top-left corner, there are a total of 3 ways to reach the bottom-right corner:
//1. Right -> Down -> Down
//2. Down -> Down -> Right
//3. Down -> Right -> Down

public class UniquePaths {
    public static void main(String[] args) {
        System.out.println(uniquePaths(3,7));

    }

    public static int uniquePaths(int m, int n) {
        int[][] grid = new int[m][n];
        System.out.println(uniquePathsTabulation(grid));
        return uniquePathsRecursion(grid,0,0);
    }

    private static int uniquePathsRecursion(int[][] grid,int row,int col){
        if (row >= grid.length || col >= grid[0].length) {
            return 0;
        }
        if(row==grid.length-1 && col==grid[0].length-1){
            return 1;
        }
        int right = uniquePathsRecursion(grid,row,col+1);
        int down = uniquePathsRecursion(grid,row+1,col);
        return right+down;
    }

    private static int uniquePathsTabulation(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int[][] dp = new int[rows][cols];
        for (int i = 0; i < rows; i++){
            dp[i][0] = 1;
        }
        for (int j = 0; j < cols; j++){
            dp[0][j] = 1;
        }
        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < cols; j++) {
                dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }
        return dp[rows -1][cols -1];
    }
}
