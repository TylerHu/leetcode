package string;

/**
 * LeetCode557. Reverse Words in a String III(https://leetcode.com/problems/reverse-words-in-a-string-iii/description/)
 *
 * Given a string, you need to reverse the order of characters in each word within a sentence while still preserving whitespace
 * and initial word order.
 *
 * Solution: Just reverse every word in the string, word by word, and join them with space. At the end, remove the last
 * space and return it.
 */
public class ReverseWordsInAString3 {
    public String reverseWords(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        String[] stringArray = s.split("\\s+");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < stringArray.length; ++i) {
            sb.append(reverseWord(stringArray[i].toCharArray()) + " ");
        }
        String result = sb.toString();
        //trim the last space
        return result.substring(0, result.length()-1);
    }

    public String reverseWord(char[] chars) {
        int left = 0, right = chars.length - 1;
        while (left < right) {
            char temp = chars[left];
            chars[left] = chars[right];
            chars[right] = temp;
            left++;
            right--;
        }
        return new String(chars);
    }
}