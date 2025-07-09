package LinkedList.DoublyLinkedList;
import LinkedList.Implementation.DLNode;
import LinkedList.Implementation.DoublyLinkedList;

//Given a doubly linked list of n nodes sorted by values, the task is to remove duplicate nodes present
// in the linked list.

//Example 1:
//Input:
//n = 6
//1<->1<->1<->2<->3<->4
//Output:
//1<->2<->3<->4
//Explanation:
//Only the first occurance of node with value 1 is
//retained, rest nodes with value = 1 are deleted.

//Example 2:
//Input:
//n = 7
//1<->2<->2<->3<->3<->4<->4
//Output:
//1<->2<->3<->4
//Explanation:
//Only the first occurance of nodes with values 2,3 and 4 are
//retained, rest repeating nodes are deleted.

public class RemoveDuplicatedFromSortedDLL {
    public static void main(String[] args) {
        DoublyLinkedList<Integer> dll = new DoublyLinkedList<>();
        dll.AddFirst(1);
        dll.AddLast(1);
        dll.AddLast(1);
        dll.AddLast(2);
        dll.AddLast(2);
        dll.AddLast(3);
        dll.AddLast(3);
        dll.AddLast(3);
        dll.AddLast(4);
        dll.AddLast(5);

        dll.head = removeDuplicates(dll.head);
        dll.printListForward();
    }

    public static DLNode removeDuplicates(DLNode head) {
        if(head==null || head.next==null){
            return head;
        }

        DLNode temp=head;

        while(temp.next!=null){
            if(temp.data==temp.next.data){
                temp.next=temp.next.next;

                if(temp.next!=null){
                    temp.next.prev=temp;
                }
            }
            else{
                temp=temp.next;
            }
        }

        return head;
    }
}
