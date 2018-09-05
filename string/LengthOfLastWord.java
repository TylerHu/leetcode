package string;

/**
 * LeetCode58. Length of Last Word(https://leetcode.com/problems/length-of-last-word/description/)
 * Given a string s consists of upper/lower-case alphabets and empty space characters ' ', return the length of last word in the string.
 * If the last word does not exist, return 0.
 * Note: A word is defined as a character sequence consists of non-space characters only.
 */
public class LengthOfLastWord {
    public int lengthOfLastWord(String s) {
        //need to be careful when dealing with some special cases like s is " "
        if (s == null || s.trim().length() == 0) {
            return 0;
        }
        String[] array = s.split(" ");
        return array[array.length-1].length();
    }
}