package Strings.Easy;

//Given a valid parentheses string s, return the nesting depth of s. The nesting depth is the maximum
//number of nested parentheses.
//Example 1:
//Input: s = "(1+(2*3)+((8)/4))+1"
//Output: 3
//Explanation:
//Digit 8 is inside of 3 nested parentheses in the string.

//Example 2:
//Input: s = "(1)+((2))+(((3)))"
//Output: 3
//Explanation:
//Digit 3 is inside of 3 nested parentheses in the string.

//Example 3:
//Input: s = "()(())((()()))"
//Output: 3

public class MaximumNestingDepthOfTheParenthesis {
    public static void main(String[] args) {
        String s = "()(())((()()))";
        System.out.println(maxDepth(s));
    }

    public static int maxDepth(String s) {
        int currCount = 0;
        int maxCount = Integer.MIN_VALUE;

        for(char c : s.toCharArray()){
            if(currCount>maxCount){
                maxCount=currCount;
            }
            if(c == '('){
                currCount++;
            }
            if(c == ')'){
                currCount--;
            }
        }

        return maxCount;
    }
}
