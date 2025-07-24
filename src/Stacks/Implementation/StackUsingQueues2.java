package Stacks.Implementation;

import java.util.LinkedList;
import java.util.Queue;

//| Approach    | Queues Used | Push Time | Pop Time | Top Time | Best For              |
//| ----------- | ----------- | --------- | -------- | -------- | --------------------- |
//| Costly Pop  | 2 queues    | O(1)      | O(n)     | O(n)     | When push is frequent |

public class StackUsingQueues2 {
    Queue<Integer> q1;
    Queue<Integer> q2;

    public StackUsingQueues2() {
        q1 = new LinkedList<>();
        q2 = new LinkedList<>();
    }

    public void push(int x) {
        q1.add(x);
    }

    public int pop() {
        if(q1.isEmpty()){
            throw new RuntimeException("Stack is empty");
        }

        while (q1.size()>1){
            q2.add(q1.remove());
        }

        int top = q1.remove();

        Queue<Integer> temp = q1;
        q1 = q2;
        q2 = temp;

        return top;
    }

    public int top() {
        while (q1.size()>1){
            q2.add(q1.remove());
        }

        int top = q1.remove();

        q2.add(top);
        Queue<Integer> temp = q1;
        q1 = q2;
        q2 = temp;

        return top;
    }

    public boolean empty() {
        return q1.isEmpty() && q2.isEmpty();
    }

    public static void main(String[] args) {
        StackUsingQueues2 stack = new StackUsingQueues2();
        stack.push(10);
        stack.push(20);
        stack.push(30);
        System.out.println(stack.pop());
        System.out.println(stack.top());
    }
}
