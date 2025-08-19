package BitManipulation.Medium;

//Given an integer array nums of unique elements, return all possible subsets (the power set).
//The solution set must not contain duplicate subsets. Return the solution in any order.
//Example 1:
//Input: nums = [1,2,3]
//Output: [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
//Example 2:
//Input: nums = [0]
//Output: [[],[0]]

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Subsets {
    public static void main(String[] args) {
        int[] nums = {1,2,3};
        System.out.println(subsets(nums));
    }

    public static ArrayList<ArrayList<Integer>> subsets(int[] nums) {
        ArrayList<ArrayList<Integer>> subsets = new ArrayList<>();
        for(int i=0;i<(1<<nums.length);i++){
            ArrayList<Integer> subset = new ArrayList<>();
            for(int j=0;j< nums.length;j++){
                if(((1<<j)&i)!=0){
                    subset.add(nums[j]);
                }
            }
            subsets.add(subset);
        }
        return subsets;
    }
}
