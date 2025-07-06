package POTD;

//You are given an array arr[] of integers. Your task is to find the maximum sum of the smallest and second smallest
//elements across all subarrays (of size >= 2) of the given array.

//Examples :
//Input: arr[] = [4, 3, 5, 1]
//Output: 8
//Explanation: All subarrays with at least 2 elements and find the two smallest numbers in each:
//[4, 3] → 3 + 4 = 7
//[4, 3, 5] → 3 + 4 = 7
//[4, 3, 5, 1] → 1 + 3 = 4
//[3, 5] → 3 + 5 = 8
//[3, 5, 1] → 1 + 3 = 4
//[5, 1] → 1 + 5 = 6
//Maximum Score is 8.

//Input: arr[] = [1, 2, 3]
//Output: 5
//Explanation: All subarray with at least 2 elements and find the two smallest numbers in each:
//[1, 2] → 1 + 2 = 3
//[1, 2, 3] → 1 + 2 = 3
//[2, 3] → 2 + 3 = 5
//Maximum Score is 5

public class MaxScoreFromSubArrayMins {
    public static void main(String[] args) {
        int[] nums = {4, 3, 5, 1};
        System.out.println(maxSum(nums));
    }

    public static int maxSum(int arr[]) {
        if(arr.length<2){
            return -1;
        }
        int maxSum=0;
        int i=0;
        int j=1;
        while (j<arr.length){
            int sum = arr[i]+arr[j];
            if(sum>maxSum){
                maxSum=sum;
            }
            i++;
            j++;
        }

        return maxSum;
    }
}
