package Dp;

import java.util.Arrays;

public class LC0198_HouseRobber {
    //sol1: recursion + memo
    //Time: O(N), Space: O(N)
    public int rob(int[] nums) {
        int[] memo = new int[nums.length];
        Arrays.fill(memo, -1);
        return recursion(nums, 0, memo);
    }

    public int recursion(int[] arr, int idx, int[] memo){
        if(idx >= arr.length) return 0;
        if(memo[idx] != -1) return memo[idx];

        int take = arr[idx] + recursion(arr, idx + 2, memo);
        int skip = recursion(arr, idx + 1, memo);
        int max = Math.max(take, skip);
        memo[idx] = max;
        return max;
    }
}
