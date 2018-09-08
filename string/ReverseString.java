package string;

/**
 * LeetCode344. Reverse String(https://leetcode.com/problems/reverse-string/submissions/1)
 *
 * Write a function that takes a string as input and returns the string reversed.
 *
 * Solution: The simplest way is to use StringBuilder.reverse function. Or we could define a char array, and set it's
 * value from the origin string in oppsite directiong.
 */
public class ReverseString {
    public String reverseString(String s) {
        return new StringBuilder(s).reverse().toString();
    }

    public String reverseString2(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        int n = s.length();
        char[] chars = s.toCharArray();
        for (int i = 0; i < n / 2; ++i) {
            char temp = chars[i];
            chars[i] = chars[n-i-1];
            chars[n-i-1] = temp;
        }
        return new String(chars);
    }

}