package Heap;
import java.util.*;

//Sol1: Time:O(nlogN), Space: O(N)
class MeetingRoomII{
    public int minMeetingRooms(int[][] intervals) {
        Arrays.sort(intervals, 
            new Comparator<int[]>() {
                public int compare(int[] a, int []b){
                    return a[0] - b[0];
                }
            }
        );
        
        Queue<Integer> pq = new PriorityQueue<>(
            new Comparator<Integer>() {
                public int compare(Integer a, Integer b){
                    return a-b;
                }
            }
        );

        pq.add(intervals[0][1]);

        for(int i = 1; i < intervals.length; i++){
            int[] curInterval = intervals[i];
            if(curInterval[0] >= pq.peek()){
                pq.poll();
            }
            pq.add(curInterval[1]);
        }

        return pq.size();
    }


    //sol2: Time: O(NlogN), Space: O(N)
    //create two arrays start time and end time
    //sort these two arrays
    //two pointers i,j starting at the two arrays beginning
    //when startTime[i] > endTime[j], means we have one interval start after the previous one ends
    // so num of meeting room -1, and move to the next end time(interval)
    // if startTime[i] < endTime[j], means we need an extra meeting room
    // numRoom +1, startIdx + 1 to the next interval
    public int MeetingRooms(int[][] intervals) {
        ArrayList<Integer> startTime = new ArrayList<>();
        ArrayList<Integer> endTime = new ArrayList<>();
        int roomNum = 0;
        for(int i = 0; i < intervals.length; i++){
            startTime.add(intervals[i][0]);
            endTime.add(intervals[i][1]);
        }

        Collections.sort(startTime);
        Collections.sort(endTime);

        int startIdx = 0;
        int endIdx = 0;

        while(startIdx < intervals.length){
            if(startTime.get(startIdx) >= endTime.get(endIdx)){
                roomNum -=1;
                endIdx += 1;
            }

            roomNum += 1;
            startIdx += 1;
        }
        return roomNum;
    }
}