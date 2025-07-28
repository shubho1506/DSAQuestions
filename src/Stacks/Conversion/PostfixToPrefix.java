package Stacks.Conversion;

//You are given a string that represents the postfix form of a valid mathematical expression.
// Convert it to its prefix form.
//
//Example 1:
//
//Input:
//ABC/-AK/L-*
//Output:
//*-A/BC-/AKL
//Explanation:
//The above output is its valid prefix form.
//
//Example 2:
//
//Input:
//ab+
//Output:
//+ab
//Explanation:
//The above output is its valid prefix form.

import java.util.Stack;

public class PostfixToPrefix {
    public static void main(String[] args) {
        System.out.println(postToPre("ABC/-AK/L-*"));
    }

    static String postToPre(String post_exp) {
        Stack<String> stack = new Stack<>();
        int i=0;

        while(i<post_exp.length()){

            if(Character.isLetterOrDigit(post_exp.charAt(i))){
                stack.push(post_exp.charAt(i)+"");
            }else{
                String top1 = stack.pop();
                String top2 = stack.pop();
                String expr = post_exp.charAt(i)+top2+top1;
                stack.push(expr);
            }

            i++;
        }

        return stack.peek();
    }
}
