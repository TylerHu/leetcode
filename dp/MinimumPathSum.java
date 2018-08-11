package dp;

/**
 * LeetCode64. Minimum Path Sum(https://leetcode.com/problems/minimum-path-sum/description/)
 * 
 * Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right which minimizes the
 * sum of all numbers along its path.
 * Note: You can only move either down or right at any point in time.
 *
 * Solution: Dp approach, since there is only two ways to get to point(i,j), one way is from it's upper point(i-1,j), the
 * other way is from it's left point(i, j-1). So we just need to know the minimum path between these two points. And this lead
 * to a dp solution, dp[i][j] = Math.min(dp[i-1][j], dp[i][j-1]) + grid[i][j].
 */
public class MinimumPathSum {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];
        dp[0][0] = grid[0][0];
        for (int i = 1; i < m; ++i) {
            dp[i][0] = dp[i-1][0] + grid[i][0];
        }
        for (int j = 1; j < n; ++j) {
            dp[0][j] = dp[0][j-1] + grid[0][j];
        }
        for (int i = 1; i < m; ++i) {
            for (int j = 1; j < n; ++j) {
                //get the minimum of it's left and upper point, and plus it's own value grid[i][j]
                dp[i][j] = Math.min(dp[i-1][j], dp[i][j-1]) + grid[i][j];
            }
        }
        return dp[m-1][n-1];
    }
}