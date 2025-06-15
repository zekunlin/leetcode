package LinkedList;

import Common.DoubleLinkedListNode;
import java.util.*;

class LRUCache<T>{
    /* 
     considering the requirements:
     1. Constant time to InsertKeyValuePair
     2. Constant time to retrieve key's value with getValueFromKey
     3. Retrieve the most recently used key with getMostRecentKey
     4. cache has capacity limit: maxSize, when inserting a key with maxSize
        reached, evict the least recently used key-value pair
     5. insert a key-value pair with existing key should replace the existing one
     6. retrieve a key that not in the cache should return null
     */

     /*
     so use hashmap to store kv, this help use retrieve and insert kv pair with O(1) time

     */

     // LRU cahces: really just moving pointers, adding values

   int capacity;

   DoubleLinkedListNode head;
   
   DoubleLinkedListNode tail;

   Map<Integer, DoubleLinkedListNode> cache; 

   public LRUCache(int maxSize){
      this.capacity = maxSize;

      cache = new HashMap<Integer, DoubleLinkedListNode>();
      // here create two dummy nodes
      // when removing the least used nodes, it should be tail.prev
      // and most used nodes is the head.next
      this.head = new DoubleLinkedListNode(0, 0);
      this.tail = new DoubleLinkedListNode(0, 0);
      this.head.next = tail;
      this.tail.prev = head;
   }

   public void put(int key, int value){
      /* 
         check if the key exists in the cache
         if exists, replace
         if not exists:
            a. add new key-value pair
            b. move the new added pair node to front
            c. check if exceed capacity, if yes evict tail.prev
      */

      if(cache.containsKey(key))
      {
         DoubleLinkedListNode node = cache.get(key);
         node.val = value;
         moveToHead(node);
      }
      else
      {
         DoubleLinkedListNode node = new DoubleLinkedListNode(key, value);
         cache.put(key, node);
         addToFront(node);
      }

      if(cache.size() > capacity){
         evictLRU();
      }
   }

   public int get(int key){
      /*
       return the most recent cache object
       */
      if(!cache.containsKey(key)) return -1;
      
      DoubleLinkedListNode node = cache.get(key);

      moveToHead(node);
      return this.head.next.val;
   }

   public int getMostRecent(){
      return this.head.next.val;
   }

   private void moveToHead(DoubleLinkedListNode node){
      this.remove(node);
      this.addToFront(node);
   }

   private void addToFront(DoubleLinkedListNode node){
      node.next = head.next;
      head.next.prev = node;
      head.next = node;
      node.prev = head;
   }

   private void remove(DoubleLinkedListNode node){
      node.next.prev = node.prev;
      node.prev.next = node.next;
   }

   private void evictLRU()
   {
      DoubleLinkedListNode lruNode = tail.prev;
      remove(lruNode);
      cache.remove(lruNode.key);
   }
}