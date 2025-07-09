package LinkedList.Implementation;

public class DLNode<T> {
    public T data;
    public DLNode<T> next;
    public DLNode<T> prev;

    public DLNode(T data){
        this.data = data;
        this.next = null;
        this.prev = null;
    }
}