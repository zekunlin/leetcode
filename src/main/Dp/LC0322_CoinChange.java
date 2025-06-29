package Dp;
import java.util.*;

class CoinChange{
    //dfs + DP memoization
    //Time: O(A *n), A: amount, n: coins length, space: O(A)
    //Each amount is computed once and for each we try all n coins

    public int coinChange(int[] coins, int amount) {
        if(coins.length == 0) return -1;
        int[] memo = new int[amount + 1];
        Arrays.fill(memo, -1);
        int res = dfs(coins, amount, memo);
        return res == Integer.MAX_VALUE ? -1 : res;
    }

    public int dfs(int[] coins, int remaining, int[] memo){
        if(remaining == 0) return 0;
        if(remaining < 0) return Integer.MAX_VALUE;

        if(memo[remaining] != -1){
            return memo[remaining];
        }

        int min = Integer.MAX_VALUE;
        for(int coin : coins){
            int res = dfs(coins, remaining - coin, memo);
            if(res != Integer.MAX_VALUE){
                min = Math.min(min, res + 1);
            }
        }

        memo[remaining] = min;
        return min;
    }

    //dfs without dp memoization:
    /*
     * Let’s say:

A = amount

n = coins.length

Then for each amount, we try all n coins, and do this recursively until we reach 0.

🌲 This builds a recursion tree:
At each level, you branch out n times (once per coin).

The depth of the tree can go up to A (if smallest coin is 1, worst case).

So the TIME complexity is : O(n^A)

     */
    public int dfs(int[] coins, int remaining){
        if(remaining == 0) return 0;
        if(remaining <0) return Integer.MAX_VALUE;

        int min = Integer.MAX_VALUE;
        for(int coin : coins){
            int res = dfs(coins, remaining - coin);
            if (res != Integer.MAX_VALUE){
                min = Math.min(min, res + 1);
            }
        }
        return min;
    }
}