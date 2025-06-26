package String;

import java.util.PriorityQueue;

class ReorganizaString {
    //1. count char frequency, by using char[26] charFreq, charFreq[i - 'a']++;
    //2. build maxHeap, put every char and freq in: pq.offer(new in[]{i + 'a', charFreq[a]})
    //3  build string:
    //     pop top
    //     append 1st pop when: pq is empty || sb end char is not the same as 1st pop
    //     if last append char is the same as the 1st pop, pop again, append 2nd pop, put the previous 1st pop back

    // Time: O(NlogK), but k is not bigger than 26, so fair to say tc is O(N);
    // Space: O(k)
    public String reorganizeString(String s) {
        char[] charFreq = new char[26];
        for(char c : s.toCharArray()){
            charFreq[c - 'a']++; 
        }
        
        //max heap
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>(
            (a, b) -> (b[1] - a[1])
        );

        for(int i = 0; i < 26; i++){
            if(charFreq[i] > 0){
                pq.offer(new int[]{i + 'a', charFreq[i]});
            }
        }

        //combose the string
        StringBuilder sb = new StringBuilder();

        while(!pq.isEmpty()){
            int[] top = pq.poll();
            if(sb.length() == 0 || sb.charAt(sb.length() - 1) != top[0]){
                sb.append((char)top[0]);
                top[1] = top[1] - 1;
                if(top[1] > 0){
                    pq.offer(top);
                }
            }else{
                if(pq.isEmpty()) return "";

                int[] secondTop = pq.poll();
                sb.append((char)secondTop[0]);
                secondTop[1] = secondTop[1] - 1;
                if(secondTop[1] > 0){
                    pq.offer(secondTop);
                }

                pq.offer(top);
            }
        }

        return sb.toString();
    }
}
