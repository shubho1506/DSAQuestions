package POTD;

//Given a 2D matrix mat[][] with dimensions n×m. Find the maximum possible sum of any submatrix within the given matrix.
//Examples:
//Input: mat[][] = [[1, 2, -1, -4, -20], [-8, -3, 4, 2, 1], [3, 8, 10, 1, 3], [-4, -1, 1, 7, -6]]
//Output: 29
//Explanation: The matrix is as follows and the green rectangle denotes the maximum sum rectangle which is equal to 29.

//Input: mat[][] = [[-1, -2], [-3, -4]]
//Output: -1
//Explanation: Taking only the first cell is the optimal choice.

public class MaximumSumRectangle {
    public static void main(String[] args) {
        int[][] matrix = {{1, 2, -1, -4, -20},
                {-8, -3, 4, 2, 1},
                {3, 8, 10, 1, 3},
                {-4, -1, 1, 7, -6}};

        System.out.println(maxRectSum(matrix));
    }

    public static int maxRectSum(int mat[][]) {
        int maxSum = Integer.MIN_VALUE;
        for (int i = 0; i < mat.length; i++) {
            int[] temp = new int[mat[0].length];
            for (int j = i; j < mat.length; j++) {
                for (int col = 0; col < mat[0].length; col++) {
                    temp[col] += mat[j][col];
                }
                int currMax = kadane(temp);
                maxSum = Math.max(maxSum, currMax);
            }
        }
        return maxSum;
    }

    private static int kadane(int[] arr){
        int maxSoFar = arr[0];
        int currMax = arr[0];
        for (int i = 1; i < arr.length; i++) {
            currMax = Math.max(arr[i], currMax + arr[i]);
            maxSoFar = Math.max(maxSoFar, currMax);
        }
        return maxSoFar;
    }
}
