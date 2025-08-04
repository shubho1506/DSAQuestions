package SlidingWindow_TwoPointer;

//Given a binary array nums and an integer goal, return the number of non-empty subarrays with a sum goal.
//A subarray is a contiguous part of the array.

//Example 1:
//Input: nums = [1,0,1,0,1], goal = 2
//Output: 4
//Explanation: The 4 subarrays are bolded and underlined below:
//[1,0,1,0,1]
//[1,0,1,0,1]
//[1,0,1,0,1]
//[1,0,1,0,1]

//Example 2:
//Input: nums = [0,0,0,0,0], goal = 0
//Output: 15

import java.util.HashMap;

public class BinarySubarraysWithSum {
    public static void main(String[] args) {
        int[] nums = {1,0,1,0,1};
        System.out.println(numSubarraysWithSum(nums,2));
    }

    public static int numSubarraysWithSum(int[] nums, int goal) {
        HashMap<Integer,Integer> hmap = new HashMap<>();
        hmap.put(0,1);
        int sum = 0;
        int count = 0;
        for(int i=0;i<nums.length;i++){
            sum += nums[i];
            if(hmap.containsKey(sum-goal)){
                count += hmap.get(sum-goal);
            }
            hmap.put(sum,hmap.getOrDefault(sum,0)+1);
        }
        return count;
    }
}
