package Intervals;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class LC0056_MergeInterval {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a,b)->(a[0] - b[0]));//sort on start
        
        List<int[]> res = new LinkedList<>();
        int[] prev = {intervals[0][0], intervals[0][1]};

        for(int i = 1; i < intervals.length; i++)
        {
            int[] cur = intervals[i];
            
            //prev ends after cur
            if(prev[1] >= cur[0])
            {
                //pick the larget one for merged end
                prev[1] = Math.max(prev[1], cur[1]);
            }
            else
            {
                //no overlap, just add
                res.add(prev);
                prev = cur;
            }
        }
        
        res.add(prev);
        return res.toArray(new int[res.size()][]);        
    }
}
