package Algorithms.Famous;

//Given an array of integers nums and an integer k, return the total number of subarrays whose sum equals to k.
//A subarray is a contiguous non-empty sequence of elements within an array.

//Example 1:
//
//Input: nums = [1,1,1], k = 2
//Output: 2
//Example 2:
//
//Input: nums = [1,2,3], k = 3
//Output: 2

import java.util.HashMap;

public class PrefixSumAlgorithm {
    public static void main(String[] args) {
//        int[] nums = {10, 2, -2, -20, 10}; -10
        int[] nums = {1,2,1,2,1};
        int k = 3;
        System.out.println(prefixSumAlgo(nums,k));
    }

    public static int prefixSumAlgo(int[] nums,int k){
        HashMap<Integer,Integer> map=new HashMap<>();
        int sum=0, count=0;
        //map(prefix_sum,frequency)
        map.put(0,1);
        for(int i=0; i<nums.length; i++)
        {
            sum+=nums[i];
            if(map.containsKey(sum-k))
            {
                count+=map.get(sum-k);
            }
            map.put(sum,map.getOrDefault(sum,0)+1);
        }
        System.out.println(map);
        return count;
    }
}
