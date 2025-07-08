package Stacks.Implementation;

import java.util.LinkedList;
import java.util.Queue;

public class ImplementStackUsingQueues {
    Queue<Integer> q1;
    Queue<Integer> q2;

    public ImplementStackUsingQueues() {
        q1 = new LinkedList<>();
        q2 = new LinkedList<>();
    }

    public void push(int x) {
        if (!q1.isEmpty()) {
            q1.offer(x);
        }
        else q2.offer(x);
    }

    public int pop() {
        int x = 0;
        if (!q1.isEmpty()) {
            while (!q1.isEmpty()) {
                x = q1.poll();
                if (!q1.isEmpty()) q2.offer(x);
            }
        } else {
            while (!q2.isEmpty()) {
                x = q2.poll();
                if (!q2.isEmpty()) q1.offer(x);
            }
        }
        return x;
    }

    public int top() {
        int x = 0;
        if (!q1.isEmpty()) {
            while (!q1.isEmpty()) {
                x = q1.poll();
                q2.offer(x);
            }
        } else {
            while (!q2.isEmpty()) {
                x = q2.poll();
                q1.offer(x);
            }
        }
        return x;
    }

    public boolean empty() {
        return q1.isEmpty() && q2.isEmpty();
    }

    public static void main(String[] args) {
        ImplementStackUsingQueues stack = new ImplementStackUsingQueues();
        stack.push(10);
        stack.push(20);
        stack.push(30);
        System.out.println(stack.pop());
        System.out.println(stack.top());
    }
}
