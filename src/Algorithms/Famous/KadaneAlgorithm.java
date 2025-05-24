package Algorithms.Famous;
//Given an integer array arr[]. You need to find the maximum sum of a subarray.
//
//Examples:
//
//Input: arr[] = [2, 3, -8, 7, -1, 2, 3]
//Output: 11
//Explanation: The subarray {7, -1, 2, 3} has the largest sum 11.
//Input: arr[] = [-2, -4]
//Output: -2
//Explanation: The subarray {-2} has the largest sum -2.
//Input: arr[] = [5, 4, 1, 7, 8]
//Output: 25
//Explanation: The subarray {5, 4, 1, 7, 8} has the largest sum 25.

public class KadaneAlgorithm {
    public static void main(String[] args) {
        int[] arr = {5, 4, 1, 7, 8};
        System.out.println(maxSubarraySum(arr, arr.length));
    }

    public static long maxSubarraySum(int arr[], int n){
        long sum  = Integer.MIN_VALUE;
        long max = 0;
        if(n==0){
            return 0;
        }else{
            for(int i=0;i<n;i++){
                max = Math.max(arr[i],max + arr[i]);
                if(max>sum){
                    sum = max;
                }
            }
        }
        return sum;
    }
}
