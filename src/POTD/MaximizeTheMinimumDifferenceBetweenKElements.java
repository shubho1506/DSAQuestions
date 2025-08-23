package POTD;

//Given an array arr[] of integers and an integer k, select k elements from the array such that the minimum absolute
// difference between any two of the selected elements is maximized. Return this maximum possible minimum difference.
//Examples:
//Input: arr[] = [2, 6, 2, 5], k = 3
//Output: 1
//Explanation: 3 elements out of 4 elements are to be selected with a minimum difference as large as possible.
//Selecting 2, 2, 5 will result in minimum difference as 0. Selecting 2, 5, 6 will result in minimum difference as 6 - 5 = 1.
//Input: arr[] = [1, 4, 9, 0, 2, 13, 3], k = 4
//Output: 4
//Explanation: Selecting 0, 4, 9, 13 will result in minimum difference of 4, which is the largest minimum difference possible.

import java.util.Arrays;

public class MaximizeTheMinimumDifferenceBetweenKElements {
    public static void main(String[] args) {
        int[] arr = {1, 4, 9, 0, 2, 13, 3};
        System.out.println(maxMinDiff(arr,4));
    }

    public static int maxMinDiff(int[] arr, int k) {
        Arrays.sort(arr);
        int si = 0;
        int ei = arr[arr.length-1]-arr[0];
        int ans = 0;
        while (si<=ei){
            int mid = si+(ei-si)/2;
            if(isPossible(arr,mid,k)){
                ans = mid;
                si = mid+1;
            }else {
                ei = mid-1;
            }
        }
        return ans;
    }

    private static boolean isPossible(int[] arr,int mid,int k){
        int count = 1;
        int prev = arr[0];
        for(int i=0;i<arr.length;i++){
            if(arr[i]-prev>=mid){
                count++;
                prev = arr[i];
            }
            if(count>=k){
                return true;
            }
        }
        return false;
    }
}
