package SlidingWindow_TwoPointer.Medium;

//Given an array of integers nums and an integer k. A continuous subarray is called nice if there are k odd numbers on it.
//Return the number of nice sub-arrays.

//Example 1:
//Input: nums = [1,1,2,1,1], k = 3
//Output: 2
//Explanation: The only sub-arrays with 3 odd numbers are [1,1,2,1] and [1,2,1,1].

//Example 2:
//Input: nums = [2,4,6], k = 1
//Output: 0
//Explanation: There are no odd numbers in the array.

//Example 3:
//Input: nums = [2,2,2,1,2,2,1,2,2,2], k = 2
//Output: 16

import java.util.HashMap;

public class CountNumberOfNiceSubarrays {
    public static void main(String[] args) {
        int[] nums = {2,2,2,1,2,2,1,2,2,2};
        System.out.println(numberOfSubarrays(nums,2));
    }

    public static int numberOfSubarrays(int[] nums, int k) {
        int count = 0;
        int countOdd = 0;
        HashMap<Integer,Integer> prefixCount = new HashMap<>();
        prefixCount.put(0,1);

        for (int num : nums){
            if(num%2==1){
                countOdd++;
            }
            if(prefixCount.containsKey(countOdd-k)){
                count += prefixCount.get(countOdd-k);
            }
            prefixCount.put(countOdd, prefixCount.getOrDefault(countOdd,0)+1);
        }

        return count;
    }
}
