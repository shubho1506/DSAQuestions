package Array.Easy;


//Given an integer array nums, move all 0's to the end of it while maintaining the relative order of the non-zero elements.
//
//Note that you must do this in-place without making a copy of the array.

//Example 1:
//
//Input: nums = [0,1,0,3,12]
//Output: [1,3,12,0,0]
//Example 2:
//
//Input: nums = [0]
//Output: [0]


import java.util.Arrays;

public class MoveZeroes {
    public static void main(String[] args) {
        int[] nums =  {4,5,0,4,6,8,1,0};
        System.out.println(Arrays.toString(moveZeroes(nums)));
    }

    public static int[] moveZeroes(int[] nums) {
        int si = 0;
        for(int ei=0;ei<nums.length;ei++){
            if(nums[ei]!=0){
                int temp = nums[si];
                nums[si] = nums[ei];
                nums[ei] = temp;
                si++;
            }
        }
        return nums;
    }
}
