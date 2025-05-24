package Algorithms.NotSoFamous;

////Given an array nums with n objects colored red, white, or blue, sort them in-place so that objects of the same color are adjacent, with the colors in the order red, white, and blue.
////
////We will use the integers 0, 1, and 2 to represent the color red, white, and blue, respectively.
////
////You must solve this problem without using the library's sort function.
////
////
////
////Example 1:
////
////Input: nums = [2,0,2,1,1,0]
////Output: [0,0,1,1,2,2]
////Example 2:
////
////Input: nums = [2,0,1]
////Output: [0,1,2]

import java.util.Arrays;

public class DutchNationalFlagAlgorithm {
    public static void main(String[] args) {
        int[] nums = {2,0,1};
        System.out.println(Arrays.toString(dutchNationalFlagAlgo(nums)));
    }

    //Three pointers low , mid and high
    //0 -> low-1 => 0
    //low -> mid-1 => 1
    //mid -> high-1 => unsorted array which will kept decreasing as other sides getting sorted
    //high -> n-1 => 2

    public static int[] dutchNationalFlagAlgo(int[] nums){
        int low = 0;
        int mid  = 0;
        int high = nums.length-1;
        while(mid <= high){
            if(nums[mid]==0){
                swap(nums,mid,low);
                low++;
                mid++;
            } else if (nums[mid]==2) {
                swap(nums,mid,high);
                high--;
            }else {
                mid++;
            }
        }
        return nums;
    }

    public static void swap(int[] nums,int id1,int id2){
        int temp = nums[id1];
        nums[id1] = nums[id2];
        nums[id2] = temp;
    }
}
