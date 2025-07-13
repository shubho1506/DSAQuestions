package Recursion.Medium;

import java.util.*;

public class ReverseAStack {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(2);
        stack.push(5);
        stack.push(6);
        stack.push(7);
        stack.push(2);
        stack.push(1);
        stack.push(9);
        reverse(stack);
        System.out.println(stack);
    }

    static void reverse(Stack<Integer> s) {
        if(s.isEmpty()){
            return;
        }
        int value =  s.pop();
        reverse(s);
        insertAtBottom(s,value);
    }

    static void insertAtBottom(Stack<Integer> s,int value){
        if(s.isEmpty()){
            s.push(value);
            return;
        }
        int top = s.pop();
        insertAtBottom(s,value);
        s.push(top);
    }

}
