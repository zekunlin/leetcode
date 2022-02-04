package LCtag.Heap;

import java.util.PriorityQueue;

public class LC0871_MinimumNumberOfRefuelingStops {
    public int minRefuelStops(int target, int startFuel, int[][] stations) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> o2 - o1);

        int curFuel = startFuel;
        int idx = 0;
        int count = 0;
        while(idx < stations.length){
            if(curFuel >= stations[idx][0]){
                pq.offer(stations[idx][1]);
                idx++;
            }else{
                while(!pq.isEmpty() && curFuel < stations[idx][0]){
                    curFuel += pq.poll();
                    count++;
                }
                if(curFuel < stations[idx][0]) return -1;
            }
        }

        if(curFuel < target){
            while(!pq.isEmpty() && curFuel < target){
                curFuel += pq.poll();
                count++;
            }
        }
        if(curFuel < target) return -1;
        return count;
    }
}
