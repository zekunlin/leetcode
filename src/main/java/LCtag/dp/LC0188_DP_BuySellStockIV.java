package LCtag.dp;

public class LC0188_DP_BuySellStockIV {
    public int maxProfit(int k, int[] prices) {
        //cc
        if(prices.length == 0 || k == 0) return 0;
        int len = prices.length;
        int[][] buy = new int[k + 1][len];//dp buy
        int[][] sell = new int[k + 1][len];// dp sell
        for(int kk = 1; kk <= k; kk++){
            buy[kk][0] = -prices[0];
            sell[kk][0] = 0;
            for(int i = 1; i < len; i++){
                buy[kk][i] = Math.max(buy[kk][i - 1], (sell[kk - 1][i - 1] - prices[i]));
                sell[kk][i] = Math.max(sell[kk][i - 1], (buy[kk][i - 1] + prices[i]));
            }
        }
        return sell[k][len - 1];
    }
}
