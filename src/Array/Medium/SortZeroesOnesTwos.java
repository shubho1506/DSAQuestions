package Array.Medium;

//Given an array nums with n objects colored red, white, or blue, sort them in-place so that objects of the same color are adjacent, with the colors in the order red, white, and blue.
//
//We will use the integers 0, 1, and 2 to represent the color red, white, and blue, respectively.
//
//You must solve this problem without using the library's sort function.
//
//
//
//Example 1:
//
//Input: nums = [2,0,2,1,1,0]
//Output: [0,0,1,1,2,2]
//Example 2:
//
//Input: nums = [2,0,1]
//Output: [0,1,2]

import java.util.Arrays;

public class SortZeroesOnesTwos {
    public static void main(String[] args) {
        int[] nums = {2,0,2,1,1,0};
        System.out.println(Arrays.toString(sortZeroOneTwo(nums)));
    }

    public static int[] sortZeroOneTwo(int[] nums){
        int zeroes = 0;
        int ones = 0;
        int twoes = 0;
        int idx = 0;
        for(int i : nums){
            if(i==0)
                zeroes++;
            else if (i==1) {
                ones++;
            }else {
                twoes++;
            }
        }

        while(zeroes>0){
            nums[idx++] = 0;
            zeroes--;
        }
        while (ones>0){
            nums[idx++] = 1;
            ones--;
        }
        while (twoes>0){
            nums[idx++] = 2;
            twoes--;
        }
        return nums;
    }
}
