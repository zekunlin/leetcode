package Recursion;
import java.util.*;


class ClimbingStairs {
    public int climbStairs(int n) {
        HashMap<Integer, Integer> memo = new HashMap<>();
        return backtrack(n, memo, 0);
    }

    public int backtrack(int n, HashMap<Integer, Integer> memo, int track){
        if(track == n) return 1;
        if(track > n) return 0;

        if(memo.containsKey(track)) return memo.get(track);

        int ways = backtrack(n, memo, track + 1) + backtrack(n, memo, track + 2);
        memo.put(track, ways);
        return ways;
    }

    public int climbStairsDP(int n){
        if(n == 1) return 1;

        int[] dp = new int[n + 1];

        dp[1] = 1;
        dp[2] = 2;
        for(int i = 3; i <= n; i++){
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
}
