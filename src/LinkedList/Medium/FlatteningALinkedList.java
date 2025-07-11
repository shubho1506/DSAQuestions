package LinkedList.Medium;

import LinkedList.Implementation.Node;

//Given a linked list containing n head nodes where every node in the linked list contains two pointers:
//(i) next points to the next node in the list.
//(ii) bottom pointer to a sub-linked list where the current node is the head.
//Each of the sub-linked lists nodes and the head nodes are sorted in ascending order based on their data.
//Your task is to flatten the linked list such that all the nodes appear in a single level while maintaining
// the sorted order.
//Note:
//1. ↓ represents the bottom pointer and -> represents the next pointer.
//2. The flattened list will be printed using the bottom pointer instead of the next pointer.

//Examples:
//Input:
//Output: 5-> 7-> 8-> 10 -> 19-> 20-> 22-> 28-> 30-> 35-> 40-> 45-> 50.
//Explanation:
//Bottom pointer of 5 is pointing to 7.
//Bottom pointer of 7 is pointing to 8.
//Bottom pointer of 8 is pointing to 10 and so on.

//Input:
//Output: 5-> 7-> 8-> 10-> 19-> 22-> 28-> 30-> 50
//Explanation:
//Bottom pointer of 5 is pointing to 7.
//Bottom pointer of 7 is pointing to 8.
//Bottom pointer of 8 is pointing to 10 and so on.

public class FlatteningALinkedList {
    public static void main(String[] args) {

    }

    public static Node flatten(Node root) {
        if(root==null||root.next==null){
            return root;
        }
        Node mergedHead = flatten(root.next);
        return merge(root,mergedHead);
    }

    static Node merge(Node list1,Node list2){
        Node dummyNode = new Node("-1");
        Node temp = dummyNode;

//        while(list1 != null && list2 != null){
//            if(Integer.parseInt(list1.data)<Integer.parseInt(list2.data)){
//                temp.bottom = list1;
//                temp = list1;
//                list1 = list1.bottom;
//            }else{
//                temp.bottom = list2;
//                temp = list2;
//                list2 = list2.bottom;
//            }
//            temp.next = null;
//        }
//
//        if(list1!=null){
//            temp.bottom = list1;
//        }
//
//        if(list2 != null){
//            temp.bottom = list2;
//        }
//
//        if(dummyNode.bottom !=null){
//            dummyNode.bottom.next = null;
//        }

//        return dummyNode.bottom;
        return dummyNode.next;
    }
}
