package Array.Medium;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

//Given an unsorted array of integers nums, return the length of the longest consecutive elements sequence.
//You must write an algorithm that runs in O(n) time.
//Example 1:
//
//Input: nums = [100,4,200,1,3,2]
//Output: 4
//Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore, its length is 4.
//Example 2:
//
//Input: nums = [0,3,7,2,5,8,4,6,0,1]
//Output: 9
//Example 3:
//
//Input: nums = [1,0,1,2]
//Output: 3
public class LongestConsecutiveSequenceInAnArray {
    public static void main(String[] args) {
        int[] nums = {0,3,7,2,5,8,4,6,0,1};
        int[] nums2 = {100,4,200,1,3,2};
        System.out.println(longestConsecutiveSequenceInAnArray(nums2));
    }

    public static int longestConsecutiveSequenceInAnArray(int[] nums){
        Set<Integer> set = new HashSet<>();
        for (int num : nums)
            set.add(num);
        int longest = 0;
        for (int num : set) {
            if (!set.contains(num - 1)) {
                int currentNum = num;
                int streak = 1;

                while (set.contains(currentNum + 1)) {
                    currentNum++;
                    streak++;
                }

                longest = Math.max(longest, streak);
            }
        }
        return longest;
    }
}
