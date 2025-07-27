import java.util.*;


/*HashMap:
key  ->  idx  ->  Bucket[Pair<K,V>]  ->  K-V pair
1.hashFunc O(1) convert key to get idx to locate Buckets in an Array;
2.buckets contains size k of K-V pairs, then use equals compare the key from hashFunc, 
  O(K) time to get a K-V pair in one bucket;

Goal: reduce bucket size to reduce K
How? 
1.items as even as possible in each bucket: hash function: hashCode() && equals()
2.enough number of buckets: rehashing (cur size * 2), when reached 0.75 cur load

hashCode & equals are tightly related, override hashCode must also override equals, 
because the key is used to index the bucket from bucket array, 
the key from hashFunc also used to find the K-V pair in the indexed bucket
*/

class MyHashMap {
    int capacity;
    private static final double LOAD_FACTOR = 0.75d;
    private int size;
    List<Pair>[] buckets;
    public MyHashMap() {
        this.capacity = 256;
        this.size = 0;
        this.buckets = new ArrayList[this.capacity];
    }
    
    private int hashFunc(Integer key){
        if(key == null) return 0;
        return Math.abs(key.hashCode() % this.capacity);
    }

    public void put(int key, int value) {
        int idx = this.hashFunc(key);
        if(buckets[idx] == null){
            this.buckets[idx] = new ArrayList<>();
        }

        List<Pair> curBucket = this.buckets[idx];
        for(Pair pair : curBucket){
            if(pair.getKey().equals(key)){
                pair.setVal(value);
                return;
            }
        }

        curBucket.add(new Pair(key, value));
        this.size++;
        if(this.size / this.capacity >= LOAD_FACTOR) this.rehashing();
    }
    
    public int get(int key) {
        int idx = this.hashFunc(key);
        if(buckets[idx] == null) return -1;

        List<Pair> curBucket = buckets[idx];
        for(Pair pair : curBucket){
            if(pair.getKey().equals(key)){
                return pair.getVal();
            }
        }

        return -1;
    }
    
    public void remove(int key) {
        int idx = this.hashFunc(key);

        if(buckets[idx] == null) return;

        List<Pair> curBucket = buckets[idx];
        int i = 0;
        for(Pair pair : curBucket){
            if(pair.getKey().equals(key)){
                break;
            }

            i++;
        }

        if(i < curBucket.size()){
            Pair last = curBucket.get(curBucket.size() - 1);
            curBucket.get(i).setVal(last.getVal());
            curBucket.get(i).setKey(last.getKey());
            curBucket.remove(curBucket.size() - 1);
            this.size--;
        }
    }

    private void rehashing(){
        this.capacity *=2;
        List<Pair>[] newBuckets = new ArrayList[this.capacity];

        for(List<Pair> bucket : this.buckets){
            if(bucket == null) continue;
            for(Pair pair : bucket){
                int idx = this.hashFunc(pair.key);
                if(newBuckets[idx] == null){
                    newBuckets[idx] = new ArrayList<Pair>();
                }
                newBuckets[idx].add(pair);
            }
        }

        this.buckets = newBuckets;
    }
}

class Pair{
    Integer key;
    Integer val;
    public Pair(Integer key, Integer val){
        this.key = key;
        this.val = val;
    }

    @Override
    public int hashCode(){
        return this.key == null ? 0 : this.key.hashCode();
    }

    public boolean keyEquals(Integer key){
        if(this.key == null) return key == null;
        return this.key.equals(key);
    }

    public void setVal(Integer val){
        this.val = val;
    }

    public Integer getVal(){
        return this.val;
    }

    public Integer getKey(){
        return this.key;
    }

    public void setKey(Integer key){
        this.key = key;
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */
// class MyMap<K, V>{
//     private static final double LOAD_FACTOR = 0.75d;
//     private int capacity;
//     private int size;
//     private List<Pair<K, V>>[] buckets;

    
//     public MyMap(){
//         this.capacity = 256;
//         this.size = 0;
//         this.buckets = new ArrayList[capacity];
//     }

//     private int hashFunc(K key){
//         if(key == null ) return 0;
//         return Math.abs(key.hashCode() % capacity);
//     }
//     public boolean put(K key, V val){
//         int idx = this.hashFunc(key);
        
//         if(buckets[idx] == null){
//             buckets[idx] = new ArrayList<Pair<K, V>>();
//         }

//         for(Pair<K, V> pair : buckets[idx]){
//             if(pair.keyEquals(key)){
//                 pair.setVal(val);
//                 return false; // update
//             }
//         }

//         buckets[idx].add(new Pair(key, val));
//         return true;
//     }

//     public V get(K key){
//         int idx = this.hashFunc(key);
//         if(buckets[idx] == null){
//             return null;
//         }
//         else{
//             for(Pair<K, V> pair : buckets[idx]){
//                 if(pair.keyEquals(key)){
//                     return pair.getVal();
//                 }
//             }
//             return null;
//         }
//     }

//     public boolean remove(K key){
//         int idx = this.hashFunc(key);

//         if(buckets[idx] == null) return false;
//         else{
//             int i = 0;
//             for( Pair<K, V> pair : buckets[idx]){
//                 if(pair.keyEquals(key)){
//                     break;
//                 }
//                 i++;
//             }

//             if(i < buckets[idx].size()){
//                 Pair<K, V> last = buckets[idx].get(buckets[idx].size() - 1);
//                 buckets[idx].get(i).setKey(last.getKey());
//                 buckets[idx].get(i).setVal(last.getVal());
//                 buckets[idx].remove(buckets[idx].size() - 1);
//                 return true;
//             }
//         }

//         return false;
//     }
// }

// class Pair<K, V>{
//     private K key;
//     private V val;
//     public Pair(K key, V val){
//         this.key = key;
//         this.val = val;
//     }

//     public boolean keyEquals(K key){
//         if(this.key == null) return key == null;
//         return this.key.equals(key);
//     }

//     public void setVal(V val){
//         this.val = val;
//     }

//     public V getVal(){
//         return this.val;
//     }

//     public K getKey(){
//         return this.key;
//     }

//     public void setKey(K key){
//         this.key = key;
//     }
// }