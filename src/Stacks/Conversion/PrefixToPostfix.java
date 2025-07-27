package Stacks.Conversion;

//You are given a string that represents the prefix form of a valid mathematical expression.
// Convert it to its postfix form.
//
//Example:
//
//Input:
//*-A/BC-/AKL
//Output:
//ABC/-AK/L-*
//Explanation:
//The above output is its valid postfix form.

import java.util.Stack;

public class PrefixToPostfix {
    public static void main(String[] args) {
        System.out.println(preToPost("*-A/BC-/AKL"));
    }

    static String preToPost(String pre_exp) {
        int i=pre_exp.length()-1;
        Stack<String> stack = new Stack<>();

        while(i>=0){
            if(Character.isLetterOrDigit(pre_exp.charAt(i))){
                stack.push(pre_exp.charAt(i)+"");
            }else{
                String expr = stack.pop()+stack.pop()+pre_exp.charAt(i);
                stack.push(expr);
            }
            i--;
        }

        return stack.peek();
    }
}
