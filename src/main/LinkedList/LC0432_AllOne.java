package LinkedList;

import java.util.*;

class AllOne {
    Node head; // node store freq and string at that freq
    Node tail;
    HashMap<String, Node> stringNodeMap; // map store string -> Node

    public AllOne() {//ascending order
        head = new Node(0);
        tail = new Node(0);
        head.next = tail;
        tail.prev = head;
        stringNodeMap = new HashMap<>();
    }
    
    public void inc(String key) {
        if(stringNodeMap.containsKey(key)){
            Node cur = stringNodeMap.get(key);
            cur.keySet.remove(key);
            if(cur.next != null){
                if(cur.next.freq == cur.freq + 1){
                    cur.next.keySet.add(key);
                    stringNodeMap.put(key, cur.next);
                }
                else
                {
                    Node newBucket = new Node(cur.freq + 1);
                    newBucket.keySet.add(key);
                    newBucket.prev = cur;
                    newBucket.next = cur.next;
                    cur.next.prev = newBucket;
                    cur.next = newBucket;
                    
                    stringNodeMap.put(key, newBucket);
                }
            }

            if(cur.keySet.size() == 0){
                removeNode(cur);
            }
        }
        else{
            Node firstBucket = head.next;
            if(firstBucket == tail || firstBucket.freq > 1){
                Node newBucket = new Node(1);
                newBucket.keySet.add(key);
                newBucket.prev = head;
                newBucket.next = head.next;
                head.next.prev = newBucket;
                head.next = newBucket;
                stringNodeMap.put(key, newBucket);
            }
            else{
                firstBucket.keySet.add(key);
                stringNodeMap.put(key, firstBucket);
            }
        }
    }
    
    public void dec(String key) {
        if(!stringNodeMap.containsKey(key)){
            return;
        }

        Node cur = stringNodeMap.get(key);
        cur.keySet.remove(key);
        if(cur.freq == 1){
            stringNodeMap.remove(key);
            
        }
        else{
            Node prev = cur.prev;
            if(prev == head || prev.freq != cur.freq - 1){
                Node newBucket = new Node(cur.freq - 1);
                newBucket.keySet.add(key);
                newBucket.prev = prev;
                newBucket.next = cur;
                prev.next = newBucket;
                cur.prev = newBucket;
                stringNodeMap.put(key, newBucket);
            }
            else{
                prev.keySet.add(key);
                stringNodeMap.put(key, prev);
            }
        }

        if(cur.keySet.isEmpty()) removeNode(cur);
    }
    
    public String getMaxKey() {
        if(tail.prev == head) return "";
        
        return tail.prev.keySet.iterator().next();
    }
    
    public String getMinKey() {
        if(head.next == tail) return "";

        return head.next.keySet.iterator().next();
    }

    private void removeNode(Node node){
        Node prev = node.prev;
        Node next = node.next;

        prev.next = next;
        next.prev = prev;
    }
}

class Node{ //bucket, it stores freq and strings at this freq
    int freq;
    Node prev;
    Node next;
    HashSet<String> keySet;
    
    Node(int freq){
        this.freq = freq;
        keySet = new HashSet<>();
    }
}

/**
 * Your AllOne object will be instantiated and called as such:
 * AllOne obj = new AllOne();
 * obj.inc(key);
 * obj.dec(key);
 * String param_3 = obj.getMaxKey();
 * String param_4 = obj.getMinKey();
 */