package SlidingWindow_TwoPointer.Medium;

//Given a binary array nums, you should delete one element from it.
//Return the size of the longest non-empty subarray containing only 1's in the resulting array. Return 0 if there is no such subarray.
//Example 1:
//Input: nums = [1,1,0,1]
//Output: 3
//Explanation: After deleting the number in position 2, [1,1,1] contains 3 numbers with value of 1's.

//Example 2:
//Input: nums = [0,1,1,1,0,1,1,0,1]
//Output: 5
//Explanation: After deleting the number in position 4, [0,1,1,1,1,1,0,1] longest subarray with value of 1's is [1,1,1,1,1].

//Example 3:
//Input: nums = [1,1,1]
//Output: 2
//Explanation: You must delete one element.

public class LongestSubarrayOf1AfterDeletingOneElement {
    public static void main(String[] args) {
        int[] nums = {0,1,1,1,0,1,1,0,1};
        System.out.println(longestSubarray(nums));
    }

    public static int longestSubarray(int[] nums) {
        int maxLength = 0;
        int count = 0;
        int left = 0;
        int right = 0;
        while (right<nums.length){
            if(nums[right]==0){
                count++;
            }
            while (count>1){
                if(nums[left]==0){
                    count--;
                }
                left++;
            }
            maxLength = Math.max(maxLength,right-left);
            right++;
        }
        return maxLength;
    }
}
