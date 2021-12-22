package LCtag;
import java.util.HashMap;
import java.util.Map;

public class LFU_Cache {
    private Map<Integer, Node> cache;//key : key, value: cached Node
    private Map<Integer, DoubleLinkedList> freqMap;//key: frequency, value: doubleLinkedList of Node;
    private int size;
    private int capacity;
    private int minFreq;

    public LFU_Cache(int capacity){
        this.size = 0;
        this.capacity = capacity;
        this.minFreq = 0;
        cache = new HashMap<Integer, Node>(capacity);
        freqMap = new HashMap<Integer, DoubleLinkedList>();
    }

    public int get(int key){
        Node node = cache.get(key);
        if(node == null) return -1;
        incFreq(node);
        return node.val;
    }
    public void put(int key, int value){
        if(capacity == 0) return;
        Node node = cache.get(key);
        if(node != null){
            node.value = value;
            incFreq(node);
        }else{
            if(size == capacity){
                DoubleLinkedList nodeFreqList = freqMap.get(minFreq);
                cache.remove(nodeFreqList.tail.prev.key);
                nodeFreqList.removeNode(nodeFreqList.tail.prev);
                size--;
            }
            Node newNode = new Node(key, value);
            cache.put(key, newNode);
            DoubleLinkedList newList = freqMap.get(1);
            if(newList == null){
                newList = new DoubleLinkedList();

            }
            newList.addNode(newNode);
            freqMap.put(1, newList);
            size++;
            minFreq = 1;
        }
    }
    private void incFreq(Node node){
        int freq = node.freq;
        DoubleLinkedList curFreqList = freqMap.get(freq);
        curFreqList.removeNode(node);
        if(freq == minFreq ){
            minFreq++;
        }
        node.freq++;
        DoubleLinkedList newFreqList = freqMqp.get(node.freq);
        if(newFreqList == null){
            newFreqList = new DoubleLinkedList();
            freqMap.put(node.freq, newFreqList);
        }
        newFreqList.addNode(node);

    }
}

class Node{
    private int value;
    private int freq;
    private int key;
    Node prev;
    Node next;
    public Node(){};
    public Node(int key, int value){
        this.value = value;
        this.key = key;
        freq = 1;
    }
}

