package dp;

/**
 * LeetCode647. Palindromic Substrings(https://leetcode.com/problems/palindromic-substrings/description/)
 *
 * Given a string, your task is to count how many palindromic substrings in this string.
 * The substrings with different start indexes or end indexes are counted as different substrings even they consist of same characters.
 *
 * Solution: Iterate through the string, for each character, check whether there are palindromic substrings whose middle point is character
 * i. There are some difference between odd length palindromic substring and even length palindromic substring, so we need to check
 * odd length palindromic and even length palindromic respectively.
 */
public class PalindromicSubstring {
    int count = 0;
    public int countSubstrings(String s) {
        for (int i = 0; i < s.length(); ++i) {
            checkPalindrome(s, i, i); //check odd length palindromic substring
            checkPalindrome(s, i, i+1); //check even length palindromic substring
        }
        return count;
    }

    public void checkPalindrome(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            count++;
            left--;
            right++;
        }
    }
}