package hashtable;

/**
 * LeetCode409. Longest Palindrome(https://leetcode.com/problems/longest-palindrome/description/)
 *
 * Given a string which consists of lowercase or uppercase letters, find the length of the longest palindromes that can be built with those letters.
 * This is case sensitive, for example "Aa" is not considered a palindrome here.
 *
 * Solution: Use hash set to store all the characters in the string. If character not exist in the set, add it to the set.
 * If the character is alreay exist in the set, remove it from the set, and increase count. At the end, return 2*count if
 * the set is empty, or 2*count+1 if the set is not empty.
 */
public class LongestPalindrome {
    public int longestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        Set<Character> set = new HashSet<>();
        int count = 0;
        for (char c : s.toCharArray()) {
            if (set.contains(c)) {
                set.remove(c);
                count++;
            } else {
                set.add(c);
            }
        }
        return set.isEmpty() ? count * 2 : count * 2 + 1;
    }
}