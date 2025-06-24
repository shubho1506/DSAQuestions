package LinkedList.DoublyLinkedList;

import LinkedList.Implementation.DLNode;
import LinkedList.Implementation.DoublyLinkedList;

public class ReverseADoublyLinkedList {
    public static void main(String[] args) {
        DoublyLinkedList dll = new DoublyLinkedList();
        dll.AddFirst("Hi");
        dll.AddLast("this");
        dll.AddLast("is");
        dll.AddLast("shubhodeep");
        dll.head = reverseDoublyLinkedList(dll.head);
        dll.printListForward();
    }

    public static DLNode reverseDoublyLinkedList(DLNode head){
        if(head==null || head.next==null){
            return head;
        }
        DLNode prev = null;
        DLNode curr = head;

        while (curr != null){
            prev = curr.prev;
            curr.prev = curr.next;
            curr.next = prev;

            curr = curr.prev;
        }

        if(prev != null){
            head = prev.prev;
        }

        return head;
    }
}
