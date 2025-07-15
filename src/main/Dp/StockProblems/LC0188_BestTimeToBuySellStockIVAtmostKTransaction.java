package Dp.StockProblems;

public class LC0188_BestTimeToBuySellStockIVAtmostKTransaction {
    public int maxProfit(int k, int[] prices) {
        if(prices.length == 0 || k == 0) return 0;
        int len = prices.length;
        int[][] buy = new int[k + 1][len];
        int[][] sell = new int[k + 1][len];

        for(int i = 1; i <= k; i++){
            buy[i][0] = -prices[0];
            sell[i][0] = 0; 

            for(int j = 1; j < len; j++){
                //for buy, i th transaction, at day j, depends on Max of: 
                // 1.not buy at day j, so buy at prior j - 1 day
                // 2.or buy at day j, so need to know the prior i-1 transaction, 
                //    at prior day j - 1 "SELL" as the profit, minus day j prices as the cost  
                buy[i][j] = Math.max(buy[i][j - 1], sell[i - 1][j - 1] - prices[j]);

                //for sell, ith transaction, at day j, depends on Max of:
                //1. not sell at day j, sell at prior j - 1 day, but same transacion i(same i because only buy after sell) 
                //2. sell at day j, so need the prior [i-1] transaction, at prior day j -1 "Buy" as the cost, plus day j prices as the profit
                sell[i][j] = Math.max(sell[i][j - 1], buy[i][j - 1] + prices[j]);
            }
        }

        return sell[k][len - 1];
    }
}
