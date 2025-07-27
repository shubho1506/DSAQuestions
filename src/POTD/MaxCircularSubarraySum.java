package POTD;

//You are given a circular array arr[] of integers, find the maximum possible sum of a non-empty subarray.
// In a circular array, the subarray can start at the end and wrap around to the beginning.
// Return the maximum non-empty subarray sum, considering both non-wrapping and wrapping cases.

//Examples:
//Input: arr[] = [8, -8, 9, -9, 10, -11, 12]
//Output: 22
//Explanation: Starting from the last element of the array, i.e, 12, and moving in a circular fashion,
// we have max subarray as 12, 8, -8, 9, -9, 10, which gives maximum sum as 22.

//Input: arr[] = [10, -3, -4, 7, 6, 5, -4, -1]
//Output: 23
//Explanation: Maximum sum of the circular subarray is 23. The subarray is [7, 6, 5, -4, -1, 10].
//Input: arr[] = [5, -2, 3, 4]
//Output: 12
//Explanation: The circular subarray [3, 4, 5] gives the maximum sum of 12.

public class MaxCircularSubarraySum {
    public static void main(String[] args) {
        int[] nums = {10, -3, -4, 7, 6, 5, -4, -1};
        System.out.println(maxCircularSum(nums));
    }

    //subtract min subarray sum from total sum
    public static int maxCircularSum(int arr[]) {
        int totalSum = 0;
        int minSubArraySum = Integer.MAX_VALUE;
        int currentMinSum = 0;
        int maxSubArraySum = Integer.MIN_VALUE;
        int currentMaxSum = 0;

        for(int num : arr){
            totalSum += num;
            currentMinSum = Math.min(num,num+currentMinSum);
            if(currentMinSum<minSubArraySum){
                minSubArraySum = currentMinSum;
            }
            currentMaxSum = Math.max(num,num+currentMaxSum);
            if(currentMaxSum>maxSubArraySum){
                maxSubArraySum = currentMaxSum;
            }
        }

        return Math.max(totalSum-minSubArraySum,maxSubArraySum);
    }
}
