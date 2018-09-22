package hashtable;

/**
 * LeetCode242. Valid Anagram(https://leetcode.com/problems/valid-anagram/description/)
 *
 * Given two strings s and t , write a function to determine if t is an anagram of s.
 *
 * You may assume the string contains only lowercase alphabets.
 *
 * Solution: Since only contains lowercase alphabets, we could define an array with size 26 to store the number of each character
 * in these two string. If s and t are anagram, all the number in this array should be zero. Another solution is to sort
 * these two string, if they are anagram, the result of the sorting should be the same.
 */
public class ValidAnagram {
    public boolean isAnagram(String s, String t) {
        int[] counter = new int[26];
        int n = s.length();
        if (t.length() != n) {
            return false;
        }
        for (int i = 0; i < n; ++i) {
            //appear in string s, increase
            counter[s.charAt(i) - 'a']++;
            //appear in string t, decrease
            counter[t.charAt(i) - 'a']--;
        }
        for (int i = 0; i < 26; ++i) {
            if (counter[i] != 0) {
                return false;
            }
        }
        return true;
    }

    public boolean isAnagram2(String s, String t) {
        char[] sc = s.toCharArray();
        char[] tc = t.toCharArray();
        Arrays.sort(sc);
        Arrays.sort(tc);
        return new String(sc).equals(new String(tc));
    }
}