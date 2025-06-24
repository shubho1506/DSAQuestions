package LinkedList.Implementation;

public class DLImplementation {
    public DLNode head;

    public DLImplementation(){
        head = null;
    }

    public void AddLast(String data){
        DLNode newNode = new DLNode(data);
        if(head ==null){
            head = newNode;
            return;
        }
        DLNode current = head;
        while(current.next != null){
            current = current.next;
        }
        current.next = newNode;
        newNode.prev = current;
    }

    public void AddFirst(String data){
        DLNode newNode = new DLNode(data);
        if(head==null){
            head = newNode;
            return;
        }
        DLNode current = head;
        current.prev = newNode;
        newNode.next = current;
        head = newNode;
    }

    public void printListForward(){
        if(head==null){
            System.out.println("Doubly linked list is empty");
            return;
        }
        DLNode current = head;
        while(current !=null){
            System.out.print(current.data + " => ");
            current = current.next;
        }
        System.out.println("Null");
    }

    //using recursion otherwise just loop forward till end and print backwards
    public void printListBackward(DLNode node){
        if(head==null){
            System.out.println("Doubly linked list is empty");
            return;
        }
        if(node.next == null){
            System.out.print(node.data + " => ");
            return;
        }
        printListBackward(node.next);
        System.out.print(node.data + " => ");
        if(node.prev==null){
            System.out.println("Null");
        }
    }

    public void DeleteFirst(){
        if(head==null){
            System.out.println("Doubly linked list is empty");
            return;
        }
        if(head.next==null){
            head = null;
            return;
        }
        DLNode current = head;
        head = current.next;
        current.next = null;
        head.prev = null;
    }

    public void DeleteLast(){
        if(head==null){
            System.out.println("Doubly linked list is empty");
            return;
        }
        if(head.next==null){
            head = null;
            return;
        }
        DLNode current = head;
        while(current.next != null){
            current = current.next;
        }
        current = current.prev;
        current.next = null;
    }

    public int LengthOfDoubleLinkedList(){
        int count = 0;
        if(head==null){
            return 0;
        }
        DLNode current = head;
        while (current != null){
            count++;
            current = current.next;
        }
        return count;
    }

    public boolean searchInDoubleLinkedList(String data){
        if(head == null){
            System.out.println("Double linked list is empty");
            return false;
        }
        DLNode current = head;
        while(current != null){
            if(current.data.equals(data)){
                return true;
            }
            current = current.next;
        }
        return false;
    }

    public static void main(String[] args) {
        DLImplementation dll = new DLImplementation();
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
