package Array;

import java.util.LinkedList;
import java.util.Queue;

class MovingAverage {
    int capacity;
    Queue<Integer> stream;
    double curSum;
    public MovingAverage(int size) {
        this.capacity = size;
        this.stream = new LinkedList<>();
        this.curSum = 0.0;
    }
    

    //time: O(M), when next is called M times
    //space: O(N), n is size;
    public double next(int val) {
        stream.offer(val);
        if(stream.size() > this.capacity){
            curSum -= stream.poll();
        }
        curSum += val;

        return curSum / stream.size();
    }
}
