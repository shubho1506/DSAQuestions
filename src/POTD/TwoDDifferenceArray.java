package POTD;

import java.util.ArrayList;

//You are given a 2D integer matrix mat[][] of size n × m and a list of q operations opr[][].
// Each operation is represented as an array [v, r1, c1, r2, c2], where:
//v is the value to be added
//(r1, c1) is the top-left cell of a submatrix
//(r2, c2) is the bottom-right cell of the submatrix (inclusive)
//For each of the q operations, add v to every element in the submatrix from (r1, c1) to (r2, c2).
// Return the final matrix after applying all operations.
//Examples:
//Input: mat[][] = [[1, 2, 3],  opr[][] = [[2, 0, 0, 1, 1], [-1, 1, 0, 2, 2]]
//                [1, 1, 0],
//                [4,-2, 2]]
//Output: [[3, 4, 3],
//        [2, 2, -1],
//        [3, -3, 1]]


public class TwoDDifferenceArray {
    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3},{1, 1, 0},{4,-2, 2}};
        int[][] opr = {{2, 0, 0, 1, 1},{-1, 1, 0, 2, 2}};
        System.out.println(applyDiff2D(matrix,opr));
    }

    public static ArrayList<ArrayList<Integer>> applyDiff2D(int[][] mat, int[][] opr) {
        int rows = mat.length;
        int cols = mat[0].length;

        int[][] diff = new int[rows + 1][cols + 1];

        for (int[] operation : opr) {
            int value = operation[0];
            int r1 = operation[1];
            int c1 = operation[2];
            int r2 = operation[3];
            int c2 = operation[4];

            diff[r1][c1] += value;
            if (c2 + 1 < cols){
                diff[r1][c2 + 1] -= value;
            }
            if (r2 + 1 < rows){
                diff[r2 + 1][c1] -= value;
            }
            if (r2 + 1 < rows && c2 + 1 < cols){
                diff[r2 + 1][c2 + 1] += value;
            }
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 1; j < cols; j++) {
                diff[i][j] += diff[i][j - 1];
            }
        }

        for (int j = 0; j < cols; j++) {
            for (int i = 1; i < rows; i++) {
                diff[i][j] += diff[i - 1][j];
            }
        }

        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        for (int i = 0; i < rows; i++) {
            ArrayList<Integer> row = new ArrayList<>();
            for (int j = 0; j < cols; j++) {
                row.add(mat[i][j] + diff[i][j]);
            }
            result.add(row);
        }

        return result;
    }
}
