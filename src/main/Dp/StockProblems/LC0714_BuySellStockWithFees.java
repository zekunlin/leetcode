package Dp.StockProblems;

public class LC0714_BuySellStockWithFees {
    public int maxProfit(int[] prices, int fee) {
        int len = prices.length;
        int[] buy = new int[len];
        int[] sell = new int[len];

        buy[0] = -prices[0];

        for(int i = 1; i < len; i++){
            //buy: 1.if buy : prev sell[i-1] - cur prices[i]
            //     2.not buy: prev buy[i-1];
            buy[i] = Math.max(buy[i - 1], sell[i - 1] - prices[i]);

            //sell: 1. if sell: prev buy[i - 1] + prices[i] - fee;
            //        2. if not sell: prev sell[i-1] 
            sell[i] = Math.max(sell[i - 1], buy[i - 1] + prices[i] - fee);// fee
        }

        return sell[len - 1];
    }
}
