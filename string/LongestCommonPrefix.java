package string;

/**
 * LeetCode14. Longest Common Prefix(https://leetcode.com/problems/longest-common-prefix/description/)
 *
 * Write a function to find the longest common prefix string amongst an array of strings.
 * If there is no common prefix, return an empty string "".
 *
 * Solution: Init the common prefix with first string in the array, and check whether the index of first string
 * in other strings is zero, if not, remove the last character of first string, and continue.
 */
public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        int n = strs.length;
        if (n == 0) {
            return "";
        }
        String commonPrefix = strs[0];
        for (int i = 1; i < n; ++i) {
            while (strs[i].indexOf(commonPrefix) != 0) {
                commonPrefix = commonPrefix.substring(0, commonPrefix.length() - 1);
            }
            if (commonPrefix.length() == 0) {
                return "";
            }
        }
        return commonPrefix;
    }
}