package dp;

/**
 * LeetCode221. Maximal Square(https://leetcode.com/problems/maximal-square/description/)
 *
 * Given a 2D binary matrix filled with 0's and 1's, find the largest square containing only 1's and return its area.
 *
 * Solution: Use dp approcach. Define a 2D array dp. dp[i][j] represents the max length of the square whose lower-right corner
 * is located at matrix[i][j]. And dp[i][j] = min(dp[i-1][j], dp[i][j], dp[i-1][j-1]) + 1;
 */
public class MaximalSquare {
    public int maximalSquare(char[][] matrix) {
        int m = matrix.length;
        if (m == 0) {
            return 0;
        }
        int n = matrix[0].length;
        int squareLength = 0;
        int[][] dp = new int[m][n];
        //Since there is no upper row or left column of the first row and column, need to init the values first.
        for (int i = 0; i < m; ++i) {
            dp[i][0] = matrix[i][0] == '1' ? 1 : 0;
            squareLength = Math.max(squareLength, dp[i][0]);
        }

        for (int j = 0; j < n; ++j) {
            dp[0][j] = matrix[0][j] == '1' ? 1 : 0;
            squareLength = Math.max(squareLength, dp[0][j]);
        }

        for (int i = 1; i < m; ++i) {
            for (int j = 1; j < n; ++j) {
                if (matrix[i][j] == '1') {
                    dp[i][j] = Math.min(Math.min(dp[i-1][j], dp[i][j-1]), dp[i-1][j-1]) + 1;
                    //update the max length of the square
                    squareLength = Math.max(squareLength, dp[i][j]);
                }
            }
        }
        return squareLength * squareLength;
    }
}