package Array.Matrix;

import java.util.Arrays;
import java.util.List;

public class TraverseMatrixInSpiral {
    public static void main(String[] args) {
        int[][] matrix = {{0,1,2,0},
                {3,4,5,2},
                {1,3,1,5}};

        traverseMatrixInSpiral(matrix);
    }

    public static void traverseMatrixInSpiral(int[][] matrix){
        int rows = matrix.length;
        int cols = matrix[0].length;

        int top = 0;
        int right = cols-1;
        int bottom = rows-1;
        int left = 0;

        while(top<=bottom && left<=right){
            for(int i=left;i<=right;i++)
                System.out.print(matrix[top][i]);
            top++;

            for (int i=top;i<=bottom;i++)
                System.out.print(matrix[i][right]);
            right--;

            if(bottom>=top){
                for (int i=right;i>=left;i--)
                    System.out.print(matrix[bottom][i]);
                bottom--;
            }

            if(right>=left){
                for (int i=bottom;i>=top;i--)
                    System.out.print(matrix[i][left]);
                left++;
            }
        }
    }
}
