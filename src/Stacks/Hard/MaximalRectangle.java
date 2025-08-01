package Stacks.Hard;

//Given a rows x cols binary matrix filled with 0's and 1's, find the largest rectangle containing only 1's and
//return its area.

//Example 1:
//Input: matrix = [["1","0","1","0","0"],["1","0","1","1","1"],["1","1","1","1","1"],["1","0","0","1","0"]]
//Output: 6
//Explanation: The maximal rectangle is shown in the above picture.

//Example 2:
//Input: matrix = [["0"]]
//Output: 0

//Example 3:
//Input: matrix = [["1"]]
//Output: 1

import java.util.Arrays;
import java.util.Stack;

public class MaximalRectangle {
    public static void main(String[] args) {
        char[][] matrix = {{'1','0','1','0','0'}
                ,{'1','0','1','1','1'}
                ,{'1','1','1','1','1'}
                ,{'1','0','0','1','0'}};

        System.out.println(maximalRectangle(matrix));
    }

    public static int maximalRectangle(char[][] matrix) {
        int[][] prefixSumMatrix = new int[matrix.length][matrix[0].length];
        for(int i=0;i<matrix[0].length;i++){
            int sum = 0;
            for(int j=0;j<matrix.length;j++){
                sum += (matrix[j][i])-'0';
                if(matrix[j][i]=='0'){
                    sum = 0;
                }
                prefixSumMatrix[j][i] = sum;
            }
        }

        int ans = 0;
        for(int[] arr : prefixSumMatrix){
            ans = Math.max(ans,largestRectangleArea(arr));
        }
        return ans;
    }

    private static int largestRectangleArea(int[] heights) {
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
