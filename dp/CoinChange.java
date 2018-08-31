package dp;

/**
 * LeetCode322. Coin Change(https://leetcode.com/problems/coin-change/description/)
 *
 * You are given coins of different denominations and a total amount of money amount. Write a function to compute the
 * fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any combination of the coins, return -1.
 *
 * Solution: For each coin, if we take that coin into account, then the fewest number of coins we can get for amount is dp[i-coin]+1,
 * so the formula is dp[i] = Math.min(dp[i], dp[i-coin]+1)
 * number of
 */
public class CoinChange {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount+1];
        //init the dp array with impossible value
        Arrays.fill(dp, amount+1);
        //init dp[0] to 0, because no money given
        dp[0] = 0;
        for (int coin : coins) {
            for (int i = 1; i <= amount; ++i) {
                if (i >= coin) {
                    //take current coin into account
                    dp[i] = Math.min(dp[i], dp[i-coin] + 1);
                }
            }
        }
        //if dp > amount, means not found, return -1, otherwise, return dp
        return dp[amount] > amount ? -1 : dp[amount];

    }
}