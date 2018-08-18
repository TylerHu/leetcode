package array;

/**
 * LeetCode309. Best Time to Buy and Sell Stock with Cooldown
 * (https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/description/)
 *
 * Say you have an array for which the ith element is the price of a given stock on day i.
 * Design an algorithm to find the maximum profit. You may complete as many transactions as you like (ie, buy one and sell
 * one share of the stock multiple times) with the following restrictions: You may not engage in multiple transactions at the
 * same time (ie, you must sell the stock before you buy again). After you sell your stock, you cannot buy stock on next day.
 * (ie, cooldown 1 day)
 *
 * Solution: DP approach. Define two arrays, buy[i] and sell[i].
 * buy[i] represents the max profit till index i, and with the last transaction buy
 * sell[i] represents the max profit till index i, and with the last transaction sell
 * The decision of buy[i] depends on whether we take a rest and take the previous buy profit buy[i-1], or sell before[i-2] and then buy at i,
 * we cannot sell at i-1 and buy at i, because of the cool down.
 * The decision of sell[i] depends on wheter we take a rest and take the previous sell profit sell[i-1], or buy before[i-1] and sell at i.
 * So the formula is :
 * buy[i] = max(buy[i-1], sell[i-2]-price[i])
 * sell[i] = max(sell[i-1], buy[i-1]+price[i])
 * Let's define sell[i-2] as s2, sell[i-1] as s1, sell[i] as s0, buy[i-1] as b1, and buy[i] as b0 to optimize the space complexity to 0(1)
 */
public class BestTimeToBuyAndSellStockWithCooldown {
    public int maxProfit(int[] prices) {
        if (prices.length == 0) {
            return 0;
        }
        //init b0 and b1 to -prices[0]
        int b0 = -prices[0], b1 = -prices[0];
        int s0 = 0, s1 = 0, s2 = 0;
        for (int i = 1; i < prices.length; ++i) {
            b0 = Math.max(b1, s2-prices[i]);
            s0 = Math.max(s1, b1+prices[i]);
            b1 = b0;
            s2 = s1;
            s1 = s0;
        }
        return s0;
    }
}