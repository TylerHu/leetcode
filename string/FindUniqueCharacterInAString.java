package string;

/**
 * LeetCode387. First Unique Character in a String(https://leetcode.com/problems/first-unique-character-in-a-string/description/)
 *
 * Given a string, find the first non-repeating character in it and return it's index. If it doesn't exist, return -1.
 *
 * Solution: Define an array with size of 256 to store how many times the character appeared in the string. And get the first
 * element's index whose value is 1.
 */
public class FindUniqueCharacterInAString {
    public int firstUniqChar(String s) {
        int[] counter = new int[256];
        for (int i = 0; i < s.length(); ++i) {
            //use the character's code to be index
            counter[Character.getNumericValue(s.charAt(i))]++;
        }
        for (int i = 0; i < s.length(); ++i) {
            if (counter[Character.getNumericValue(s.charAt(i))] == 1) {
                return i;
            }
        }
        return -1;
    }
}