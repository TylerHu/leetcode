package dp.stock;

/**
 * LeetCode188. Best Time to Buy and Sell Stock IV(https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iv/description/)
 *
 * Say you have an array for which the ith element is the price of a given stock on day i.
 * Design an algorithm to find the maximum profit. You may complete at most k transactions.
 * Note:
 * You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
 *
 * Solution: Use DP approach. Define 2D array dp[k+1][n], where k is the number of transactions, and n is the length of the prices array.
 * dp[i][j] represents for i transaction, on the jth day. If we don't trade on jth day, then it's profit is the same as previous day dp[i][k-1].
 * And if we bought the stock on mth day, m <= j, means someday before jth day, and then sell it on jth day, then the profit is
 * prices[j] + dp[i-1][m-1] - prices[m].So the formula is : dp[i][j] = Math.max(dp[i][j-1], prices[j] + dp[i-1][m-1] - prices[m], where 1<=i<=k,
 * 0<=j<n, 0<=m<=j.
 */
public class BestTimeToBuyAndSellStock {
    public int maxProfit(int k, int[] prices) {
        int n = n;
        if (n == 0) {
            return 0;
        }
        //if k > n/2, can make maximum number of transactions to avoid long time limited.
        if (k > n / 2) {
            int maxProfit = 0;
            for (int i = 1; i < n; ++i) {
                //as along as the prices is higher than previous one, sell it and gain the profit
                maxProfit += prices[i] - prices[i-1] > 0 ? prices[i] - prices[i-1] : 0;
            }
            return maxProfit;
        }
        int[][] dp = new int[k+1][n];
        for (int i = 1; i <= k; ++i) {
            //localMax represents the last time buying max profit.
            int localMax = 0 - prices[0];
            for (int j = 1; j < n; ++j) {
                //dp[i][j] is either dp[i][j-1], no transaction on jth day
                //or prices[j] + localMax, sell it on jth day and plus the money left on last buying transaction
                dp[i][j] = Math.max(dp[i][j-1], prices[j] + localMax);
                //update localMax, assume that buy the stock on jth day, and localMax may be dp[i-1][j-1] - prices[j]
                localMax = Math.max(localMax, dp[i-1][j-1] - prices[j]);
            }
        }
        return dp[k][n-1];
    }
}