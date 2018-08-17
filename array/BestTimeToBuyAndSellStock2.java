package array;

/**
 * LeetCode122. Best Time to Buy and Sell Stock II(https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/description/)
 *
 * Say you have an array for which the ith element is the price of a given stock on day i.
 * Design an algorithm to find the maximum profit. You may complete as many transactions as you like (i.e., buy one and sell one share of the
 * stock multiple times).
 * Note: You may not engage in multiple transactions at the same time (i.e., you must sell the stock before you buy again).
 *
 * Solution: Just sum all the current profit together. If prices[i] less than prices[i-1], set current profit to zero.
 */
public class BestTimeToBuyAndSellStock2 {
    int maxProfit = 0;
    for (int i = 1; i < prices.length; ++i) {
        //if prices[i] < prices[i-1], set current profit to zero
        maxProfit += prices[i] > prices[i-1] ? prices[i] - prices[i-1] : 0;
    }
    return maxProfit;
}