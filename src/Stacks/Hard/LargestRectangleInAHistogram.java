package Stacks.Hard;

//Given an array of integers heights representing the histogram's bar height where the width of each bar is 1,
// return the area of the largest rectangle in the histogram.

//Example 1:
//Input: heights = [2,1,5,6,2,3]
//Output: 10
//Explanation: The above is a histogram where width of each bar is 1.
//The largest rectangle is shown in the red area, which has an area = 10 units.

//Example 2:
//Input: heights = [2,4]
//Output: 4

import java.util.Stack;

public class LargestRectangleInAHistogram {
    public static void main(String[] args) {
        int[] heights = {2,3};
        System.out.println(largestRectangleArea(heights));
    }

    public static int largestRectangleArea(int[] heights) {
        int[] leftSmallestRectangle = new int[heights.length];
        int[] rightSmallestRectangle = new int[heights.length];
        int maxArea = 0;
        Stack<Integer> stack = new Stack<>();

        for(int i=0;i<heights.length;i++){
            while (!stack.isEmpty() && heights[stack.peek()]>=heights[i]){
                stack.pop();
            }
            leftSmallestRectangle[i] = stack.isEmpty()?-1:stack.peek();
            stack.push(i);
        }
        stack.clear();
        for(int i=heights.length-1;i>=0;i--){
            while (!stack.isEmpty() && heights[stack.peek()]>heights[i]){
                stack.pop();
            }
            rightSmallestRectangle[i] = stack.isEmpty()?heights.length:stack.peek();
            stack.push(i);
        }

        for(int i=0;i<heights.length;i++){
            maxArea = Math.max(maxArea,heights[i]*(rightSmallestRectangle[i]-leftSmallestRectangle[i]-1));
        }

        return maxArea;
    }
}
