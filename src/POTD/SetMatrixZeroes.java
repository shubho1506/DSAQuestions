package POTD;

//You are given a 2D matrix mat[][] of size n x m. The task is to modify the matrix such that if mat[i][j] is 0,
// all the elements in the i-th row and j-th column are set to 0.

import java.util.Arrays;

public class SetMatrixZeroes {
    public static void main(String[] args) {
        int[][] matrix = {{0,1,2,0},{1,2,6,2},{1,3,1,8}};
        setMatrixZeroes(matrix);
        for(int[] arr : matrix){
            System.out.println(Arrays.toString(arr));
        }
    }

    public static void setMatrixZeroes(int[][] mat) {
        int[] rows = new int[mat.length];
        int[] cols = new int[mat[0].length];

        for(int i=0;i<mat.length;i++){
            for(int j=0;j<mat[0].length;j++){
                if(mat[i][j]==0){
                    rows[i] = 1;
                    cols[j] = 1;
                }
            }
        }

        for(int i=0;i<mat.length;i++){
            for(int j=0;j<mat[0].length;j++){
                if(mat[i][j]==0){
                    continue;
                }
                if(mat[i][j]!=0 && (rows[i]==1||cols[j]==1) ){
                    mat[i][j]=0;
                }
            }
        }

    }
}
