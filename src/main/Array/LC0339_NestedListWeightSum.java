package Array;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import Common.NestedInteger;

public class LC0339_NestedListWeightSum {
    public int depthSum(List<NestedInteger> nestedList) {
        Queue<NestedInteger> q = new LinkedList<>(nestedList);

        int totalDepth = 0;
        int curDepth = 1;

        while(!q.isEmpty()){
            int qSize = q.size();
             
            for(int i = 0; i < qSize; i++){
                NestedInteger cur = q.poll();
                if(cur.isInteger()){
                    totalDepth += curDepth * cur.getInteger();
                }
                else{
                    q.addAll(cur.getList());
                }
            }
            curDepth++;
        }

        return totalDepth;
    }
}
