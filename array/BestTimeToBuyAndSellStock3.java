package array;

/**
 * LeetCode123. Best Time to Buy and Sell Stock III(https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iii/description/)
 *
 * Say you have an array for which the ith element is the price of a given stock on day i.
 * Design an algorithm to find the maximum profit. You may complete at most two transactions.
 * Note: You may not engage in multiple transactions at the same time (i.e., you must sell the stock before you buy again).
 *
 * Solution: Define four variables,
 * buy1 represents the maximal profit when buy the first stock, Since when buy the first stock, we don't have money, buy1 = max(buy1, -price)
 * sell1 represents the maximal profit when sell the first stock, which is price - |buy1|, and buy1 is negative, so sell1 = max(sell1, buy1+price)
 * buy2 represents the maximal profit when buy the second stock, buy2 = max(buy2, sell1-price)
 * sell2 represents the maximal profit when sell the second stock, sell2 = max(sell2, buy2+price), and sell2 is the final maximal profit to the question
 * so,
 */
public class BestTimeToBuyAndSellStock3 {
    public int maxProfit(int[] prices) {
        int buy1 = Integer.MIN_VALUE, sell1 = 0, buy2 = Integer.MIN_VALUE, sell2 = 0;
        for(int price : prices) {
            //buy1 represents the maximal profit when buy the first stock
            buy1 = Math.max(buy1, -price);
            //sell1 represents the maximal profit when sell the first stock
            sell1 = Math.max(sell1, buy1+price);
            //buy2 represents the maximal profit when buy the second stock
            buy2 = Math.max(buy2, sell1-price);
            //sell2 represents the maximal profit when sell the second stock
            sell2 = Math.max(sell2, buy2+price);
        }
        return sell2;
    }
}