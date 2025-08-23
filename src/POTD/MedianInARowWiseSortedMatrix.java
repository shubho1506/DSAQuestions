package POTD;

//Given a row-wise sorted matrix mat[][] of size n*m, where the number of rows and columns is always odd.
// Return the median of the matrix.
//Examples:
//Input: mat[][] = [[1, 3, 5],
//                [2, 6, 9],
//                [3, 6, 9]]
//Output: 5
//Explanation: Sorting matrix elements gives us [1, 2, 3, 3, 5, 6, 6, 9, 9]. Hence, 5 is median.
//Input: mat[][] = [[2, 4, 9],
//                [3, 6, 7],
//                [4, 7, 10]]
//Output: 6
//Explanation: Sorting matrix elements gives us [2, 3, 4, 4, 6, 7, 7, 9, 10]. Hence, 6 is median.
//Input: mat = [[3], [4], [8]]
//Output: 4
//Explanation: Sorting matrix elements gives us [3, 4, 8]. Hence, 4 is median.

public class MedianInARowWiseSortedMatrix {
    public static void main(String[] args) {
        int[][] matrix = {{1, 3, 5},{2, 6, 9},{3, 6, 9}};
        System.out.println(median(matrix));
    }
    public static int median(int[][] mat) {
        int rows = mat.length;
        int cols = mat[0].length;
        int required = (rows*cols)/2;
        int si = Integer.MAX_VALUE;
        int ei = Integer.MIN_VALUE;
        for(int i=0;i<rows;i++){
            si = Math.min(si,mat[i][0]);
            ei = Math.max(ei,mat[i][cols-1]);
        }
        while (si<=ei){
            int mid = si+(ei-si)/2;
            int smallOrEqual = countSE(mat,rows,cols,mid);
            if(smallOrEqual<=required){
                si = mid+1;
            }else {
                ei = mid-1;
            }
        }
        return si;
    }
    private static int countSE(int[][] mat,int rows,int cols,int mid){
        int count = 0;
        for(int i=0;i<rows;i++){
            count += upperBound(mat[i],mid);
        }
        return count;
    }
    private static int upperBound(int[] arr, int target){
        int si=0;
        int ei= arr.length-1;
        int ans = arr.length;
        while (si<=ei){
            int mid = si+(ei-si)/2;
            if(arr[mid]>target){
                ans = mid;
                ei=mid-1;
            }else {
                si=mid+1;
            }
        }
        return ans;
    }

}
