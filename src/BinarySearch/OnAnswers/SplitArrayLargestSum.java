package BinarySearch.OnAnswers;

//Given an integer array nums and an integer k, split nums into k non-empty
//subarrays such that the largest sum of any subarray is minimized.
//Return the minimized largest sum of the split.
//A subarray is a contiguous part of the array.

//Example 1:
//Input: nums = [7,2,5,10,8], k = 2
//Output: 18
//Explanation: There are four ways to split nums into two subarrays.
//The best way is to split it into [7,2,5] and [10,8], where the largest sum among the two subarrays is only 18.

//Example 2:
//Input: nums = [1,2,3,4,5], k = 2
//Output: 9
//Explanation: There are four ways to split nums into two subarrays.
//The best way is to split it into [1,2,3] and [4,5], where the largest sum among the two subarrays is only 9.

public class SplitArrayLargestSum {
    public static void main(String[] args) {
        int[] nums = {7,2,5,10,8};
        System.out.println(splitArray(nums,2));
    }

    public static int splitArray(int[] arr, int k) {
        int n = arr.length;

        if (k > n) return -1;

        int low = 0, high = 0;
        for (int pages : arr) {
            low = Math.max(low, pages);
            high += pages;
        }

        int result = -1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (isPossible(arr, k, mid)) {
                result = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return result;
    }

    private static boolean isPossible(int[] arr, int k, int maxPagesAllowed) {
        int studentCount = 1;
        int pagesSum = 0;

        for (int pages : arr) {
            if (pagesSum + pages > maxPagesAllowed) {
                studentCount++;
                pagesSum = pages;
                if (studentCount > k) return false;
            } else {
                pagesSum += pages;
            }
        }

        return true;
    }
}
