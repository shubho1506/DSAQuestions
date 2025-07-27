package Stacks.Easy;

import java.util.Arrays;
import java.util.Stack;

public class NextSmallestElement {
    public static void main(String[] args) {
        int[] nums = {1,3,4,2};
        System.out.println(Arrays.toString(nextSmallerElement(nums)));
    }

    public static int[] nextSmallerElement(int[] nums){
        Stack<Integer> stack = new Stack<>();
        int[] ans = new int[nums.length];
        for(int i=0;i<nums.length;i++){
            while(!stack.isEmpty() && stack.peek()>=nums[i]){
                stack.pop();
            }
            if(stack.isEmpty()){
                ans[i] = -1;
            }else {
                ans[i] = stack.peek();
            }
            stack.push(nums[i]);
        }
        return ans;
    }
}
