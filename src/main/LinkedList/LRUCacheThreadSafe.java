package LinkedList;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import Common.DoubleLinkedListNode;

public class LRUCacheThreadSafe {
    DoubleLinkedListNode head;
    DoubleLinkedListNode tail;
    ConcurrentHashMap<Integer, DoubleLinkedListNode> cache;
    int capacity;
    private final Lock lock = new ReentrantLock();

    public LRUCacheThreadSafe(int capacity) {
        this.capacity = capacity;
        this.cache = new ConcurrentHashMap<>();
        this.head = new DoubleLinkedListNode(0, 0);
        this.tail = new DoubleLinkedListNode(0, 0);
        this.head.next = tail;
        this.tail.prev = head;
    }
    
    public int get(int key) {
        lock.lock();
        try{
            if(!cache.containsKey(key)){
                return -1;
            }

            //get cached item
            DoubleLinkedListNode node = cache.get(key);

            //mark it as head node as it's most recent used
            moveToHead(node);
            // return
            return node.val;
        }
        finally{
            lock.unlock();
        }
        
    }
    
    public void put(int key, int value) {
        lock.lock();

        try{
            //check if key exists,
            if(cache.containsKey(key)){
                DoubleLinkedListNode node = cache.get(key);
                node.val = value;
                moveToHead(node);
            }
            else{
                /*key not in cache:
                1. check if capacity reached
                    if reached, remove tail, add kv pair, move kv to head
                    else, add kv pair, move kv to head
                */
                DoubleLinkedListNode node = new DoubleLinkedListNode(key, value);
                cache.put(key, node);
                addToFront(node);

                if(cache.size() > capacity)
                {
                    evictLruNode();
                }
            }
        }
        finally{
            lock.unlock();
        }
        
    }

    private void evictLruNode(){
        DoubleLinkedListNode tailPrev = tail.prev;
        removeNode(tailPrev);
        cache.remove(tailPrev.key);
    }

    private void moveToHead(DoubleLinkedListNode node){
        removeNode(node);
        addToFront(node);
    }

    private void addToFront(DoubleLinkedListNode node){
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
        node.prev = head;
    }

    private void removeNode(DoubleLinkedListNode node){
        node.next.prev = node.prev;
        node.prev.next = node.next;
        
    }
}
