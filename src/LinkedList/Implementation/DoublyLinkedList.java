package LinkedList.Implementation;

public class DoublyLinkedList<T> {
    public DLNode<T> head;

    public DoublyLinkedList(){
        head = null;
    }

    public void AddLast(T data){
        DLNode<T> newNode = new DLNode<>(data);
        if(head == null){
            head = newNode;
            return;
        }
        DLNode<T> current = head;
        while(current.next != null){
            current = current.next;
        }
        current.next = newNode;
        newNode.prev = current;
    }

    public void AddFirst(T data){
        DLNode<T> newNode = new DLNode<>(data);
        if(head == null){
            head = newNode;
            return;
        }
        head.prev = newNode;
        newNode.next = head;
        head = newNode;
    }

    public void printListForward(){
        if(head == null){
            System.out.println("Doubly linked list is empty");
            return;
        }
        DLNode<T> current = head;
        while(current != null){
            System.out.print(current.data + " => ");
            current = current.next;
        }
        System.out.println("Null");
    }

    public void printListBackward(DLNode<T> node){
        if(head == null){
            System.out.println("Doubly linked list is empty");
            return;
        }
        if(node.next == null){
            System.out.print(node.data + " => ");
            return;
        }
        printListBackward(node.next);
        System.out.print(node.data + " => ");
        if(node.prev == null){
            System.out.println("Null");
        }
    }

    public void DeleteFirst(){
        if(head == null){
            System.out.println("Doubly linked list is empty");
            return;
        }
        if(head.next == null){
            head = null;
            return;
        }
        head = head.next;
        head.prev = null;
    }

    public void DeleteLast(){
        if(head == null){
            System.out.println("Doubly linked list is empty");
            return;
        }
        if(head.next == null){
            head = null;
            return;
        }
        DLNode<T> current = head;
        while(current.next != null){
            current = current.next;
        }
        current = current.prev;
        current.next = null;
    }

    public int LengthOfDoubleLinkedList(){
        int count = 0;
        DLNode<T> current = head;
        while(current != null){
            count++;
            current = current.next;
        }
        return count;
    }

    public boolean searchInDoubleLinkedList(T data){
        if(head == null){
            System.out.println("Doubly linked list is empty");
            return false;
        }
        DLNode<T> current = head;
        while(current != null){
            if(current.data.equals(data)){
                return true;
            }
            current = current.next;
        }
        return false;
    }

    public static void main(String[] args) {
        DoublyLinkedList<String> dll = new DoublyLinkedList<>();
        dll.AddFirst("This");
        dll.AddLast("is");
        dll.AddLast("shubhodeep");
        dll.AddFirst("Please");

        System.out.println(dll.LengthOfDoubleLinkedList());
        dll.printListForward();
        dll.printListBackward(dll.head);
        dll.DeleteFirst();
        dll.DeleteLast();
        dll.printListForward();
        System.out.println(dll.LengthOfDoubleLinkedList());
        System.out.println(dll.searchInDoubleLinkedList("shubhodeep"));
    }
}
