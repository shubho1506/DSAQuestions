package Stacks.Medium;

//Given a circular integer array arr[], the task is to determine the next greater element (NGE) for each element in the array.
//The next greater element of an element arr[i] is the first element that is greater than arr[i] when traversing circularly.
// If no such element exists, return -1 for that position.
//Circular Property:
//Since the array is circular, after reaching the last element, the search continues from the beginning until we have looked
//at all elements once.

//Examples:
//Input: arr[] = [1, 3, 2, 4]
//Output: [3, 4, 4, -1]
//Explanation:
//The next greater element for 1 is 3.
//The next greater element for 3 is 4.
//The next greater element for 2 is 4.
//The next greater element for 4 does not exist, so return -1.

//Input: arr[] = [0, 2, 3, 1, 1]
//Output: [2, 3, -1, 2, 2]
//Explanation:
//The next greater element for 0 is 2.
//The next greater element for 2 is 3.
//The next greater element for 3 does not exist, so return -1.
//The next greater element for 1 is 2 (from circular traversal).
//The next greater element for 1 is 2 (from circular traversal).

import java.util.ArrayList;
import java.util.Stack;

public class NextGreaterElementInCircularAArray {
    public static void main(String[] args) {
        int[] arr = {0, 2, 3, 1, 1};
        System.out.println(nextLargerElement(arr));
    }

    public static ArrayList<Integer> nextLargerElement(int[] arr) {
        ArrayList<Integer> nextLargerElements = new ArrayList<>(arr.length);
        for(int i=0;i< arr.length;i++){
            nextLargerElements.add(-1);
        }
        Stack<Integer> stack = new Stack<>();

        for(int i=0;i<2* arr.length;i++){
            int idx = (i% arr.length);

            while (!stack.isEmpty() && arr[idx] > arr[stack.peek()]){
                nextLargerElements.set(stack.pop(),arr[idx]);
            }

            if(i < arr.length){
                stack.push(idx);
            }
        }
        return nextLargerElements;
    }
}
