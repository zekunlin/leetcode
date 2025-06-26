package Dp;

class JumpGame {
    // dfs, Time: O(2^N); Space: O(N)
    public boolean canJump(int[] nums) {
        if(nums.length == 0) return true;
        Boolean[] memo = new Boolean[nums.length];
        return dfs(nums, 0, memo);
    }

    public boolean dfs(int[] nums, int idx, Boolean[] memo){
        if(idx == nums.length - 1) return true;
        if(memo[idx] != null) return memo[idx];

        int curCanJump = nums[idx];
        for(int i = 1; i <= curCanJump; i++){
            if(dfs(nums, idx + i, memo)){
                memo[idx] = true;
                return true;
            }
        }
        memo[idx] = false;
        return false;
    }


    // dp: Time : O(n^2), Space: O(N)
    public boolean canJumpSol2(int[] nums){
        int len = nums.length;
        Boolean[] memo = new Boolean[len];
        memo[len - 1] = true;
        
        for(int i = len - 2; i >= 0; i--){
            int furthestJump = Math.min(i + nums[i], len - 1);
            for(int j = i + 1; j <= furthestJump; j++){
                if(memo[j] != null && memo[j] == true){
                    memo[i] = true;
                    break;
                }
                else{
                    memo[j] = false;
                }
            }
        }

        return memo[0]!= null && memo[0] == true;
    }

    //greedy sol: Time: O(N), space: O(1)
    public boolean canJumpSol3(int[] nums){
        int goal = nums.length - 1;
        for (int i = nums.length - 2; i >= 0; i--) {
            if (i + nums[i] >= goal) {
                goal = i;
            }
        }
        return goal == 0;
    }
}
