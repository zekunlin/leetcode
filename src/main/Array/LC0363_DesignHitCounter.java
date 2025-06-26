package Array;
import java.util.*;

import Common.Pair;

class HitCounter {
    Queue<Integer> timeHitq;
    public HitCounter() {
        timeHitq = new LinkedList<>();
    }
    
    public void hit(int timestamp) {
        timeHitq.add(timestamp);
    }
    
    public int getHits(int timestamp) {
        while(!timeHitq.isEmpty()){
            int diff = timestamp - timeHitq.peek();
            if(diff >=300) timeHitq.remove();
            else break;
        }
        return timeHitq.size();
    }
}

//sol2: use dequeue
class HitCounterDequeue {
    private int total;
    private Deque<Pair<Integer, Integer>> hits;

    public HitCounterDequeue() {
        hits = new LinkedList<>();
    }
    
    public void hit(int timestamp) {
        if(this.hits.isEmpty() || this.hits.getLast().getKey() != timestamp){
            this.hits.add(new Pair<Integer, Integer>(timestamp, 1));
        }
        else
        {
            int prevCount = hits.getLast().getValue();
            hits.removeLast();
            hits.add(new Pair<Integer, Integer>(timestamp, prevCount + 1));
        }
        total += 1;
    }
    
    public int getHits(int timestamp) {
        while(!hits.isEmpty()){
            int diff = timestamp - hits.getFirst().getKey();
            if(diff >= 300){
                total -= hits.getFirst().getValue();
                hits.removeFirst();
            }
            else{
                break;
            }
        }
        return total;
    }
}

/**
 * Your HitCounter object will be instantiated and called as such:
 * HitCounter obj = new HitCounter();
 * obj.hit(timestamp);
 * int param_2 = obj.getHits(timestamp);
 */

/**
 * Your HitCounter object will be instantiated and called as such:
 * HitCounter obj = new HitCounter();
 * obj.hit(timestamp);
 * int param_2 = obj.getHits(timestamp);
 */
