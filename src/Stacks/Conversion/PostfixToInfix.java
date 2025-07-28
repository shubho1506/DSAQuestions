package Stacks.Conversion;

//You are given a string that represents the postfix form of a valid mathematical expression.
//Convert it to its infix form.
//
//Example:
//
//Input:
//ab*c+
//Output:
//((a*b)+c)
//Explanation:
//The above output is its valid infix form.

import java.util.Stack;

public class PostfixToInfix {
    public static void main(String[] args) {
        System.out.println(postToInfix("ab*c+"));
    }

    static String postToInfix(String exp) {
        Stack<String> stack = new Stack<>();
        int i=0;
        while(i<exp.length()){
            if(Character.isLetterOrDigit(exp.charAt(i))){
                stack.push(exp.charAt(i)+"");
            }else{
                String top1 = stack.pop();
                String top2 = stack.pop();
                String expr = "("+top2+exp.charAt(i)+top1+")";
                stack.push(expr);
            }
            i++;
        }
        return stack.peek();
    }
}
