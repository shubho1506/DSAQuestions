package LinkedList.Easy;

//Given the head of a singly linked list, reverse the list, and return the reversed list.

//Example 1:
//Input: head = [1,2,3,4,5]
//Output: [5,4,3,2,1]

//Example 2:
//Input: head = [1,2]
//Output: [2,1]

//Example 3:
//Input: head = []
//Output: []

import LinkedList.Implementation.LinkedList;
import LinkedList.Implementation.Node;

public class ReverseALinkedListRecursive {
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
        if (head == null || head.next == null) {
            return head;
        }
        Node newHead = reverseLinkedList(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }
}
