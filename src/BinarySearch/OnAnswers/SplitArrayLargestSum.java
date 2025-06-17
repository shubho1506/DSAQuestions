package BinarySearch.OnAnswers;

//Given an integer array nums and an integer k, split nums into k non-empty
//subarrays such that the largest sum of any subarray is minimized.
//Return the minimized largest sum of the split.
//A subarray is a contiguous part of the array.

//Example 1:
//Input: nums = [7,2,5,10,8], k = 2
//Output: 18
//Explanation: There are four ways to split nums into two subarrays.
//The best way is to split it into [7,2,5] and [10,8], where the largest sum among the two subarrays is only 18.

//Example 2:
//Input: nums = [1,2,3,4,5], k = 2
//Output: 9
//Explanation: There are four ways to split nums into two subarrays.
//The best way is to split it into [1,2,3] and [4,5], where the largest sum among the two subarrays is only 9.

public class SplitArrayLargestSum {
    public static void main(String[] args) {
        int[] nums = {7,2,5,10,8};
        System.out.println(splitArray(nums,2));
    }

    public static int splitArray(int[] arr, int k) {
        int si=0;
        int ei=0;
        for(int num : arr){
            ei+=num;
        }
        int ans = -1;
        while(si<=ei){
            int mid = si + (ei-si)/2;
            if(isPossible(arr,k,mid)){
                ans = mid;
                ei=mid-1;
            }else {
                si=mid+1;
            }
        }
        return ans;
    }

    private static boolean isPossible(int[] arr, int k, int maxSumPossible) {
        int maxSum=0;
        int current=1;
        for(int num : arr){
            if(maxSum+num>maxSumPossible){
                current++;
                maxSum=num;
                if(current>k){
                    return false;
                }
            }else{
                maxSum+=num;
            }
        }
        return true;
    }
}
