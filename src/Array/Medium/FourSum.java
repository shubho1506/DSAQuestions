package Array.Medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//Given an array nums of n integers, return an array of all the unique quadruplets
//[nums[a], nums[b], nums[c], nums[d]] such that:
//0 <= a, b, c, d < n
//a, b, c, and d are distinct.
//nums[a] + nums[b] + nums[c] + nums[d] == target
//You may return the answer in any order.

//Example 1:
//Input: nums = [1,0,-1,0,-2,2], target = 0
//Output: [[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]

//Example 2:
//Input: nums = [2,2,2,2,2], target = 8
//Output: [[2,2,2,2]]

public class FourSum {
    public static void main(String[] args) {
        int[] nums = {1,0,-1,0,-2,2};
        int target = 0;
        System.out.println(fourSum(nums,target));
    }

    public static List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);

        List<List<Integer>> arrl = new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            if(i>0 && nums[i]==nums[i-1]){
                continue;
            }
            for(int j=i+1;j< nums.length;j++){
                if(j>i+1 && nums[j]==nums[j-1]){
                    continue;
                }

                int p=j+1;
                int q=nums.length-1;

                while(p<q){
                    if((nums[i]+nums[j]+nums[p]+nums[q])>target){
                        q--;
                    } else if ((nums[i]+nums[j]+nums[p]+nums[q])<target) {
                        p++;
                    }else{
                        arrl.add(Arrays.asList(nums[i],nums[j],nums[p],nums[q]));
                        p++;
                        q--;
                        while(p<q && nums[p]==nums[p-1]){
                            p++;
                        }
                        while(p<q && nums[q]==nums[q+1]){
                            q--;
                        }
                    }
                }
            }
        }
        return arrl;
    }
}
