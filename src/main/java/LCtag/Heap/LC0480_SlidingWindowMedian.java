package LCtag.Heap;

import java.util.PriorityQueue;

public class LC0480_SlidingWindowMedian {
    public double[] medianSlidingWindow(int[] nums, int k) {
        PriorityQueue<Long> minHeap = new PriorityQueue<>((o1, o2) -> Long.compare(o1, o2));
        PriorityQueue<Long> maxHeap = new PriorityQueue<>((o1, o2) -> Long.compare(o2, o1));

        int idx = 0;
        double[] res = new double[nums.length - k + 1];
        for(int i = 0; i < nums.length; i++){
            maxHeap.offer((long)nums[i]);
            minHeap.offer(maxHeap.poll());
            if(minHeap.size() - maxHeap.size() > 1) maxHeap.offer(minHeap.poll());

            if(minHeap.size() + maxHeap.size() == k){
                if(minHeap.size() == maxHeap.size()){
                    res[idx++] = (minHeap.peek() + maxHeap.peek()) / 2.0;
                }else{
                    res[idx++] = minHeap.peek() * 1.0;
                }

                if(!minHeap.remove((long)nums[idx - 1])) maxHeap.remove((long)nums[idx - 1]);//要remove的那个数不在minHeap的话，就在maxHeap里
            }
        }
        return res;
    }
}
