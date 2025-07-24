package Stacks.Implementation;

public class StackUsingArrays {

    private int[] arr;
    private int top;

    public StackUsingArrays() {
        arr = new int[1000];
        top = -1;
    }

    public void push(int x) {
        arr[++top] = x;
    }

    public int pop() {
        if(top<0){
            return -1;
        }
        return arr[top--];
    }

    public static void main(String[] args) {
        StackUsingArrays stack = new StackUsingArrays();
        stack.push(10);
        stack.push(20);
        stack.pop();
        System.out.println(stack.pop());
    }
}
