package LCtag.dp;

public class LC0070_dp_climbingStairs {
    class Solution {
        public int climbStairs(int n) {
            //cc
            if(n == 1) return n;
            int[] dp = new int[n];
            dp[0] = 1;
            dp[1] = 2;
            for(int i = 2; i < n; i++){
                dp[i] = dp[i - 1] + dp[i - 2];
            }
            return dp[n - 1];
        }
    }
}
