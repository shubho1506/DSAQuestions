package LinkedList.Medium;

import java.util.HashMap;
import java.util.Map;

class NodeR {
    int val;
    NodeR next;
    NodeR random;

    public NodeR(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}

public class CopyListWithRandomPointer {
    public static void main(String[] args) {

    }

    public NodeR copyRandomList(NodeR head) {
        NodeR curr = head;
        Map<NodeR,NodeR> hmap = new HashMap<>();

        while(curr!=null){
            hmap.put(curr,new NodeR(curr.val));
            curr = curr.next;
        }

        curr = head;
        while(curr != null){
            NodeR newNode = hmap.get(curr);
            newNode.next = hmap.get(curr.next);
            newNode.random = hmap.get(curr.random);
            curr = curr.next;
        }

        return hmap.get(head);
    }
}
