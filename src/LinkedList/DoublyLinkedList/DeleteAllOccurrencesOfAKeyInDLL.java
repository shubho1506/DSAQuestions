package LinkedList.DoublyLinkedList;

//You are given the head_ref of a doubly Linked List and a Key. Your task is to delete all occurrences of the given key
// if it is present and return the new DLL.
//Example1:
//Input:
//2<->2<->10<->8<->4<->2<->5<->2
//2
//Output:
//10<->8<->4<->5
//Explanation:
//All Occurences of 2 have been deleted.

//Example2:
//Input:
//9<->1<->3<->4<->5<->1<->8<->4
//9
//Output:
//1<->3<->4<->5<->1<->8<->4
//Explanation:
//All Occurences of 9 have been deleted.

//Your Task:
//Complete the function void deleteAllOccurOfX(struct Node** head_ref, int key), which takes the reference of the head
// pointer and an integer value key. Delete all occurrences of the key from the given DLL.


import LinkedList.Implementation.DLNode;
import LinkedList.Implementation.DoublyLinkedList;

public class DeleteAllOccurrencesOfAKeyInDLL {
    public static void main(String[] args) {
        DoublyLinkedList<Integer> dll = new DoublyLinkedList<>();
        dll.AddFirst(9);
        dll.AddLast(7);
        dll.AddLast(8);
        dll.AddLast(9);
        dll.AddLast(1);
        dll.AddLast(5);
        dll.AddLast(3);
        dll.AddLast(9);
        dll.AddLast(7);
        dll.AddLast(8);

        dll.head = deleteAllOccurOfX(dll.head,9);
        dll.printListForward();
    }

    static DLNode deleteAllOccurOfX(DLNode head, int x) {
        DLNode<Integer> dummyNode = new DLNode<>(0);
        DLNode<Integer> temp = head;
        DLNode<Integer> curr = dummyNode;

        while (temp != null){
            if(temp.data != x){
                curr.next = temp;
                temp.prev = curr;
                curr = curr.next;
            }
            temp = temp.next;
        }
        curr.next = null;

        return dummyNode.next;
    }
}
