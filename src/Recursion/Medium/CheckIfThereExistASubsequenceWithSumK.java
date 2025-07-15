package Recursion.Medium;

//Given an array arr and target sum k, check whether there exists a subsequence such that the sum of all
// elements in the subsequence equals the given target sum(k).
//Example:
//Input:  arr = [10,1,2,7,6,1,5], k = 8.
//Output:  Yes
//Explanation:  Subsequences like [2, 6], [1, 7] sum upto 8

//Input:  arr = [2,3,5,7,9], k = 100.
//Output:  No
//Explanation:  No subsequence can sum upto 100

import java.util.Arrays;

public class CheckIfThereExistASubsequenceWithSumK {
    public static void main(String[] args) {
        int[] arr = {10,1,2,7,6,1,5};
        System.out.println(checkSubsequenceSum(arr.length, arr,8));
    }

    public static boolean checkSubsequenceSum(int N, int[] arr, int K) {
        return checkSubsequenceSumHelper(arr,K,0,0);
    }

    private static boolean checkSubsequenceSumHelper(int[]arr ,int k, int i, int sum){
        if(sum>k){
            return false;
        }
        if(i==arr.length){
            return sum == k;
        }
        if (checkSubsequenceSumHelper(arr, k, i + 1, sum + arr[i])) {
            return true;
        }
        if (checkSubsequenceSumHelper(arr, k, i + 1, sum)) {
            return true;
        }
        return false;
    }
}
