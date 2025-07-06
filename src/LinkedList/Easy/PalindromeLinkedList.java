package LinkedList.Easy;

import LinkedList.Implementation.LinkedList;
import LinkedList.Implementation.Node;


public class PalindromeLinkedList {
    public static void main(String[] args) {
        LinkedList ll = new LinkedList();
        ll.AddLast("1");
        ll.AddLast("2");
        ll.AddLast("3");
        ll.AddLast("2");
        ll.AddLast("1");

        System.out.println(isPalindrome(ll.head));
    }

    public static boolean isPalindrome(Node head) {
        if (head == null || head.next == null){
            return true;
        }

        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        Node secondHalfStart = reverse(slow);
        Node firstHalfStart = head;

        while (secondHalfStart != null) {
            if (firstHalfStart.data != secondHalfStart.data) {
                return false;
            }
            firstHalfStart = firstHalfStart.next;
            secondHalfStart = secondHalfStart.next;
        }
        return true;

    }

    private static Node reverse(Node head) {
        Node prev = null;
        Node curr = head;

        while (curr != null) {
            Node next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }
}
