package Array.Medium;

//Given an array of integers nums and an integer target,
//return indices of the two numbers such that they add up to target.
//You may assume that each input would have exactly one solution, and you may not use the same element twice.
//You can return the answer in any order.

//Example 1:
//
//Input: nums = [2,7,11,15], target = 9
//Output: [0,1]
//Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
//Example 2:
//
//Input: nums = [3,2,4], target = 6
//Output: [1,2]
//Example 3:
//
//Input: nums = [3,3], target = 6
//Output: [0,1]

import java.util.Arrays;
import java.util.HashMap;

public class TwoSum {
    public static void main(String[] args) {
        int[] nums = {3,2,4};
        System.out.println(Arrays.toString(twoSum(nums,6)));
        int[] nums1 = {3,2,4};
        System.out.println(Arrays.toString(twoSumUnsorted(nums1,6)));
    }


    //for sorted array
    public static int[] twoSum(int[] nums,int target){
        Arrays.sort(nums);
        int si = 0;
        int ei = nums.length-1;
        int[] ans = new int[2];
        while(si<ei){
            if((nums[si]+nums[ei])==target){
                ans[0] = si;
                ans[1] = ei;
                return ans;
            } else if ((nums[si]+nums[ei])>target) {
                ei--;
            }else{
                si++;
            }
        }
        return ans;
    }

    //for unsorted
    public static int[] twoSumUnsorted(int[] nums,int target){
        HashMap<Integer,Integer> hmap = new HashMap<>();
        int[] ans =  new int[2];
        for(int i=0;i< nums.length;i++){
            if(hmap.containsKey(target-nums[i])){
                ans[0] = hmap.get(target-nums[i]);
                ans[1] = i;
                return ans;
            }
            hmap.put(nums[i],i);
        }
        return ans;
    }
}
