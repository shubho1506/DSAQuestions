package Stacks.Implementation;

public class StackUsingLinkedList {
     class StackNode {
         int data;
         StackNode next;
         StackNode(int a) {
             data = a;
             next = null;
         }
     }

    StackNode top;

    void push(int a) {
        StackNode newNode = new StackNode(a);
        newNode.next = top;
        top = newNode;
    }

    int pop() {
        if(top==null){
            return -1;
        }
        int poppedData = top.data;
        top = top.next;
        return poppedData;
    }

    int peek() {
        if (top == null) {
            System.out.println("Stack is empty");
            return -1;
        }
        return top.data;
    }

    boolean isEmpty() {
        return top == null;
    }

    public static void main(String[] args) {
        StackUsingLinkedList stack = new StackUsingLinkedList();

        stack.push(10);
        stack.push(20);
        stack.push(30);

        System.out.println("Top: " + stack.peek());
        System.out.println("Popped: " + stack.pop());
        System.out.println("Top after pop: " + stack.peek());
        System.out.println("Is Empty? " + stack.isEmpty());

        stack.pop();
        stack.pop();
        System.out.println("Is Empty? " + stack.isEmpty());
        System.out.println("Pop when empty: " + stack.pop());
    }
}
