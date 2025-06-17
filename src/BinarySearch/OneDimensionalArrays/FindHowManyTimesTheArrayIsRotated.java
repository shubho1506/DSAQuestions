package BinarySearch.OneDimensionalArrays;

import java.util.ArrayList;

//Given an integer array nums of size n, sorted in ascending order with distinct values.
// The array has been right rotated an unknown number of times, between 0 and n-1 (including).
// Determine the number of rotations performed on the array.

//Examples:
//Input : nums = [4, 5, 6, 7, 0, 1, 2, 3]
//Output: 4
//Explanation: The original array should be [0, 1, 2, 3, 4, 5, 6, 7]. So, we can notice that the array has been rotated 4 times.

//Input: nums = [3, 4, 5, 1, 2]
//Output: 3
//Explanation: The original array should be [1, 2, 3, 4, 5]. So, we can notice that the array has been rotated 3 times.

public class FindHowManyTimesTheArrayIsRotated {
    public static void main(String[] args) {
        ArrayList<Integer> arrl = new ArrayList<>(){{
            add(4);
            add(5);
            add(6);
            add(7);
            add(0);
            add(1);
            add(2);
            add(3);
        }
        };
        System.out.println(findKRotation(arrl));
    }

    public static int findKRotation(ArrayList<Integer> nums) {
        int si=0;
        int ei=nums.size()-1;

        while (si<ei){
            int mid = si+(ei-si)/2;
            if (nums.get(mid) <= nums.get(ei)) {
                ei = mid;
            } else {
                si = mid + 1;
            }
        }

        return si;
    }
}
