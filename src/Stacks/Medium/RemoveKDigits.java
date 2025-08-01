package Stacks.Medium;

//Given string num representing a non-negative integer num, and an integer k, return the smallest possible
//integer after removing k digits from num.

//Example 1:
//Input: num = "1432219", k = 3
//Output: "1219"
//Explanation: Remove the three digits 4, 3, and 2 to form the new number 1219 which is the smallest.

//Example 2:
//Input: num = "10200", k = 1
//Output: "200"
//Explanation: Remove the leading 1 and the number is 200. Note that the output must not contain leading zeroes.

//Example 3:
//Input: num = "10", k = 2
//Output: "0"
//Explanation: Remove all the digits from the number and it is left with nothing which is 0.

import java.util.Stack;

public class RemoveKDigits {
    public static void main(String[] args) {
        System.out.println(removeKdigits("10",1));
    }

    public static String removeKdigits(String num, int k) {
        Stack<Character> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();

        if(num.length()==k){
            return "0";
        }

        for(int i=0;i<num.length();i++){
            while(!stack.isEmpty() && k>0 && (stack.peek()-'0')>(num.charAt(i)-'0')){
                stack.pop();
                k--;
            }
            stack.push(num.charAt(i));
        }

        while (k>0){
            stack.pop();
            k--;
        }
        if(stack.isEmpty()){
            return "0";
        }

        while (!stack.isEmpty()){
            sb.append(stack.pop());
        }

        while (sb.length()>1 && sb.charAt(sb.length() - 1) == '0') {
            sb.deleteCharAt(sb.length() - 1);
        }

        return sb.reverse().toString();
    }
}
