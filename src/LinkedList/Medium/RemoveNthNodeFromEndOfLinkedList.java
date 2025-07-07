package LinkedList.Medium;

import LinkedList.Implementation.LinkedList;
import LinkedList.Implementation.Node;

//Given the head of a linked list, remove the nth node from the end of the list and return its head.
//Example 1:
//Input: head = [1,2,3,4,5], n = 2
//Output: [1,2,3,5]

//Example 2:
//Input: head = [1], n = 1
//Output: []

//Example 3:
//Input: head = [1,2], n = 1
//Output: [1]

public class RemoveNthNodeFromEndOfLinkedList {
    public static void main(String[] args) {
        LinkedList ll = new LinkedList();
        ll.AddFirst("this");
        ll.AddLast("is");
        ll.AddLast("shubho");
        ll.AddLast("deep");
        ll.AddLast("sarkar");

        ll.head = removeNthFromEnd(ll.head,2);
        ll.printList();
    }

    public static Node removeNthFromEnd(Node head, int n) {
        Node fast = head;
        Node slow = head;
        for(int i=0;i<n;i++){
            fast = fast.next;
        }
        if(fast==null){
            return head.next;
        }
        while(fast.next != null){
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return head;
    }
}
