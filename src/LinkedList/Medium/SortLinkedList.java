package LinkedList.Medium;

import LinkedList.Implementation.LinkedList;
import LinkedList.Implementation.Node;

//Given the head of a linked list, return the list after sorting it in ascending order.
//Example 1:
//Input: head = [4,2,1,3]
//Output: [1,2,3,4]

//Example 2:
//Input: head = [-1,5,3,4,0]
//Output: [-1,0,3,4,5]

//Example 3:
//Input: head = []
//Output: []

public class SortLinkedList {
    public static void main(String[] args) {
        LinkedList ll = new LinkedList();
        ll.AddFirst("3");
        ll.AddLast("1");
        ll.AddLast("5");
        ll.AddLast("2");
        ll.AddLast("4");

        ll.head = sortList(ll.head);
        ll.printList();
    }

    //I am using Merge sort
    public static Node sortList(Node head) {
        if(head==null || head.next==null){
            return head;
        }

        Node slow = head;
        Node fast = head;
        Node prevSlow = null;

        while(fast!=null && fast.next!=null){
            prevSlow = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        prevSlow.next =null;
        Node n1 = sortList(head);
        Node n2 = sortList(slow);

        return merge(n1,n2);
    }

    private static Node merge(Node n1,Node n2){
        Node newNode = new Node("0");
        Node n3 = newNode;

        while(n1!=null && n2!=null){
            if((Integer.parseInt(n1.data))<(Integer.parseInt(n2.data))){
                n3.next = n1;
                n1 = n1.next;
            }else {
                n3.next = n2;
                n2 = n2.next;
            }
            n3 = n3.next;
        }

        if(n1!=null){
            n3.next = n1;
        }

        if (n2!=null){
            n3.next = n2;
        }

        return newNode.next;
    }
}
