package LinkedList.DoublyLinkedList;

//Given a sorted doubly linked list of positive distinct elements, the task is to find pairs in a
// doubly-linked list whose sum is equal to given value target.

//Example 1:
//Input:
//1 <-> 2 <-> 4 <-> 5 <-> 6 <-> 8 <-> 9
//target = 7
//Output: (1, 6), (2,5)
//Explanation: We can see that there are two pairs
//(1, 6) and (2,5) with sum 7.
//Example 2:
//Input:
//1 <-> 5 <-> 6
//target = 6
//Output: (1,5)
//Explanation: We can see that there is one pairs  (1, 5) with sum 6.

//Your Task:
//You don't need to read input or print anything. Your task is to complete the function findPairsWithGivenSum()
// which takes head node of the doubly linked list and an integer target as input parameter and returns
// an array of pairs. If there is no such pair return empty array.

import LinkedList.Implementation.DLNode;
import LinkedList.Implementation.DoublyLinkedList;

import java.util.ArrayList;
import java.util.Collections;

public class FindPairsWithGivenSumInDoublyLinkedList {
    public static void main(String[] args) {
        DoublyLinkedList<Integer> dll = new DoublyLinkedList<>();
        dll.AddFirst(1);
        dll.AddLast(2);
        dll.AddLast(3);
        dll.AddLast(4);
        dll.AddLast(5);
        dll.AddLast(6);
        dll.AddLast(6);
        dll.AddLast(7);
        dll.AddLast(7);
        dll.AddLast(8);
        System.out.println(findPairsWithGivenSum(8,dll.head));;
    }

    public static ArrayList<ArrayList<Integer>> findPairsWithGivenSum(int target, DLNode<Integer> head) {

        DLNode<Integer> first = head;
        DLNode<Integer> last = head;
        ArrayList<ArrayList<Integer>> pairs = new ArrayList<>();

        while(last.next != null){
            last = last.next;
        }

        while(first != null && last != null && first != last && last.next != first){
            int sum = (int)first.data + (int)last.data;
            if(sum == target){
                ArrayList<Integer> pair = new ArrayList<>();
                pair.add((int)first.data);
                pair.add((int)last.data);
                pairs.add(pair);
                first = first.next;
                last = last.prev;
            } else if(sum<target){
                first = first.next;
            }else{
                last = last.prev;
            }
        }

        return pairs;
    }
}
