package DynamicProgramming.Medium;

//Given an n x n array of integers matrix, return the minimum sum of any falling path through matrix.
//A falling path starts at any element in the first row and chooses the element in the next row that is either directly
// below or diagonally left/right. Specifically, the next element from position (row, col) will be
// (row + 1, col - 1), (row + 1, col), or (row + 1, col + 1).

//Example 1:
//Input: matrix = [[2,1,3],[6,5,4],[7,8,9]]
//Output: 13
//Explanation: There are two falling paths with a minimum sum as shown.

//Example 2:
//Input: matrix = [[-19,57],[-40,-5]]
//Output: -59
//Explanation: The falling path with a minimum sum is shown.
//

public class MinimumFallingPathSum {
    public static void main(String[] args) {
        int[][] matrix = {{2,1,3},{6,5,4},{7,8,9}};
        System.out.println(minFallingPathSum(matrix));
        System.out.println(minFallingPathSumTabulation(matrix));
    }

    public static int minFallingPathSum(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int minSum = Integer.MAX_VALUE;
        for(int i=0;i<cols;i++){
            minSum = Math.min(minSum,minFallingPathSumRec(matrix,0,i,rows,cols));
        }
        return minSum;
    }
    private static int minFallingPathSumRec(int[][] matrix,int row,int col,int rows,int cols){
        if(row<0 || row>=rows || col<0 || col>=cols){
            return Integer.MAX_VALUE;
        }
        if(row==rows-1){
            return matrix[row][col];
        }
        int leftDown = minFallingPathSumRec(matrix,row+1,col-1,rows,cols);
        int down = minFallingPathSumRec(matrix,row+1,col,rows,cols);
        int rightDown = minFallingPathSumRec(matrix,row+1,col+1,rows,cols);
        return matrix[row][col] + Math.min(leftDown,Math.min(down,rightDown));
    }

    public static int minFallingPathSumTabulation(int[][] matrix){
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[][] dp = new int[rows][cols];
        for(int col = 0; col <rows; col++){
            dp[0][col] = matrix[0][col];
        }
        for(int row=1;row<rows;row++){
            for(int col=0;col<cols;col++){
                int down = dp[row-1][col];
                int leftDown = (col>0)?dp[row-1][col-1]:Integer.MAX_VALUE;
                int rightDown = (col<cols-1)?dp[row-1][col+1]:Integer.MAX_VALUE;
                dp[row][col] = matrix[row][col] + Math.min(down,Math.min(leftDown,rightDown));
            }
        }
        int minPath = Integer.MAX_VALUE;
        for (int col = 0; col < cols; col++) {
            minPath = Math.min(minPath, dp[rows-1][col]);
        }
        return minPath;
    }
}
