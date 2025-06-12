package Heap;
import java.util.*;

public class AE_ContinuousMedian {
    double median = 0.0;

    Queue<Integer> minHeap = new PriorityQueue<>();
    Queue<Integer> maxHeap = new PriorityQueue<>(
        (a, b) -> b - a 
    );

    public void insert(int number){
        if(maxHeap.isEmpty() || number < maxHeap.peek()){
            maxHeap.add(number);
        }
        else{
            minHeap.add(number);
        }

        rebalance(minHeap, maxHeap);
        updateMedian();
    }

    private void rebalance(Queue<Integer> minHeap, Queue<Integer> maxHeap){
        if(minHeap.size() + 1 < maxHeap.size()){
            minHeap.add(maxHeap.poll());
        }else if(minHeap.size() > maxHeap.size()){
            maxHeap.add(minHeap.poll());
        }
    }

    private void updateMedian(){
        if(minHeap.size() == maxHeap.size()){
            median = minHeap.peek()/2.0 + maxHeap.peek()/2.0;
        }
        else{
            median = maxHeap.peek();
        }
    }
}
