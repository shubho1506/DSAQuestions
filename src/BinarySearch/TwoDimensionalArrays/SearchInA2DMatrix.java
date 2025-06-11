package BinarySearch.TwoDimensionalArrays;

//You are given an m x n integer matrix matrix with the following two properties:
//Each row is sorted in non-decreasing order.
//The first integer of each row is greater than the last integer of the previous row.
//Given an integer target, return true if target is in matrix or false otherwise.
//
//You must write a solution in O(log(m * n)) time complexity.

//Example 1:
//Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
//Output: true

//Example 2:
//Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 13
//Output: false

public class SearchInA2DMatrix {
    public static void main(String[] args) {
        int[][] matrix = {{1,3,5,7},
                            {10,11,16,20},
                                {23,30,34,60}};
        searchMatrix(matrix,3);
    }

    public static boolean searchMatrix(int[][] matrix, int target) {
        int si = 0;
        int ei = matrix.length - 1;

        while (si <= ei) {
            int mid = (si + ei) / 2;

            if (matrix[mid][0] < target && matrix[mid][matrix[mid].length - 1] > target) {
                break;
            } else if (matrix[mid][0] > target) {
                ei = mid - 1;
            } else {
                si = mid + 1;
            }
        }

        int row = (si + ei) / 2;

        int left = 0;
        int right = matrix[row].length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (matrix[row][mid] == target) {
                return true;
            } else if (matrix[row][mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return false;
    }
}
