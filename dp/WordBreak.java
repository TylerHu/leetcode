package dp;

/**
 * LeetCode139. Word Break(https://leetcode.com/problems/word-break/description/)
 *
 * Given a non-empty string s and a dictionary wordDict containing a list of non-empty words, determine if s can be segmented
 * into a space-separated sequence of one or more dictionary words.
 *
 * Note:
 * The same word in the dictionary may be reused multiple times in the segmentation.
 * You may assume the dictionary does not contain duplicate words.
 *
 * Solution: Define a dp array, dp[i] represents whether substring from 0 to i-1 can be segmented by dict words. The length of the
 * dp array should be s.length()+1, since s.substring(j,i) does not include the ith character, and return dp[s.length()]. For each
 * character, check whether there is a way to separate the sequence into two parts (0,j-1), (j,i-1), both of these two sub sequence can be composed of
 * dict words.
 */
public class WordBreak {
    public boolean wordBreak(String s, List<String> wordDict) {
        if (s == null || s.length() == 0 || wordDict == null || wordDict.size() == 0) {
            return false;
        }
        //dp array, the length is s.length()+1
        boolean[] dp = new boolean[s.length()+1];
        //dp[0] represents empty string, so always true
        dp[0] = true;
        //note: i <= s.length(), since s.substring(j,i) does not include the ith character
        for (int i = 1; i <= s.length(); ++i) {
            for (int j = 0; j < i; ++j) {
                //check wheter (0,j-1) and (j,i-1) can both be composed of dict words
                if (dp[j] && wordDict.contains(s.substring(j,i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }
}