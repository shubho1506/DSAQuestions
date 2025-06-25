package LinkedList.Easy;

//Given head, the head of a linked list, determine if the linked list has a cycle in it.
//There is a cycle in a linked list if there is some node in the list that can be reached again by continuously
//following the next pointer. Internally, pos is used to denote the index of the node that tail's next pointer
//is connected to. Note that pos is not passed as a parameter.
//Return true if there is a cycle in the linked list. Otherwise, return false.

//Example 1:
//Input: head = [3,2,0,-4], pos = 1
//Output: true
//Explanation: There is a cycle in the linked list, where the tail connects to the 1st node (0-indexed).

//Example 2:
//Input: head = [1,2], pos = 0
//Output: true
//Explanation: There is a cycle in the linked list, where the tail connects to the 0th node.

//Example 3:
//Input: head = [1], pos = -1
//Output: false
//Explanation: There is no cycle in the linked list.

import LinkedList.Implementation.Node;
import LinkedList.Implementation.LinkedList;

public class DetectALoopInLinkedList {
    public static void main(String[] args) {
        LinkedList ll = new LinkedList();
        ll.AddFirst("this");
        ll.AddLast("is");
        ll.AddLast("shubho");
        ll.printList();

        createLoop(1,ll.head);

        System.out.println(hasCycle(ll.head));
    }

    public static boolean hasCycle(Node head) {
        Node turtle = head;
        Node hare = head;

        while(hare != null && hare.next != null){
            turtle = turtle.next;
            hare = hare.next.next;
            if(turtle==hare){
                return true;
            }
        }
        return false;
    }

    public static void createLoop(int position,Node head) {
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
