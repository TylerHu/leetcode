package array;

/**
 * LeetCode121. Best Time to Buy and Sell Stock(https://leetcode.com/problems/best-time-to-buy-and-sell-stock/description/)
 *
 * Say you have an array for which the ith element is the price of a given stock on day i.
 * If you were only permitted to complete at most one transaction (i.e., buy one and sell one share of the stock), design an algorithm to find the maximum profit.
 * Note that you cannot sell a stock before you buy one.
 *
 * Solution: Keep track of the minimal price when iterating the array, and calcuate the profit when selling at each price. 
 */
public class BestTimeToBuyAndSellStock {
    if (prices.length == 0) {
        return 0;
    }
    //init the minPrice to first day price
    int minPrice = prices[0];
    int maxProfit = 0;
    for (int i = 1; i < prices.length; ++i) {
        //calculate the profit if sell the stock at price[i], and update the maxProfit
        maxProfit = Math.max(maxProfit, prices[i] - minPrice);
        //update the minPrice so far
        minPrice = Math.min(minPrice, prices[i]);
    }
    return maxProfit;
}