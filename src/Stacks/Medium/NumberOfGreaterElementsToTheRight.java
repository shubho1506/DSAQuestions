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
        int[] nums = {3, 4, 2, 7, 5, 8, 10, 6};
        int[] indices = {0,5};
        System.out.println(Arrays.toString(count_NGEs(nums.length,nums,2,indices)));
    }

    public static int[] count_NGEs(int N, int arr[], int queries, int indices[]) {
        Stack<Integer> stack = new Stack<>();
        int[] greaterCount = new int[N];

        for(int i=arr.length-1;i>=0;i++){
            while(!stack.isEmpty() && stack.peek()<=arr[i]){
                stack.pop();
            }
            greaterCount[i] = stack.size();
            stack.push(arr[i]);
        }

        int[] ans = new int[indices.length];
        for (int i = 0; i < indices.length; i++) {
            ans[i] = greaterCount[indices[i]];
        }
        return ans;
    }
}
