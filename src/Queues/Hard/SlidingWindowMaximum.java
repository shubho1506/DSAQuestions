package Queues.Hard;

//You are given an array of integers nums, there is a sliding window of size k which is moving from the very left
// of the array to the very right. You can only see the k numbers in the window.
// Each time the sliding window moves right by one position.
//Return the max sliding window.

//Example 1:
//Input: nums = [1,3,-1,-3,5,3,6,7], k = 3
//Output: [3,3,5,5,6,7]
//Explanation:
//Window position                Max
//---------------               -----
//[1  3  -1] -3  5  3  6  7       3
// 1 [3  -1  -3] 5  3  6  7       3
// 1  3 [-1  -3  5] 3  6  7       5
// 1  3  -1 [-3  5  3] 6  7       5
// 1  3  -1  -3 [5  3  6] 7       6
// 1  3  -1  -3  5 [3  6  7]      7

//Example 2:
//Input: nums = [1], k = 1
//Output: [1]

import java.util.*;

public class SlidingWindowMaximum {
    public static void main(String[] args) {
        int[] nums = {1,3,-1,-3,5,3,6,7};
        System.out.println(Arrays.toString(maxSlidingWindow(nums,3)));
    }

    public static int[] maxSlidingWindow(int[] nums, int k) {
        int[] maxInWindow = new int[nums.length-(k-1)];
        Deque<Integer> queue = new ArrayDeque<>();
        int idx=0;
        for(int i=0;i<nums.length;i++){
            while (!queue.isEmpty() && queue.peekFirst() <= i - k) {
                queue.pollFirst();
            }
            while (!queue.isEmpty() && nums[queue.peekLast()] < nums[i]) {
                queue.pollLast();
            }
            queue.offerLast(i);
            if (i >= k - 1) {
                maxInWindow[idx++] = nums[queue.peekFirst()];
            }
        }

        return maxInWindow;
    }
}
