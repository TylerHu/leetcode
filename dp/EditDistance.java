package dp;

/**
 * LeetCode72. Edit Distance(https://leetcode.com/problems/edit-distance/description/)
 *
 * Given two words word1 and word2, find the minimum number of operations required to convert word1 to word2.
 * You have the following 3 operations permitted on a word:
 *  Insert a character
 *  Delete a character
 *  Replace a character
 *
 *  Solution: Define a 2D dp array, dp[i][j] represents the minimum operations to convert the first i characters in word1 to
 *  first j characters in word2. And dp[i-1][j] represents delete a character from word1, dp[i][j-1] represents insert a character
 *  into word1, dp[i-1][j-1] represents replace a character in word1. Since the problem is symmetric, we can also choose the
 *  operations on word2. And the dp formula is dp = min(dp[i-1][j], dp[i][j-1], dp[i-1][j-1] + 1
 */
public class EditDistance {
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        //the size is (m+1)*(n+1)
        int[][] dp = new int[m+1][n+1];
        //here i <= m, m is included
        for (int i = 0; i <= m; ++i) {
            //here j <=n, n is included
            for (int j = 0; j <= n; ++j) {
                if (i == 0 && j == 0) {
                    //init the base dp to 0
                    dp[i][j] = 0;
                } else if (i == 0 && j != 0) {
                    //word1 is emtpy, have to add j characters into word1 to match word2
                    dp[i][j] = j;
                } else if (i != 0 && j == 0) {
                    //word2 is emtpy, have to delete i charcters from word1 to match word2
                    dp[i][j] = i;
                } else if (word1.charAt(i-1) == word2.charAt(j-1)) {
                    //two characters are the same, no extra operations needed
                    dp[i][j] = dp[i-1][j-1];
                } else {
                    //dp[i][j] = min(dp[i-1][j], dp[i][j-1], dp[i-1][j-1]) + 1
                    dp[i][j] = Math.min(Math.min(dp[i-1][j], dp[i][j-1]), dp[i-1][j-1]) + 1;
                }
            }
        }
        return dp[m][n];
    }
}