package Array.Medium;

//Given an integer array nums, rotate the array to the right by k steps, where k is non-negative.
//Example 1:
//
//Input: nums = [1,2,3,4,5,6,7], k = 3
//Output: [5,6,7,1,2,3,4]
//Explanation:
//rotate 1 steps to the right: [7,1,2,3,4,5,6]
//rotate 2 steps to the right: [6,7,1,2,3,4,5]
//rotate 3 steps to the right: [5,6,7,1,2,3,4]
//Example 2:
//
//Input: nums = [-1,-100,3,99], k = 2
//Output: [3,99,-1,-100]
//Explanation:
//rotate 1 steps to the right: [99,-1,-100,3]
//rotate 2 steps to the right: [3,99,-1,-100]

import java.util.Arrays;

public class LeftRotateArraybyOne {
    public static void main(String[] args) {
        int[] num  =  {1,2,3,4,5,6,7};
        System.out.println(Arrays.toString(rotate(num,3)));;
    }

    public static int[] rotate(int[] nums, int k) {
        k %= nums.length;
        reverse(nums,0, nums.length-1);
        reverse(nums,0,k-1);
        reverse(nums,k, nums.length-1);
        return nums;
    }

    public static void reverse(int[] nums,int si,int ei){
        while(si<ei){
            int temp = nums[si];
            nums[si] = nums[ei];
            nums[ei] = temp;
            si++;
            ei--;
        }
    }

}
