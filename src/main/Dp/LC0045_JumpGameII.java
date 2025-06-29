package Dp;

import java.util.Arrays;

public class LC0045_JumpGameII {
    //sol1: Recursion + memoization
    //Time: O(N^2) , space: O(N)
    // why O(N^2)?  consider an array full of[n, n, ...,n]
    // each position can jump to end,  so for loop will have to jump n times for each location 
    public int jump(int[] nums) {
        if(nums.length == 0) return 0;
        int[] memo = new int[nums.length];
        Arrays.fill(memo, -1);

        return dfs(nums, 0, memo);
    }

    public int dfs(int[] nums, int idx, int[] memo){
        if(idx >= nums.length - 1){
            memo[idx] = 0;
            return 0;
        }

        if(memo[idx] != -1) return memo[idx]; 
        
        int curJump = nums[idx];
        int curMinSteps = Integer.MAX_VALUE;
        for(int i = 1; i <= curJump; i++){
            int nextIdx = i + idx;
            if(nextIdx < nums.length){
                int steps = dfs(nums, nextIdx, memo);
                if(steps != Integer.MAX_VALUE){
                    curMinSteps = Math.min(curMinSteps, steps + 1);
                }
            }
        }
        memo[idx] = curMinSteps;
        return curMinSteps;
    }

    //sol2: Greedy, every position, try jump as far as possible.
    //  maintain a range of: from cur pos i, the farthest idx can be reached from i by try every pos in cur step
    // loop the range, find the furthest position from cur step can reach, that's the end position for next jump
    // Time: O(N), space: O(1)
    public int jumpGreedy(int[] nums) {
        if(nums.length == 0) return 0;
        int curEndIdx = 0;
        int endIdxForNextJump = 0;
        int minStep = 0;
        
        for(int i = 0; i < nums.length - 1; i++){
            // in cur loop, try go as far as possible, 
            // the furthest pos is the start point of next jump
            endIdxForNextJump = Math.max(endIdxForNextJump, i + nums[i]);
            
            // reach the end of cur jump, step + 1, we are going in next jump.
            // but before going in next jump, set the furthest idx that next jump can reach
            // which is endIdxForNextJump we got from cur loop
            if(i == curEndIdx){
                minStep++;
                curEndIdx = endIdxForNextJump;
            }
        }
        return minStep;
    }
}
