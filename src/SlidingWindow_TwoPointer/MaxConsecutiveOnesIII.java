package SlidingWindow_TwoPointer;

//Given a binary array nums and an integer k, return the maximum number of consecutive 1's in the array
// if you can flip at most k 0's.

//Example 1:
//Input: nums = [1,1,1,0,0,0,1,1,1,1,0], k = 2
//Output: 6
//Explanation: [1,1,1,0,0,1,1,1,1,1,1]
//Bolded numbers were flipped from 0 to 1. The longest subarray is underlined.

//Example 2:
//Input: nums = [0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1], k = 3
//Output: 10
//Explanation: [0,0,1,1,1,1,1,1,1,1,1,1,0,0,0,1,1,1,1]
//Bolded numbers were flipped from 0 to 1. The longest subarray is underlined.

public class MaxConsecutiveOnesIII {
    public static void main(String[] args) {
        int[] nums = {0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1};
        System.out.println(longestOnes(nums,3));
    }

    public static int longestOnes(int[] nums, int k) {
        int maxLength = 0;
        int left = 0;
        int right = 0;
        int count = 0;
        while (right<nums.length){
            if (nums[right] == 0){
                count++;
            }
            while (count > k) {
                if (nums[left] == 0){
                    count--;
                }
                left++;
            }
            maxLength = Math.max(maxLength, right - left + 1);
            right++;
        }
        return maxLength;
    }
}
