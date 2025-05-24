package Array.Matrix;

import java.util.Arrays;

public class SetMatrixZero {
    public static void main(String[] args) {
        int[][] matrix = {{0,1,2,0},
                {3,4,5,2},
                {1,3,1,5}};

        setMatrixZero(matrix);

        for(int[] rows : matrix){
            System.out.println(Arrays.toString(rows));
        }
    }

    public static void setMatrixZero(int [][] matrix){
        int n = matrix.length;
        int m = matrix[0].length;
        boolean[] row = new boolean[n];
        boolean[] col = new boolean[m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == 0) {
                    row[i] = true;
                    col[j] = true;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (row[i] || col[j]) {
                    matrix[i][j] = 0;
                }
            }
        }
        
    }
}
