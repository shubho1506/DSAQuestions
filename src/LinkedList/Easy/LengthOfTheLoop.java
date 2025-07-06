package LinkedList.Easy;

import LinkedList.Implementation.LinkedList;
import LinkedList.Implementation.Node;

//Given the head of a linked list, determine whether the list contains a loop. If a loop is present,
// return the number of nodes in the loop, otherwise return 0.
//Note: 'c' is the position of the node which is the next pointer of the last node of the linkedlist.
// If c is 0, then there is no loop.

//Examples:
//Input: head: 1 → 2 → 3 → 4 → 5, c = 2
//Output: 4
//Explanation: There exists a loop in the linked list and the length of the loop is 4.

//Input: head: 25 → 14 → 19 → 33 → 10 → 21 → 39 → 90 → 58 → 45, c = 4
//Output: 7
//Explanation: The loop is from 33 to 45. So length of loop is 33 → 10 → 21 → 39 → 90 → 58 → 45 = 7.
//The number 33 is connected to the last node of the linkedlist to form the loop because according to the
//input the 4th node from the beginning(1 based indexing)
//will be connected to the last node in the LinkedList.

//Input: head: 0 → 1 → 2 → 3, c = 0
//Output: 0
//Explanation: There is no loop.

public class LengthOfTheLoop {
    public static void main(String[] args) {
        LinkedList ll = new LinkedList();
        ll.AddFirst("this");
        ll.AddLast("is");
        ll.AddLast("shubho");
        ll.printList();

        createLoop(1,ll.head);
        System.out.println(countNodesInLoop(ll.head));
    }

    public static int countNodesInLoop(Node head) {
        Node turtle = head;
        Node hare = head;
        int count = 1;
        while (hare !=null && hare.next !=null){
            turtle = turtle.next;
            hare = hare.next.next;

            if(turtle==hare){
                return countLoopLength(turtle);
            }
        }
        return count;
    }

    public static int countLoopLength(Node meetPoint){
        int count = 1;
        Node temp = meetPoint.next;

        while (temp != meetPoint) {
            count++;
            temp = temp.next;
        }

        return count;
    }

    public static void createLoop(int position, Node head) {
        if (position < 0) return;

        Node loopNode = head;
        for (int i = 0; i < position; i++) {
            if (loopNode == null) return;
            loopNode = loopNode.next;
        }

        Node last = head;
        while (last.next != null) {
            last = last.next;
        }

        last.next = loopNode;
    }
}
