package dp;

/**
 * LeetCode91. Decode Ways(https://leetcode.com/problems/decode-ways/description/)
 *
 * A message containing letters from A-Z is being encoded to numbers using the following mapping:
 * 'A' -> 1
 * 'B' -> 2
 * ...
 * 'Z' -> 26
 *
 * Given a non-empty string containing only digits, determine the total number of ways to decode it.
 *
 * Solution: Define an array dp, dp[i] represents the total number of ways to decode substring(0,i). When doing the ierating,
 * check whether current character is larger than 0, if so, and check whether the previous character is larger than 0 and
 * substring(i-1,i) if less than 26, if all this conditions matched, dp[i] = dp[i-1]+dp[i-2].
 * If current character equals to 0, and the previous character is larger than 0 and substring(i-1, i) is less than 26, then
 * dp[i] = dp[i-2].
 */
public class DecodeWays {
    public int numDecodings(String s) {
        int n = s.length();
        if (n == 0) {
            return 0;
        }
        int[] dp = new int[n];
        dp[0] = s.charAt(0) == '0' ? 0 : 1;
        for (int i = 1; i < s.length(); ++i) {
            if (s.charAt(i) > '0') {
                //if current character is larger than 0, dp[i] = dp[i-1] or dp[i-1]+dp[i-2], so set dp[i-1] to dp[i] first
                dp[i] = dp[i-1];
            }
            if (s.charAt(i-1) > '0' && ((s.charAt(i-1) - '0') * 10 + (s.charAt(i) - '0') <= 26)) {
                //if previouse character is larger than 0, and substring(i-1,i) is less than or equal to 26
                //dp[i] = dp[i-1]+dp[i-2]
                //check i-2 >>0 to deal with the corner case i==1
                dp[i] += i-2 >= 0 ? dp[i-2] : 1;
            }
        }
        return dp[n-1];
    }
}