package BinarySearch.TwoDimensionalArrays;

//Given a non-empty grid mat consisting of only 0s and 1s, where all the rows are sorted in ascending order,
// find the index of the row with the maximum number of ones.
//If two rows have the same number of ones, consider the one with a smaller index.
//If no 1 exists in the matrix, return -1.

//Examples:
//Input : mat = [ [1, 1, 1], [0, 0, 1], [0, 0, 0] ]
//Output: 0
//Explanation: The row with the maximum number of ones is 0 (0 - indexed).

//Input: mat = [ [0, 0], [0, 0] ]
//Output: -1
//Explanation: The matrix does not contain any 1. So, -1 is the answer.


public class FindTheRowWithMaxNumberOf1s {
    public static void main(String[] args) {
        int[][] mat = {
                {1, 1, 1},
                {0, 0, 1},
                {0, 0, 0}
        };
        System.out.println(rowWithMax1s(mat));
    }

    public static int rowWithMax1s(int[][] mat) {
        int rowMax = -1;
        int currentMax = -1;
        for(int i=0;i<mat.length;i++){
            int lB = lowerBound(mat[i],1);
            if(lB!=-1){
                int maxOnes = mat[i].length-lB;
                if(maxOnes>currentMax){
                    currentMax=maxOnes;
                    rowMax=i;
                }
            }
        }
        return rowMax;
    }

    public static int lowerBound(int[] row,int x){
        int si=0;
        int ei=row.length-1;

        int ans = -1;

        if(row.length==1){
            return row[0];
        }

        while (si<=ei){
            int mid = si+(ei-si)/2;

            if(row[mid]>=x){
                if(row[mid]==x){
                    ans = mid;
                }
                ei = mid-1;
            } else if (row[mid]<x) {
                si=mid+1;
            }
        }
        return ans;
    }

}
