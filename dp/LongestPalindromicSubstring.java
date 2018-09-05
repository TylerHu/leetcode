package dp;

/**
 * LeetCode5. Longest Palindromic Substring(https://leetcode.com/problems/longest-palindromic-substring/description/)
 *
 * Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.
 *
 * Solution: Define 2D array dp, dp[i][j] = true means the substring of s between index i and index j is a palindrome string,
 * otherwise, it is not a palindrome string. if j - i < 3(the substring contains less than 3 characters), dp[i][j] depends
 * on whether the character at index i and character at index j are the same; if j - i >=3, then dp[i][j] not only depends
 * on whether the character at index i and character at index j are the same, but also depends on the result of it's previous
 * substring (i+1, j-1), that is dp[i+1][j-1].
 * So the dp formula is : dp[i][j] = s.charAt(i) == s.charAt(j) && (j - i < 3 || dp[i+1][j-1]);
 */

public class LongestPalindromicSubstring {

    public String longestPalindrome(String s) {
        String res = "";
        if (s == null || s.length() == 0) {
            return res;
        }
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        for (int i = n-1; i >= 0; --i) {
            for (int j = i; j < n; ++j) {
                dp[i][j] = s.charAt(i) == s.charAt(j) && (j - i < 3 || dp[i+1][j-1]);
                // if substring i to j is palindrome and the lenth of substring is larger than
                // the latest result, update the result
                if (dp[i][j] && (res == null || j - i + 1 > res.length())) {
                    res = s.substring(i, j+1);
                }
            }
        }
        return res;
    }

    //bottom-up solution
    public String longestPalindrome2(String s) {
        String res = null;
        int n = s.length();
        if (n == 0) {
            return "";
        }

        boolean[][] dp = new boolean[n][n];
        dp[0][0] = true;
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j <= i; ++j) {
                if (s.charAt(j) == s.charAt(i) && (i-j+1 < 3 || dp[i-1][j+1])) {
                    dp[i][j] = true;
                }
                if (dp[i][j] && (res == null || i-j+1 >= res.length())) {
                    res = s.substring(j,i+1);
                }
            }
        }
        return res;
    }

}