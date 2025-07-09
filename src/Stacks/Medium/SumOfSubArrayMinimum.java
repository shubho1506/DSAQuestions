package Stacks.Medium;

//Given an array arr[] of positive integers, find the total sum of the minimum elements of every possible subarrays.
//Note: It is guaranteed that the total sum will fit within a 32-bit unsigned integer.
//Examples:
//Input: arr[] = [3, 1, 2, 4]
//Output: 17
//Explanation: Subarrays are [3], [1], [2], [4], [3, 1], [1, 2], [2, 4], [3, 1, 2], [1, 2, 4], [3, 1, 2, 4].
// Minimums are 3, 1, 2, 4, 1, 1, 2, 1, 1, 1. Sum of all these is 17.

//Input: arr[] = [71, 55, 82, 55]
//Output: 593
//Explanation: The sum of the minimum of all the subarrays is 593.

import java.util.Stack;

public class SumOfSubArrayMinimum {
    public static void main(String[] args) {
        int[] nums = {71, 55, 82, 55};
        System.out.println(sumSubMins(nums));
    }

    public static int sumSubMins(int[] arr) {
        int totalSum = 0;

        Stack<Integer> stack = new Stack<>();
        int[] prevLess = new int[arr.length];
        int[] nextLess = new int[arr.length];

        for(int i=0;i<arr.length;i++){
            while(!stack.isEmpty() && arr[stack.peek()]>arr[i]){
                stack.pop();
            }
            prevLess[i] = stack.isEmpty()?-1:stack.peek();
            stack.push(i);
        }

        stack.clear();

        for (int i = arr.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && arr[stack.peek()] >= arr[i]) {
                stack.pop();
            }
            nextLess[i] = stack.isEmpty() ? arr.length : stack.peek();
            stack.push(i);
        }

        for (int i = 0; i < arr.length; i++) {
            int left = i - prevLess[i];
            int right = nextLess[i] - i;
            totalSum += arr[i] * left * right;
        }

        return totalSum;
    }
}
