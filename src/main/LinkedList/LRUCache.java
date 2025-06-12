package LinkedList;

class LRUCache{
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
}