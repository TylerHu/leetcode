package dp;

/**
 * LeetCode62. Unique Paths
 *
 * A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).
 * The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid
 * (marked 'Finish' in the diagram below). How many possible unique paths are there?
 *
 * Solution: This is a typical dp problem, define a 2D array dp represents the possible paths to point(i,j).
 * Obviously, dp[0][0] is 1, and the points in the first row and first column all have only one way to get there.
 * To point(i,j), there are two ways to get there, from the left point(i,j-1) and remove one step right, or from
 * the upper point(i-1, j) move one step down. So the dp formula is: dp[i][j] = dp[i-1][j] + dp[i][j-1];
 *
 * Another Solution: This problem can also be solved by using math formula.
 * There are j = m + n - 2 steps to get to the finishing point, and k = m - 1 steps to get right to get to the finishing point.
 * So the Combination(j,k) = j!/k!(j-k)! = (j-k+1)(j-k+2)*..*j/k!
 */
public class UniquePath {

    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        dp[0][0] = 1;
        for (int i = 0; i < m; ++i) {
            //the first column has only one way
            dp[i][0] = 1;
        }
        for (int j = 0; j < n; ++j) {
            //the first row has only one way
            dp[0][j] = 1;
        }
        for (int i = 1; i < m; ++i) {
            for (int j = 1; j < n; ++j) {
                dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }
        return dp[m-1][n-1];
    }


    public int uniquePaths2(int m, int n) {
        int j = m + n - 2; // total steps to get to the end
        int k = m - 1; // right steps to get to the end
        double res = 1;
        for (int i = 1; i <= k;  ++i) {
            res = res * (j-k+i) / i;
        }
        return (int) res;
    }

}