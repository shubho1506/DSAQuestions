package Algorithms.Famous;

import LinkedList.Implementation.LinkedList;
import LinkedList.Implementation.Node;

//Floyd’s cycle detection algorithm (also called tortoise and hare algorithm) →
//used to detect if a linked list has a loop (cycle) and middle of the linkedlist.

//Concept:
//You use 2 pointers:
//slow → moves 1 step at a time
//fast → moves 2 steps at a time

//Idea:
//If the linked list has no cycle → fast will reach end (null)
//If the linked list has a cycle → eventually fast and slow will meet inside the cycle


public class FloydLinkedListAlgorithm {
    public static void main(String[] args) {
        LinkedList ll = new LinkedList();
        ll.AddFirst("this");
        ll.AddLast("is");
        ll.AddLast("shubho");
        ll.printList();
        System.out.println(turtleHareAlgorithm(ll.head));
    }

    //for middle of the linkedlist
    public static String turtleHareAlgorithm(Node head) {
        Node hare = head;
        Node turtle = head;
        while(hare != null && hare.next != null){
            hare = hare.next.next;
            turtle = turtle.next;
        }

        return turtle.data;
    }

}
