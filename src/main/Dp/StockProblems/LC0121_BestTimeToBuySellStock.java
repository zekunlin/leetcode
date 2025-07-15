package Dp.StockProblems;

public class LC0121_BestTimeToBuySellStock {
    public int maxProfit(int[] prices) {
        int len = prices.length;
        int buy = -prices[0];
        int sell = 0;
        
        for(int i = 1; i < len; i++){
            int newBuy = Math.max(buy, -prices[i]);
            int newSell = Math.max(sell, buy + prices[i]);

            buy = newBuy;
            sell = newSell;
        }

        return sell;
    }
}
