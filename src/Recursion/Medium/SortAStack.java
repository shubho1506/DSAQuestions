package Recursion.Medium;

import java.util.Stack;

//Given a stack, the task is to sort it such that the top of the stack has the greatest element.
//Example 1:
//Input:
//Stack: 3 2 1
//Output: 3 2 1

//Example 2:
//Input:
//Stack: 11 2 32 3 41
//Output: 41 32 11 3 2

public class SortAStack {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(2);
        stack.push(5);
        stack.push(6);
        stack.push(7);
        stack.push(2);
        stack.push(1);
        stack.push(9);
        sort(stack);
        System.out.println(stack);
    }

    static void sort(Stack<Integer> stack){
        if(stack.isEmpty()){
            return;
        }
        int top =  stack.pop();
        sort(stack);
        sortHelper(stack,top);
    }

    static void sortHelper(Stack<Integer> stack,int value){
        if(stack.isEmpty() || stack.peek()<=value){
            stack.push(value);
            return;
        }
        int top = stack.pop();
        sortHelper(stack, value);
        stack.push(top);
    }
}
