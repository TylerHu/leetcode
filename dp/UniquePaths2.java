package dp;

/**
 * LeetCode63. Unique Paths II(https://leetcode.com/problems/unique-paths-ii/description/)
 *
 * A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).
 * The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right
 * corner of the grid (marked 'Finish' in the diagram below).Now consider if some obstacles are added to the grids.
 * How many unique paths would there be?
 * An obstacle and empty space is marked as 1 and 0 respectively in the grid.
 *
 * Solution: This solution is similar to leetcode 62, except that we need to set dp[i][j] = 0 when there is an obstacle.
 * So the formula is : dp[i][j] = obstacleGrid[i][j] == 1 ? 0 : (dp[i-1][j] + dp[i][j-1])
 */
public class UniquePaths2 {

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] dp = new int[m][n];
        dp[0][0] = obstacleGrid[0][0] == 1 ? 0 : 1;
        for (int i = 1; i < m; ++i) {
            //if current element is obstacle, set dp to 0, otherwise set dp to its upper value
            dp[i][0] = obstacleGrid[i][0] == 1 ? 0 : dp[i-1][0];
        }
        for (int j = 1; j < n; ++j) {
            //if current element is obstacle, set dp to 0, otherwise set dp to its left value
            dp[0][j] = obstacleGrid[0][j] == 1 ? 0 : dp[0][j-1];
        }
        for (int i = 1; i < m; ++i) {
            for (int j = 1; j < n; ++j) {
                //if current element is obstacle, set dp to 0
                //otherwise dp is the sum of its left and upper value
                dp[i][j] = obstacleGrid[i][j] == 1 ? 0 : (dp[i-1][j] + dp[i][j-1]);
            }
        }
        return dp[m-1][n-1];
    }
}