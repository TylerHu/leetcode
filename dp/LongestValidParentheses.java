package dp;

/**
 * Leetcode32. Longest Valid Parentheses(https://leetcode.com/problems/longest-valid-parentheses/)
 *
 * Given a string containing just the characters '(' and ')', find the length of the longest valid (well-formed)
 * parentheses substring.
 *
 */
public class LongestValidParentheses {
    public int longestValidParentheses(String s) {
        if (s == null || s.length() <= 1) {
            return 0;
        }
        int dp[] = new int[s.length()];
        int max = 0;
        for (int i = 1; i < s.length(); ++i) {
            if (s.charAt(i) == ')') {
                if (s.charAt(i-1) == '(') {
                    dp[i] = (i-2 >= 0) ? dp[i-2] + 2 : 2;
                    max = Math.max(max, dp[i]);
                } else {
                    //i-dp[i-1]-1 is the index of last character that not contains in "dp[i-1] valid substring".
                    //if character at i-dp[i-1]-1 is '(', then substring(i-dp[i-1]-1, i) can be a valid substring.
                    //also if characters before i-dp[i-1]-1, that is i-dp[i-1]-2, is another valid substring
                    //both these two substring can form a longer valid substring.
                    if (i-dp[i-1]-1 >= 0 && s.charAt(dp[i-dp[i-1]-1]) == '(') {
                        dp[i] = dp[i-1] + 2 + (i-dp[i-1]-2 >= 0 ? dp[i-dp[i-1]-2] : 0);
                        max = Math.max(max, dp[i]);
                    }
                }
            }
        }
        return max;
    }
}