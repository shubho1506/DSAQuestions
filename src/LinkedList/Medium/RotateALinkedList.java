package LinkedList.Medium;

import LinkedList.Implementation.LinkedList;
import LinkedList.Implementation.Node;

public class RotateALinkedList {
    public static void main(String[] args) {
        LinkedList ll = new LinkedList();
        ll.AddFirst("this");
        ll.AddLast("is");
        ll.AddLast("shubho");
        ll.AddLast("deep");
        ll.AddLast("sarkar");

        ll.head = rotateRight(ll.head,2);
        ll.printList();
    }

    public static Node rotateRight(Node head, int k) {
        if(head==null || head.next==null||k<=0){
            return head;
        }
        int lengthLL = 1;
        Node temp = head;
        while (temp.next!=null){
            lengthLL++;
            temp = temp.next;
        }

        temp.next=head;

        int toRotate = k%lengthLL;
        Node newEnd = head;
        for(int i =0; i<(lengthLL-toRotate)-1;i++ )
        {
            newEnd =newEnd.next;
        }

        head = newEnd.next;
        newEnd.next = null;
        return head;
    }

}
