package LinkedList.Medium;

import LinkedList.Implementation.LinkedList;
import LinkedList.Implementation.Node;

//You are given a linked list where each element in the list is a node and have an integer data.
// You need to add 1 to the number formed by concatenating all the list node numbers together and
// return the head of the modified linked list.
//Note: The head represents the first element of the given array.

//Examples :
//Input: LinkedList: 4->5->6
//Output: 457
//Explanation: 4->5->6 represents 456 and when 1 is added it becomes 457.

//Input: LinkedList: 1->2->3
//Output: 124
//Explanation:  1->2->3 represents 123 and when 1 is added it becomes 124.

public class Add1ToALinkedListNumber {
    public static void main(String[] args) {
        LinkedList ll = new LinkedList();
        ll.AddFirst("9");
        ll.AddLast("9");
        ll.AddLast("9");
        ll.AddLast("9");
        ll.AddLast("9");

        ll.head = addOne(ll.head);
        ll.printList();

    }

    public static Node addOne(Node head) {
        head = reverse(head);
        Node temp = head;
        int carry = 1;

        while(temp!=null){
            temp.data = String.valueOf(Integer.parseInt(temp.data)+1);
            if(Integer.parseInt(temp.data)<10){
                carry=0;
                break;
            }else {
                temp.data = "0";
                carry = 1;
            }
            temp = temp.next;
        }

        if(carry==1){
            Node newNode = new Node("1");
            head = reverse(head);
            newNode.next = head;
            head = newNode;
        }
        return head;
    }

    public static Node reverse(Node head){
        if(head==null || head.next==null){
            return head;
        }
        Node prevNode = head;
        Node currentNode = head.next;
        while(currentNode != null){
            Node nextNode = currentNode.next;
            currentNode.next = prevNode;
            prevNode = currentNode;
            currentNode = nextNode;
        }
        head.next = null;
        head = prevNode;
        return head;
    }
}
