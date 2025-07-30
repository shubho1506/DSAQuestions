package ImportantQuestions;

//Given an array of integers arr, find the sum of min(b), where b ranges over every (contiguous) subarray of arr.
// Since the answer may be large, return the answer modulo 109 + 7.

//Example 1:
//Input: arr = [3,1,2,4]
//Output: 17
//Explanation:
//Subarrays are [3], [1], [2], [4], [3,1], [1,2], [2,4], [3,1,2], [1,2,4], [3,1,2,4].
//Minimums are 3, 1, 2, 4, 1, 1, 2, 1, 1, 1.
//Sum is 17.

//Example 2:
//Input: arr = [11,81,94,43,3]
//Output: 444

import java.util.Stack;

public class SumOfSubarrayMinimums {
    public static void main(String[] args) {
        int[] arr = {11,81,94,43,3};
        System.out.println(sumSubarrayMins(arr));
    }

    public static int sumSubarrayMins(int[] arr) {
        int[] prevLess = new int[arr.length];
        int[] nextLess = new int[arr.length];
        Stack<Integer> stack = new Stack<>();
        int totalSum = 0;

        for(int i=0;i<arr.length;i++){
            while(!stack.isEmpty() && arr[stack.peek()]>arr[i]){
                stack.pop();
            }
            if(stack.isEmpty()){
                prevLess[i] = -1;
            }else{
                prevLess[i] = stack.peek();
            }
            stack.push(i);
        }

        stack.clear();

        for(int i=arr.length-1;i>=0;i--){
            while(!stack.isEmpty() && arr[stack.peek()]>=arr[i]){
                stack.pop();
            }
            if(stack.isEmpty()){
                nextLess[i] = arr.length;
            }else {
                nextLess[i] = stack.peek();
            }
            stack.push(i);
        }

        for(int i=0;i<arr.length;i++){
            int left = i-prevLess[i];
            int right = nextLess[i]-i;
            totalSum +=  arr[i]*left*right;
        }

        return totalSum;
    }
}
