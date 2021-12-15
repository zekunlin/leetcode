package LCtag.dp;

public class LC0121_DP_BuySellStock {
    public int maxProfit(int[] prices) {
        //cc
        //if(prices.length == 1) return prices[0];

        int len = prices.length;
        int[] buy = new int[len];
        int[] sell = new int[len];
        sell[0] = 0;
        buy[0] = -prices[0];
        for (int i = 1; i < len; i++) {
            buy[i] = Math.max(buy[i - 1], -prices[i]);
            sell[i] = Math.max(sell[i - 1], buy[i - 1] + prices[i]);
        }
        return sell[len - 1];
    }
}
