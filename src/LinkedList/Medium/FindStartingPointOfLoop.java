package LinkedList.Medium;

import LinkedList.Implementation.LinkedList;
import LinkedList.Implementation.Node;

//Given the head of a linked list, return the node where the cycle begins. If there is no cycle, return null.
//There is a cycle in a linked list if there is some node in the list that can be reached again by continuously
// following the next pointer. Internally, pos is used to denote the index of the node that tail's next pointer
// is connected to (0-indexed). It is -1 if there is no cycle. Note that pos is not passed as a parameter.
//Do not modify the linked list.

//Example 1:
//Input: head = [3,2,0,-4], pos = 1
//Output: tail connects to node index 1
//Explanation: There is a cycle in the linked list, where tail connects to the second node.

//Example 2:
//Input: head = [1,2], pos = 0
//Output: tail connects to node index 0
//Explanation: There is a cycle in the linked list, where tail connects to the first node.

//Example 3:
//Input: head = [1], pos = -1
//Output: no cycle
//Explanation: There is no cycle in the linked list.

public class FindStartingPointOfLoop {
    public static void main(String[] args) {
        LinkedList ll = new LinkedList();
        ll.AddFirst("this");
        ll.AddLast("is");
        ll.AddLast("shubho");
        ll.printList();

        createLoop(1,ll.head);

        System.out.println(findStartingPoint(ll.head));

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

    public static String findStartingPoint(Node head){
        Node turtle = head;
        Node hare = head;

        while (hare !=null && hare.next !=null){
            turtle = turtle.next;
            hare = hare.next.next;

            if(turtle==hare){
                turtle = head;

                while (turtle != hare){
                    turtle = turtle.next;
                    hare = hare.next;
                }

                return turtle.data;
            }
        }
        return "no loop";
    }
}
