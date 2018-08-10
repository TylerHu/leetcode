/**
 * Leetcode3. Longest Substring Without Repeating Characters(https://leetcode.com/problems/longest-substring-without-repeating-characters/description/)
 *
 * Given a string, find the length of the longest substring without repeating characters.
 * Examples:
 * Given "abcabcbb", the answer is "abc", which the length is 3.
 * Given "bbbbb", the answer is "b", with the length of 1.
 * Given "pwwkew", the answer is "wke", with the length of 3. Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
 *
 * Solution: The basic idea is use a hashmap to store the index of each charater in the string. Use charater in the string as key, as use it's index as value.
 * Define two pointers i, j. Pointer i will always move forward by one step to iterate the string, j will store the index of the last unrepeated substring.
 * So, i is the end of the substring, and j is the start of the substring, the length will be i - j + 1;
 */

public class LongestSubstringWithoutRepeatedCharacter {
    public int lengthOfLongestSubstring(String s) {
        int max = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0, j = 0; i < s.length(); ++i) {
            char c = s.charAt(i);
            //if map contains c, update j
            if (map.containsKey(c)) {
                j = Math.max(j, map.get(c) + 1);
            }
            map.put(c, i);
            // i - j + 1 is the length of the substring
            max = Math.max(max, i-j+1);
        }
        return max;
    }
}