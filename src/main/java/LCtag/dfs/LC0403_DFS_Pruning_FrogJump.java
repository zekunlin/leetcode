package LCtag.dfs;

import java.util.HashMap;

public class LC0403_DFS_Pruning_FrogJump {
    public boolean canCross(int[] stones) {
        //cc
        if(stones == null || stones.length <= 1) return false;
        if(stones[1] - stones[0] != 1) return false;
        HashMap<Integer, Boolean>[] memory = new HashMap[stones.length];
        for(int i = 0; i < stones.length; i++){
            memory[i] = new HashMap<>();
        }
        return dfsHelper(stones, memory, 1, 1);
    }

    private boolean dfsHelper(int[] stones, HashMap<Integer, Boolean>[] memory, int index, int step){
        //basecase
        if(index == stones.length - 1) return true;

        HashMap<Integer, Boolean> map = memory[index];
        Boolean status = map.get(step);
        if(status != null) return status;

        //fail
        if(step < 0 || index > 0 && stones[index] - stones[index - 1] > step || index >= stones.length) return false;
        boolean ret;
        for(int i = index + 1; i < stones.length; i++){
            int dist = stones[i] - stones[index];
            if(dist < step - 1) continue;
            if(dist > step + 1) break;
            ret = dfsHelper(stones, memory, i, dist);
            if(ret){
                memory[index].put(step, true);
                return true;
            }
        }
        memory[index].put(step, false);
        return false;
    }
}
