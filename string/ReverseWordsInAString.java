package string;

/**
 * LeetCode151. Reverse Words in a String(https://leetcode.com/problems/reverse-words-in-a-string/description/)
 *
 * Given an input string, reverse the string word by word.
 *
 * Solution: Just be careful about some empty space in the string, so need to trim the string first.
 */
public class ReverseWordsInAString {
    public String reverseWords(String s) {
        //trim the string
        if (s == null || s.trim().length() == 0) {
            return "";
        }
        //trim the string and split by one or more spaces
        String[] strArray = s.trim().split("\\s+");
        //from back to start
        StringBuilder sb = new StringBuilder();
        for(int i = strArray.length - 1; i > 0; --i) {
            sb.append(strArray[i] + " ");
        }
        sb.append(strArray[0]);
        return sb.toString();
    }
}