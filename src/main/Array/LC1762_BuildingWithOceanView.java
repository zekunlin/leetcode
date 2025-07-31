package Array;

import java.util.ArrayList;
import java.util.Collections;

public class LC1762_BuildingWithOceanView {
    //Time: O(N)
    //Space: O(N)
    public int[] findBuildings(int[] heights) {
        ArrayList<Integer> ans = new ArrayList<>();
        int len= heights.length; 
        int maxHeight = heights[len - 1];
        ans.add(len - 1);
        for(int idx = len - 2; idx >= 0; idx--){
            if(heights[idx] > maxHeight){
                ans.add(idx);
                maxHeight = heights[idx];
            }
        }

        Collections.reverse(ans);
        int[] ansArr = new int[ans.size()];
        for(int i = 0; i < ansArr.length; i++){
            ansArr[i] = ans.get(i);
        }
        return ansArr;
    }
}
