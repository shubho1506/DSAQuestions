package LinkedList.Implementation;

public class DLNode {
    public String data;
    public DLNode next;
    public DLNode prev;

    public DLNode(String data){
        this.data = data;
        this.next = null;
        this.prev = null;
    }
}
