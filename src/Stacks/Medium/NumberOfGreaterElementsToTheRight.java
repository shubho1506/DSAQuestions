package Stacks.Medium;

//Given an array of N integers and Q queries of indices. For each query indices[i],
//determine the count of elements in arr that are strictly greater than arr[indices[i]] to its right
// (after the position indices[i]).

//Examples :
//Input: arr[] = [3, 4, 2, 7, 5, 8, 10, 6], queries = 2, indices[] = [0, 5]
//Output:  [6, 1]
//Explanation: The next greater elements to the right of 3(index 0) are 4,7,5,8,10,6.
// The next greater elements to the right of 8(index 5) is only 10.

//Input: arr[] = [1, 2, 3, 4, 1], queries = 2, indices[] = [0, 3]
//Output:  [3, 0]
//Explanation: The count of numbers to the right of index 0 which are greater than arr[0] is 3 i.e. (2, 3, 4).
//Similarly, the count of numbers to the right of index 3 which are greater than arr[3] is 0,
//since there are no greater elements than 4 to the right of the array.

import java.util.Arrays;
import java.util.HashMap;
import java.util.Stack;

public class NumberOfGreaterElementsToTheRight {
    public static void main(String[] args) {
        int[] arr = {3, 4, 2, 7, 5, 8, 10, 6};
        int[] indices = {0, 5};
        System.out.println(Arrays.toString(count_NGEs(arr.length, arr, 2, indices)));
    }

    public static int[] count_NGEs(int N, int arr[], int queries, int indices[]) {
        int[] countRight = new int[N];   // store counts for every index
        Stack<Integer> stack = new Stack<>();

        // Traverse from right to left
        for (int i = N - 1; i >= 0; i--) {
            int count = 0;

            // count all elements in stack that are greater
            for (int num : stack) {
                if (num > arr[i]) count++;
            }

            countRight[i] = count;
            stack.push(arr[i]); // push current number to stack
        }

        // now fill answers for queries
        int[] ans = new int[queries];
        for (int q = 0; q < queries; q++) {
            ans[q] = countRight[indices[q]];
        }
        return ans;
    }
}
