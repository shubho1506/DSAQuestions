package POTD;

//You are given a 2D matrix mat[][] of size n x m that was initially filled in the following manner:
//Each row is sorted in increasing order from left to right.
//The first element of every row is greater than the last element of the previous row.
//This implies that if the matrix is flattened row-wise, it forms a strictly sorted 1D array.
//Later, this sorted 1D array was rotated at some unknown pivot. The rotated array was then written back into the matrix
// row-wise to form the current matrix.
//Given such a matrix mat[][] and an integer x, determine whether x exists in the matrix.
//Examples:
//Input: x = 3,
//mat[][] = [[7, 8, 9, 10],
//          [11, 12, 13, 1],
//          [2, 3, 4, 5]]
//Output: true
//Explanation: 3 is located at the 3rd row and 2nd column.
//Input: x = 10,
//mat[][] = [[6, 7, 8],
//          [9, 1, 2],
//          [3, 4, 5]]
//Output: false
//Explanation: The value 10 does not exist in the matrix.

public class SearchInAFullyRotatedMatrix {
    public static void main(String[] args) {
        int[][] matrix = {{7,8,9,10},{11,12,13,1},{2,3,4,5}};
        System.out.println(searchMatrix(matrix,11));
    }

    public static boolean searchMatrix(int[][] mat, int x) {
        int rows = mat.length;
        int cols = mat[0].length;
        int si = 0;
        int ei =  rows*cols - 1;
        while (si<=ei){
            int mid = si + (ei-si)/2;
            int row = mid/cols;
            int col = mid%cols;
            int midValue = mat[row][col];
            if(midValue==x){
                return true;
            }
            int siValue = mat[si/cols][si%cols];
            if(siValue <=midValue){
                if(siValue <=x && x<midValue){
                    ei = mid-1;
                }else {
                    si = mid+1;
                }
            }else {
                int eiValue = mat[ei/cols][ei%cols];
                if(midValue<x && x<=eiValue){
                    si = mid+1;
                }else {
                    ei = mid-1;
                }
            }
        }
        return false;
    }
}
