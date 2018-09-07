package string;

/**
 * LeetCode28. Implement strStr()(https://leetcode.com/problems/implement-strstr/description/)
 *
 * Return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
 *
 * Solution: Define two index i, j. Check whether haystack.charAt(i+j) == needle.charAt(j), and return index i
 */
public class ImplementStrStr {
    public int strStr(String haystack, String needle) {
        if (haystack == null || needle == null) {
            return -1;
        }
        if (needle.length() == 0) {
            return 0;
        }
        if (haystack.length() < needle.length()) {
            return -1;
        }
        for (int i = 0; i < haystack.length() - needle.length() + 1; ++i) {
            int j = 0;
            for (j = 0; j < needle.length(); ++j) {
                if (haystack.charAt(i+j) != needle.charAt(j)) {
                    break;
                }
            }
            if (j == needle.length()) {
                return i;
            }
        }
        return -1;

    }
}