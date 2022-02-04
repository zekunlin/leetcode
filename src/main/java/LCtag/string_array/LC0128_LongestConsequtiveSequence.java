package LCtag.string_array;

import java.util.HashSet;
public class LC0128_LongestConsequtiveSequence {
    public int longestConsecutive(int[] nums){
        HashSet<Integer> set = new HashSet<>();
        for(int x : nums) set.add(x);
        int res = 0;
        for(int x : set){
            int count = 0;
            if(set.contains(x - 1) continue;
            while(set.contains(x)){
                count++;
                x++;
            }
            res = Math.max(count, res);
        }
        return res;
    }

}
