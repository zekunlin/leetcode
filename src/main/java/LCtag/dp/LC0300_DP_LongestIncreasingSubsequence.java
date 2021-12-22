package LCtag.dp;

public class LC0300_DP_LongestIncreasingSubsequence {
    public int lengthOfLIS(int[] nums) {
        //cc
        int[] dp = new int[nums.length];
        //dp[i]: i as the ending element longest increasing subsequence
        dp[0] = 1;
        int longestLen = 1;
        for(int i = 1; i < nums.length; i++){
            dp[i] = 1;
            for(int j = 0; j < i; j++){
                if(nums[i] > nums[j]){
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }

            }
            longestLen = Math.max(longestLen, dp[i]);
        }
        return longestLen;
    }
}
