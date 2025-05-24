package Array.Matrix;

import java.util.Arrays;

public class RotateArrayBy90Clockwise {
    public static void main(String[] args) {
        int[][] nums = {{1,2,3},
                        {4,5,6},
                         {7,8,9}};
        rotate(nums);
        for(int i=0;i< nums.length;i++){
            System.out.println(Arrays.toString(nums[i]));
        }
    }


    //first transpose and then swap the colums
    public static int[][] rotate(int[][] matrix) {
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<=i;j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        for (int i = 0; i < matrix.length; i++) {
            int left = 0, right = matrix.length - 1;
            while (left < right) {
                int temp = matrix[i][left];
                matrix[i][left] = matrix[i][right];
                matrix[i][right] = temp;
                left++;
                right--;
            }
        }
        return matrix;
    }
}
