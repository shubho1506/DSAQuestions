package Queues.Implementation;

public class QueueUsingLinkedList {

    class QueueNode
    {
        int data;
        QueueNode next;
        QueueNode(int a)
        {
            data = a;
            next = null;
        }
    }

    QueueNode front, rear;

    void push(int a)
    {
        QueueNode newNode = new QueueNode(a);
        if(front==null){
            front = newNode;
            rear = newNode;
        }else {
            rear.next = newNode;
            rear = rear.next;
        }
    }

    int pop()
    {
        if(front==null){
            return -1;
        }
        int data = front.data;
        front = front.next;
        return data;
    }

    public static void main(String[] args) {

    }
}
