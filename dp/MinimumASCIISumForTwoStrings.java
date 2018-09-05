package dp;

/**
 * LeetCode712. Minimum ASCII Delete Sum for Two Strings(https://leetcode.com/problems/minimum-ascii-delete-sum-for-two-strings/description/)
 *
 * Given two strings s1, s2, find the lowest ASCII sum of deleted characters to make two strings equal.
 *
 * Solution: Use dp approach, and define a 2D array dp. dp[i][j] represents the minimum sum cost to make s1.substring(0,i)
 * and s2.substring(0,j) equal. If current characters are equal, dp[i][j] = dp[i-1][j-1], if not,
 * dp[i][j] = min(dp[i-1][j] + s1.charAt(i-1), dp[i][j-1] + s2.charAt(j-1)) means either delete current character from
 * string s1 or delete character from string s2
 */
public class MinimumASCIISumForTwoStrings {
    ublic int minimumDeleteSum(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();
        int[][] dp = new int[n+1][m+1];
        for (int i = 1; i <= n; ++i) {
            //when s2 length is zero, dp[i][0] will be sum of s1 characters
            dp[i][0] = dp[i-1][0] + s1.charAt(i-1);
        }
        for (int j = 1; j <= m; ++j) {
            //when s1 length is zero, dp[0][j] will be sum of s2 characters
            dp[0][j] = dp[0][j-1] + s2.charAt(j-1);
        }
        for (int i = 1; i <= n; ++i) {
            for (int j = 1; j <= m; ++j) {
                if (s1.charAt(i-1) == s2.charAt(j-1)) {
                    //if current characters are the same, dp[i][j] = dp[i-1][j-1]
                    dp[i][j] = dp[i-1][j-1];
                } else {
                    //either delete from string s1, or delete from string s2, and get the minimum sum
                    dp[i][j] = Math.min(dp[i-1][j] + s1.charAt(i-1), dp[i][j-1] + s2.charAt(j-1));
                }
            }
        }
        return dp[n][m];
    }
}