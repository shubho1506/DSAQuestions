package SlidingWindow_TwoPointer.Hard;

//Given an integer array nums and an integer k, return the number of good subarrays of nums.
//A good array is an array where the number of different integers in that array is exactly k.
//For example, [1,2,3,1,2] has 3 different integers: 1, 2, and 3.
//A subarray is a contiguous part of an array.

//Example 1:
//Input: nums = [1,2,1,2,3], k = 2
//Output: 7
//Explanation: Subarrays formed with exactly 2 different integers:
// [1,2], [2,1], [1,2], [2,3], [1,2,1], [2,1,2], [1,2,1,2]

//Example 2:
//Input: nums = [1,2,1,3,4], k = 3
//Output: 3
//Explanation: Subarrays formed with exactly 3 different integers: [1,2,1,3], [2,1,3], [1,3,4].

import java.util.HashMap;

public class SubarraysWithKDifferentIntegers {
    public static void main(String[] args) {
        int[] nums = {1,2,1,3,4};
        int k = 3;
        System.out.println(subarraysWithKDistinct(nums,k));
    }

    public static int subarraysWithKDistinct(int[] nums, int k) {
        return subarraysLessEqualToK(nums,k) - subarraysLessEqualToK(nums,k-1);
    }

    private static int subarraysLessEqualToK(int[] nums,int k){
        HashMap<Integer,Integer> hmap = new HashMap<>();
        int left = 0;
        int right = 0;
        int count = 0;

        while(right<nums.length){
            hmap.put(nums[right],hmap.getOrDefault(nums[right],0)+1);
            while (hmap.size()>k){
                hmap.put(nums[left],hmap.getOrDefault(nums[left],0)-1);
                if(hmap.get(nums[left])==0){
                    hmap.remove(nums[left]);
                }
                left++;
            }
            count += right-left+1;
            right++;
        }
        return count;
    }
}
