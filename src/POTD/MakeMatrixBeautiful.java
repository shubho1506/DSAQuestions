package POTD;

//A beautiful matrix is defined as a square matrix in which the sum of elements in every row and every column is equal.
// Given a square matrix mat[][], your task is to determine the minimum number of operations required to make the matrix
//beautiful.
//In one operation, you are allowed to increment the value of any single cell by 1.

//Examples:
//Input: mat[][] = [[1, 2],
//                [3, 4]]
//Output: 4
//Explanation:
//Increment value of cell(0, 0) by 3,
//Increment value of cell(0, 1) by 1.
//Matrix after the operations: [[4, 3],
//                            [3, 4]]
//Here, sum of each row and column is 7.
//Hence total 4 operation are required.

//Input: mat[][] = [[1, 2, 3],
//                [4, 2, 3],
//                [3, 2, 1]]
//Output: 6
//Explanation:
//Increment value of cell(0, 0) by 1,
//Increment value of cell(0, 1) by 2,
//Increment value of cell(2, 1) by 1,
//Increment value of cell(2, 2) by 2.
//Matrix after the operations: [[2, 4, 3],
//                            [4, 2, 3],
//                            [3, 3, 3]]
//Here, sum of each row and column is 9.
//Hence total 6 operation are required.

import java.util.Arrays;

public class MakeMatrixBeautiful {
    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3},{4, 2, 3},{3, 2, 1}};
        int[][] matrix2 = {{1,2},{3,4}};
        System.out.println(balanceSums(matrix2));
    }

    public static int balanceSums(int[][] mat) {
        int[] rowsAdd = new int[mat.length];
        int[] colAdd = new int[mat[0].length];
        int max = 0;

        for(int i=0;i<mat.length;i++){
            for(int j=0;j<mat[0].length;j++){
                rowsAdd[i] += mat[i][j];
                colAdd[j] += mat[i][j];
                max = Math.max(max,Math.max(rowsAdd[i],colAdd[j]));
            }
        }

        int rowAddOn = 0;
        int colAddOn = 0;

        for(int i=0;i<rowsAdd.length;i++){
            rowsAdd[i] = max-rowsAdd[i];
            rowAddOn += rowsAdd[i];
        }

        for(int j = 0; j <colAdd.length; j++){
            colAdd[j] = max-colAdd[j];
            colAddOn += colAdd[j];
        }

//        System.out.println(Arrays.toString(rowsAdd));
//        System.out.println(Arrays.toString(colAdd));
//        System.out.println(max);

//        int countMoves = 0;

//        for(int i=0;i<mat.length;i++){
//            for(int j=0;j<mat[0].length;j++){
//                rowAddOn += rowsAdd[i];
//                colAddOn += colAdd[j];
//            }
//        }

        return Math.max(rowAddOn,colAddOn);
    }
}
