package LCtag;
import LCtag.Node;
public class DoubleLinkedList {
    Node head;
    Node tail;
    public DoubleLinkedList(){
        head = new Node();
        tail = new Node();
        head.next = tail;
        tail.prev = head;
    }
    private void removeNode(Node node){
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
    private void addNode(Node node){
        node.next = head.next;
        node.prev = head;
        node.next.prev = node;
        head.next = node;
    }

}
