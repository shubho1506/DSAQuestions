package LinkedList.Easy;

import LinkedList.Implementation.LinkedList;
import LinkedList.Implementation.Node;

public class MiddleOfTheLinkedList {
    public static void main(String[] args) {
        LinkedList ll = new LinkedList();
        ll.AddFirst("this");
        ll.AddLast("is");
        ll.AddLast("shubho");
        ll.printList();
        System.out.println(middleOfTheLinkedList(ll.head));
    }

    public static String middleOfTheLinkedList(Node head) {
        Node hare = head;
        Node turtle = head;
        while(hare != null && hare.next != null){
            hare = hare.next.next;
            turtle = turtle.next;
        }

        return turtle.data;
    }
}
