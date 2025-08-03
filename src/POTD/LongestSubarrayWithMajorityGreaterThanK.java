package POTD;

//Given an array arr[] and an integer k, the task is to find the length of longest subarray in which the count of
// elements greater than k is more than the count of elements less than or equal to k.
//Examples:

//Input: arr[] = [1, 2, 3, 4, 1], k = 2
//Output: 3
//Explanation: The subarray [2, 3, 4] or [3, 4, 1] satisfy the given condition, and there is no subarray of
//length 4 or 5 which will hold the given condition, so the answer is 3.

//Input: arr[] = [6, 5, 3, 4], k = 2
//Output: 4
//Explanation: In the subarray [6, 5, 3, 4], there are 4 elements > 2 and 0 elements <= 2,
// so it is the longest subarray.

import java.util.Arrays;
import java.util.HashMap;

public class LongestSubarrayWithMajorityGreaterThanK {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 1};
        System.out.println(longestSubarray(arr,2));
    }

    public static int longestSubarray(int[] arr, int k) {
        HashMap<Integer,Integer> hmap = new HashMap<>();
        hmap.put(0,-1);
        int sum = 0;
        int maxLength = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > k) {
                sum++;
            } else {
                sum--;
            }
            if (sum > 0) {
                maxLength = i + 1;
            } else if (hmap.containsKey(sum - 1)) {
                maxLength = Math.max(maxLength, i - hmap.get(sum - 1));
            }
            hmap.putIfAbsent(sum, i);
        }
        return maxLength;
    }


}
