package Stacks.Conversion;

//You are given a string S of size N that represents the prefix form of a valid mathematical expression.
// The string S contains only lowercase and uppercase alphabets as operands and the operators are +, -, *, /, %,
// and ^.Convert it to its infix form.

//Example 1:
//Input:
//*-A/BC-/AKL
//Output:
//((A-(B/C))*((A/K)-L))
//Explanation:
//The above output is its valid infix form.

import java.util.Stack;

public class PrefixToInfix {
    public static void main(String[] args) {
        System.out.println(preToInfix("*-A/BC-/AKL"));
    }

    static String preToInfix(String pre_exp) {
        Stack<String> stack = new Stack<>();
        int i =  pre_exp.length()-1;

        while (i>=0){
            if(Character.isLetterOrDigit(pre_exp.charAt(i))){
                stack.push(pre_exp.charAt(i)+"");
            } else {
                String code = '('+ stack.pop() + pre_exp.charAt(i) + stack.pop()+')';
                stack.push(code);
            }
            i--;
        }

        return stack.peek();
    }
}
