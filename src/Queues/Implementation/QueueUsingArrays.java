package Queues.Implementation;

public class QueueUsingArrays {

    int front, rear;
    int arr[] = new int[100005];

    QueueUsingArrays() {
        front = 0;
        rear = 0;
    }

    void push(int x) {
        arr[rear++] = x;
    }

    int pop() {
        if(front==rear){
            return -1;
        }
        return arr[front++];
    }

    public static void main(String[] args) {
        QueueUsingArrays queue = new QueueUsingArrays();
        queue.push(10);
        queue.push(20);
        queue.push(30);
        System.out.println(queue.pop());
        System.out.println(queue.pop());
    }
}
