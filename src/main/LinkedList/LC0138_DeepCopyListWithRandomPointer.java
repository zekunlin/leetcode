package LinkedList;
import java.util.*;
import Common.Node;

class DeepCopyList {
    Map<Node, Node> visitedMap;
    public Node copyRandomList(Node head) {
        if(head == null) return head;
        
        visitedMap = new HashMap<>();
        Node p = head;
        Node newHead = new Node(p.val);
        visitedMap.put(p, newHead);
        while(p != null)
        {
            newHead.random = generateNewNode(p.random);
            newHead.next = generateNewNode(p.next);

            p = p.next;
            newHead = newHead.next;
        }

        return visitedMap.get(head);
    }

    private Node generateNewNode(Node node){
        if(node == null) return node;

        if(visitedMap.containsKey(node)){
            return visitedMap.get(node);
        }
        else
        {
            visitedMap.put(node, new Node(node.val));
        }

        return visitedMap.get(node);
    }

    //sol2: recursion
    /*
         Map<Node, Node> visitedMap = new HashMap<>();
    public Node copyRandomList(Node head) {
        if(head == null) return head;
        if(visitedMap.containsKey(head)) return visitedMap.get(head);

        Node newNode = new Node(head.val);
        visitedMap.put(head, newNode);

        newNode.next = copyRandomList(head.next);
        newNode.random = copyRandomList(head.random);
        return newNode;
    }
     */
}