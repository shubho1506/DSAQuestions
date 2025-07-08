package LinkedList.Medium;

import LinkedList.Implementation.LinkedList;
import LinkedList.Implementation.Node;

//Given the head of a linked list where nodes can contain values 0s, 1s, and 2s only. Your task is to rearrange the list
// so that all 0s appear at the beginning, followed by all 1s, and all 2s are placed at the end.

//Examples:
//Input: head = 1 → 2 → 2 → 1 → 2 → 0 → 2 → 2
//Output: 0 → 1 → 1 → 2 → 2 → 2 → 2 → 2
//Explanation: All the 0s are segregated to the left end of the linked list, 2s to the right end of the list, and 1s in between.

//Input: head = 2 → 2 → 0 → 1
//Output: 0 → 1 → 2 → 2
//Explanation: After arranging all the 0s, 1s and 2s in the given format, the output will be 0 → 1 → 2 → 2.

public class SortLinkedListof0s1s2s {
    public static void main(String[] args) {
        LinkedList ll = new LinkedList();
        ll.AddFirst("1");
        ll.AddLast("1");
        ll.AddLast("0");
        ll.AddLast("2");
        ll.AddLast("2");

        ll.head = segregate(ll.head);
        ll.printList();
    }

    private static Node segregate(Node head) {
        if (head == null || head.next == null) {
            return head;
        }

        Node zeroHead = new Node("0");
        Node oneHead = new Node("1");
        Node twoHead = new Node("2");

        Node zero = zeroHead;
        Node one = oneHead;
        Node two = twoHead;

        Node curr = head;

        while (curr != null) {
            if (curr.data.equals("0")) {
                zero.next = curr;
                zero = zero.next;
            } else if (curr.data.equals("1")) {
                one.next = curr;
                one = one.next;
            } else {
                two.next = curr;
                two = two.next;
            }
            curr = curr.next;
        }

        zero.next = (oneHead.next != null )? oneHead.next : twoHead.next;
        one.next = twoHead.next;
        two.next = null;

        return zeroHead.next;

    }
}
