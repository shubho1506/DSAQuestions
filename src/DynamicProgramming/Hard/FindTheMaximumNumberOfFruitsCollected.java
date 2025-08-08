package DynamicProgramming.Hard;

//There is a game dungeon comprised of n x n rooms arranged in a grid.
//You are given a 2D array fruits of size n x n, where fruits[i][j] represents the number of fruits in the room (i, j).
// Three children will play in the game dungeon, with initial positions at the corner rooms (0, 0), (0, n - 1),
// and (n - 1, 0).
//The children will make exactly n - 1 moves according to the following rules to reach the room (n - 1, n - 1):
//The child starting from (0, 0) must move from their current room (i, j) to one of the rooms (i + 1, j + 1),
// (i + 1, j), and (i, j + 1) if the target room exists.
//The child starting from (0, n - 1) must move from their current room (i, j) to one of the rooms (i + 1, j - 1),
// (i + 1, j), and (i + 1, j + 1) if the target room exists.
//The child starting from (n - 1, 0) must move from their current room (i, j) to one of the rooms (i - 1, j + 1),
// (i, j + 1), and (i + 1, j + 1) if the target room exists.
//When a child enters a room, they will collect all the fruits there. If two or more children enter the same room,
// only one child will collect the fruits, and the room will be emptied after they leave.
//Return the maximum number of fruits the children can collect from the dungeon.

//Example 1:
//Input: fruits = [[1,2,3,4],[5,6,8,7],[9,10,11,12],[13,14,15,16]]
//Output: 100
//Explanation:
//In this example:
//The 1st child (green) moves on the path (0,0) -> (1,1) -> (2,2) -> (3, 3).
//The 2nd child (red) moves on the path (0,3) -> (1,2) -> (2,3) -> (3, 3).
//The 3rd child (blue) moves on the path (3,0) -> (3,1) -> (3,2) -> (3, 3).
//In total they collect 1 + 6 + 11 + 16 + 4 + 8 + 12 + 13 + 14 + 15 = 100 fruits.

//Example 2:
//Input: fruits = [[1,1],[1,1]]
//Output: 4
//Explanation:
//In this example:
//The 1st child moves on the path (0,0) -> (1,1).
//The 2nd child moves on the path (0,1) -> (1,1).
//The 3rd child moves on the path (1,0) -> (1,1).
//In total they collect 1 + 1 + 1 + 1 = 4 fruits.

import java.util.Arrays;

public class FindTheMaximumNumberOfFruitsCollected {
    public static void main(String[] args) {
        int[][] fruits = {{1,2,3,4},{5,6,8,7},{9,10,11,12},{13,14,15,16}};
        System.out.println(maxCollectedFruits(fruits));
    }

    public static int maxCollectedFruits(int[][] fruits) {
        int n = fruits.length;
        int[][] dp1 = new int[n][n];
        int[][] dp2 = new int[n][n];
        int totalFruits = 0;
        for(int[] arr : dp1){
            Arrays.fill(arr,-1);
        }
        for(int[] arr : dp2){
            Arrays.fill(arr,-1);
        }
        for(int i=0;i<n;i++){
            totalFruits += fruits[i][i];
        }
        totalFruits += solveBottomLeft(n-1,0,dp1,n,fruits);
        totalFruits += solveTopRight(0,n-1,dp2,n,fruits);
        return totalFruits;
    }

    private static int solveBottomLeft(int i,int j,int[][] dp,int n,int[][] fruits){
        if(i==n-1 && j==n-1){
            return 0;
        }
        if(j>=i){
            return 0;
        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        int maxFruits = 0;
        int collectedFruits = fruits[i][j];
        if(i-1>=0){
            maxFruits = Math.max(maxFruits,collectedFruits+solveBottomLeft(i-1,j+1,dp,n,fruits));
        }
        if(i+1<n){
            maxFruits = Math.max(maxFruits,collectedFruits+solveBottomLeft(i+1,j+1,dp,n,fruits));
        }
        if(j+1<n){
            maxFruits = Math.max(maxFruits,collectedFruits+solveBottomLeft(i,j+1,dp,n,fruits));
        }
        return dp[i][j] = maxFruits;
    }

    private static int solveTopRight(int i,int j,int[][] dp,int n,int[][] fruits){
        if(i==n-1 && j==n-1){
            return 0;
        }
        if(i>=j){
            return 0;
        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        int maxFruits = 0;
        int collectedFruits = fruits[i][j];
        if(j-1>=0){
            maxFruits = Math.max(maxFruits,collectedFruits+solveTopRight(i+1,j-1,dp,n,fruits));
        }
        if(i+1<n){
            maxFruits = Math.max(maxFruits,collectedFruits+solveTopRight(i+1,j,dp,n,fruits));
        }
        if(j+1<n){
            maxFruits = Math.max(maxFruits,collectedFruits+solveTopRight(i+1,j+1,dp,n,fruits));
        }
        return dp[i][j] = maxFruits;
    }
}
