package POTD;


import LinkedList.Implementation.LinkedList;
import LinkedList.Implementation.Node;


public class ConvertBinaryNumberInALinkedListToInteger {
    public static void main(String[] args) {
        LinkedList ll = new LinkedList();
        ll.AddFirst("1");
        ll.AddLast("0");
        ll.AddLast("1");
        System.out.println(getDecimalValue(ll.head));
    }
    public static int getDecimalValue(Node head) {
        StringBuilder sb = new StringBuilder();
        Node temp = head;
        while(temp != null){
            sb.append(temp.data);
            temp = temp.next;
        }
        return Integer.parseInt(sb.toString(),2);
    }
}
