package LinkedList.Medium;

//You are given two non-empty linked lists representing two non-negative integers.
// The digits are stored in reverse order, and each of their nodes contains a single digit.
// Add the two numbers and return the sum as a linked list.
//You may assume the two numbers do not contain any leading zero, except the number 0 itself.

//Example 1:
//Input: l1 = [2,4,3], l2 = [5,6,4]
//Output: [7,0,8]
//Explanation: 342 + 465 = 807.

//Example 2:
//Input: l1 = [0], l2 = [0]
//Output: [0]

//Example 3:
//Input: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
//Output: [8,9,9,9,0,0,0,1]

import LinkedList.Implementation.LinkedList;
import LinkedList.Implementation.Node;

public class AddTwoNumbers {
    public static void main(String[] args) {
        LinkedList ll = new LinkedList();
        ll.AddFirst("9");
        ll.AddLast("9");
        ll.AddLast("9");
        ll.AddLast("9");
        ll.AddLast("9");

        LinkedList ll2 = new LinkedList();
        ll2.AddFirst("9");
        ll2.AddLast("9");
        ll2.AddLast("9");
        ll2.AddLast("9");
        ll2.AddLast("9");

        LinkedList  ll3 = new LinkedList();
        ll3.head = addTwoNumbers(ll.head,ll2.head);
        ll3.printList();

    }

    public static Node addTwoNumbers(Node l1, Node l2) {
        int carry = 0;
        Node temp1 = l1;
        Node temp2 = l2;
        Node temp = new Node("0");
        Node curr = temp;

        while(temp1!=null || temp2!= null){
            int sum = 0;
            if(temp1!=null){
                sum += Integer.parseInt(temp1.data);
                temp1 = temp1.next;
            }

            if(temp2!=null){
                sum += Integer.parseInt(temp2.data);
                temp2 = temp2.next;
            }

            sum += carry;
            carry = sum/10;

            Node newNode = new Node(String.valueOf(sum%10));
            curr.next = newNode;
            curr = curr.next;
        }
        if (carry > 0) {
            curr.next = new Node(String.valueOf(carry));
        }
        return temp.next;
    }
}
