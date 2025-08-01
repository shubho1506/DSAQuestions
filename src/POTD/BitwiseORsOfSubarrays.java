package POTD;

//Given an integer array arr, return the number of distinct bitwise ORs of all the non-empty subarrays of arr.
//The bitwise OR of a subarray is the bitwise OR of each integer in the subarray. The bitwise OR of a subarray
// of one integer is that integer.
//A subarray is a contiguous non-empty sequence of elements within an array.

//Example 1:
//Input: arr = [0]
//Output: 1
//Explanation: There is only one possible result: 0.

//Example 2:
//Input: arr = [1,1,2]
//Output: 3
//Explanation: The possible subarrays are [1], [1], [2], [1, 1], [1, 2], [1, 1, 2].
//These yield the results 1, 1, 2, 1, 3, 3.
//There are 3 unique values, so the answer is 3.

//Example 3:
//Input: arr = [1,2,4]
//Output: 6
//Explanation: The possible results are 1, 2, 3, 4, 6, and 7.

import java.util.HashSet;
import java.util.Set;

public class BitwiseORsOfSubarrays {
    public static void main(String[] args) {
        int[] arr = {1,1,2};
        System.out.println(subarrayBitwiseORs(arr));
    }

    public static int subarrayBitwiseORs(int[] arr) {
        // This set will store all unique OR values found across all subarrays.
        Set<Integer> resultOrs = new HashSet<>();

        // This set stores the distinct ORs of all subarrays ending at the previous position.
        Set<Integer> currentOrs = new HashSet<>();

        for (int x : arr) {
            // `nextOrs` will store the ORs of subarrays ending at the current element `x`.
            Set<Integer> nextOrs = new HashSet<>();

            // The subarray of just the element x gives an OR of x.
            nextOrs.add(x);

            // Compute new ORs by extending previous subarrays with the current element x.
            for (int y : currentOrs) {
                nextOrs.add(x | y);
            }

            // Add all newly found ORs to the main result set.
            resultOrs.addAll(nextOrs);

            // For the next iteration, the current results become the previous results.
            currentOrs = nextOrs;
        }

        return resultOrs.size();
    }
}
