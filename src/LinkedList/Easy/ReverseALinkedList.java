package LinkedList.Easy;

import LinkedList.Implementation.LinkedList;
import LinkedList.Implementation.Node;

public class ReverseALinkedList {
    public static void main(String[] args) {
        LinkedList ll = new LinkedList();
        ll.AddFirst("this");
        ll.AddLast("is");
        ll.AddLast("shubho");
        ll.printList();
        ll.head = reverseLinkedList(ll.head);
        ll.printList();
    }

    public static Node reverseLinkedList(Node head){
        if(head==null || head.next==null){
            return head;
        }
        Node prevNode = head;
        Node currentNode = head.next;
        while(currentNode != null){
            Node nextNode = currentNode.next;
            currentNode.next = prevNode;
            prevNode = currentNode;
            currentNode = nextNode;
        }
        head.next = null;
        head = prevNode;
        return head;
    }
}
