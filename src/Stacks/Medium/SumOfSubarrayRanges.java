package Stacks.Medium;

//You are given an integer array nums. The range of a subarray of nums is the difference between the largest
// and smallest element in the subarray.
//Return the sum of all subarray ranges of nums.
//A subarray is a contiguous non-empty sequence of elements within an array.

//Example 1:
//Input: nums = [1,2,3]
//Output: 4
//Explanation: The 6 subarrays of nums are the following:
//[1], range = largest - smallest = 1 - 1 = 0
//[2], range = 2 - 2 = 0
//[3], range = 3 - 3 = 0
//[1,2], range = 2 - 1 = 1
//[2,3], range = 3 - 2 = 1
//[1,2,3], range = 3 - 1 = 2
//So the sum of all ranges is 0 + 0 + 0 + 1 + 1 + 2 = 4.

//Example 2:
//Input: nums = [1,3,3]
//Output: 4
//Explanation: The 6 subarrays of nums are the following:
//[1], range = largest - smallest = 1 - 1 = 0
//[3], range = 3 - 3 = 0
//[3], range = 3 - 3 = 0
//[1,3], range = 3 - 1 = 2
//[3,3], range = 3 - 3 = 0
//[1,3,3], range = 3 - 1 = 2
//So the sum of all ranges is 0 + 0 + 0 + 2 + 0 + 2 = 4.

//Example 3:
//
//Input: nums = [4,-2,-3,4,1]
//Output: 59
//Explanation: The sum of all subarray ranges of nums is 59.

import java.util.Arrays;
import java.util.Stack;

public class SumOfSubarrayRanges {
    public static void main(String[] args) {
        int[] nums = {4,-2,-3,4,1};
        System.out.println(subArrayRanges(nums));
    }

    public static long subArrayRanges(int[] nums) {
        long minContribution = 0;
        long maxContribution = 0;

        int[] minLeft = new int[nums.length];
        int[] minRight = new int[nums.length];
        int[] maxLeft = new int[nums.length];
        int[] maxRight = new int[nums.length];
        Stack<Integer> stack = new Stack<>();

        for(int i=0;i<nums.length;i++){
            while(!stack.isEmpty() && nums[stack.peek()]>nums[i]){
                stack.pop();
            }
            minLeft[i] = stack.isEmpty()?-1:stack.peek();
            stack.push(i);
        }
        stack.clear();
        for(int i= nums.length-1;i>=0;i--){
            while (!stack.isEmpty() && nums[stack.peek()]>=nums[i]){
                stack.pop();
            }
            minRight[i] = stack.isEmpty()?nums.length:stack.peek();
            stack.push(i);
        }
        stack.clear();
        for(int i=0;i<nums.length;i++){
            while (!stack.isEmpty() && nums[stack.peek()]<nums[i]){
                stack.pop();
            }
            maxLeft[i] = stack.isEmpty()?-1:stack.peek();
            stack.push(i);
        }
        stack.clear();
        for(int i= nums.length-1;i>=0;i--){
            while (!stack.isEmpty() && nums[stack.peek()]<=nums[i]){
                stack.pop();
            }
            maxRight[i] = stack.isEmpty()?nums.length:stack.peek();
            stack.push(i);
        }

        for(int i=0;i<nums.length;i++){
            int left = i-minLeft[i];
            int right = minRight[i]-i;
            minContribution +=  (long) nums[i]*left*right;
        }

        for(int i=0;i<nums.length;i++){
            int left = i-maxLeft[i];
            int right = maxRight[i]-i;
            maxContribution +=  (long) nums[i]*left*right;
        }

        System.out.println(Arrays.toString(minLeft));
        System.out.println(Arrays.toString(minRight));
        System.out.println(Arrays.toString(maxLeft));
        System.out.println(Arrays.toString(maxRight));
        return maxContribution-minContribution;
    }
}
