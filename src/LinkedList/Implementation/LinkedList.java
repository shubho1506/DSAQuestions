package LinkedList.Implementation;

public class LinkedList {

    public Node head;

    public LinkedList(){
        head = null;
    }

    public void AddFirst(String value){
        Node newNode = new Node(value);
        if(head==null){
            head = newNode;
            return;
        }
        newNode.next = head;
        head = newNode;
    }

    public void AddLast(String value){
        Node newNode = new Node(value);
        if(head==null){
            head = newNode;
            return;
        }
        Node currNode = head;
        while(currNode.next != null){
            currNode = currNode.next;
        }
        currNode.next = newNode;
    }

    public void printList(){
        if(head==null){
            System.out.println("linkedlist is empty !!!");
            return;
        }
        Node currNode = head;
        while(currNode != null){
            System.out.print(currNode.data + " => ");
            currNode = currNode.next;
        }
        System.out.println("null");
    }

    public void DeleteFirst(){
        if(head == null){
            System.out.println("Linkedlist is empty");
            return;
        }
        head = head.next;
    }

    public void DeleteLast(){
        if(head == null){
            System.out.println("LinkedList is empty");
        }

        if(head.next == null){
            head = null;
            return;
        }

        Node currNode = head;
        while(currNode.next.next != null){
            currNode = currNode.next;
        }
        currNode.next = null;
    }

    public int LengthOfTheLinkedList(){
        int count = 0;
        Node currNode = head;
        if(head==null){
            return 0;
        }
        while(currNode != null){
            count++;
            currNode = currNode.next;
        }
        return count;
    }

    public boolean SearchInLinkedList(String data){
        if(head == null){
            return false;
        }
        Node currNode = head;
        while(currNode != null){
            if(currNode.data.equals(data)){
                return true;
            }
            currNode = currNode.next;
        }
        return false;
    }


    public static void main(String[] args) {
        LinkedList ll = new LinkedList();
        ll.AddFirst("this");
        ll.AddLast("is");
        ll.AddLast("shubho");
        ll.printList();
        System.out.println(ll.LengthOfTheLinkedList());
        System.out.println(ll.SearchInLinkedList("this"));
    }
}
