package Stacks.Implementation;

//| Approach    | Queues Used | Push Time | Pop Time | Top Time | Best For              |
//| ----------- | ----------- | --------- | -------- | -------- | --------------------- |
//| Costly Push | 1 queue     | O(n)      | O(1)     | O(1)     | When push is rare     |

import java.util.LinkedList;
import java.util.Queue;

public class StackUsingQueues1 {
    Queue<Integer> queue;
    StackUsingQueues1(){
        queue = new LinkedList<>();
    }

    public void push(int x) {
        int size = queue.size();
        queue.add(x);  // Add new element
        // Rotate the old elements behind the new one
        for (int i = 0; i < size; i++) {
            queue.add(queue.remove());
        }
    }

    public int pop() {
        return queue.remove();
    }

    public int top() {
        return queue.peek();
    }

    public boolean empty() {
        return queue.isEmpty();
    }

    public static void main(String[] args) {
        StackUsingQueues1 stack = new StackUsingQueues1();

    }
}
