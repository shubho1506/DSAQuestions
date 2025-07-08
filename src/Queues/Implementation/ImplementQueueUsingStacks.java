package Queues.Implementation;

import java.util.Stack;

public class ImplementQueueUsingStacks {
    Stack<Integer> s1;

    public ImplementQueueUsingStacks(){
        s1 = new Stack<>();
    }

    public void push(int x) {
        s1.push(x);
    }

    public int pop() {
        Stack<Integer> temp = new Stack<>();
        while(!s1.isEmpty()){
            temp.push(s1.pop());
        }
        int a = temp.pop();
        while(!temp.isEmpty()){
            s1.push(temp.pop());
        }
        return a;
    }

    public int peek() {
        Stack<Integer> temp = new Stack<>();
        while(!s1.isEmpty()){
            temp.push(s1.pop());
        }
        int a = temp.peek();
        while(!temp.isEmpty()){
            s1.push(temp.pop());
        }
        return a;
    }

    public boolean empty() {
        return s1.isEmpty();
    }

    public static void main(String[] args) {
        ImplementQueueUsingStacks queue = new ImplementQueueUsingStacks();
        queue.push(20);
        queue.push(10);
        queue.push(40);
        System.out.println(queue.pop());
    }
}
