package LCtag.dp;

public class LC0309_DP_BuySellStockCoolDown {
    class Solution {
        public int maxProfit(int[] prices) {
            //cc
            int len = prices.length;

            int[] buy = new int[len];
            int[] sell = new int[len];
            buy[0] = -prices[0];
            for(int i = 1; i < len; i++){
                buy[i] = Math.max(buy[i - 1], (i > 1)? sell[i - 2] - prices[i] : -prices[i]);
                sell[i] = Math.max(sell[i - 1], buy[i - 1] + prices[i]);
            }
            return sell[len - 1];
        }
    }
}
