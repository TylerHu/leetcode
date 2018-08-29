package dp;

/**
 * LeetCode279. Perfect Squares(https://leetcode.com/problems/perfect-squares/description/)
 *
 * Given a positive integer n, find the least number of perfect square numbers (for example, 1, 4, 9, 16, ...) which sum to n.
 *
 * Solution: Define a dp array, dp[i] represents the least number of perfect squares which sum to i (0<=i<=n).
 * dp[0] = 0, dp[1] = dp[0] + 1, dp[2] = dp[1] + 1, dp[3] = dp[2] + 1, dp[4] = Min(dp[4-1*1]+1, dp[4-2*2]+1)
 * dp[5] = Min(dp[5-1*1]+1, dp[5-2*2]+1), dp[i]=Min(dp[i-j*j]+1, j*j<=i)
 */
public class PerfectSquares {
    int[] dp = new int[n+1];
    dp[0] = 0;
    for (int i = 1; i <= n; ++i) {
        int min = Integer.MAX_VALUE;
        for (int j = 1; j * j <= i; ++j) {
            //dp[i] = min(dp[i-j*j]+1, j*j<=i)
            min = Math.min(min, dp[i-j*j]+1);
        }
        dp[i] = min;
    }
    return dp[n];
}