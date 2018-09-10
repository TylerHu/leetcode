package string;

/**
 * LeetCode709. To Lower Case(https://leetcode.com/problems/to-lower-case/description/)
 *
 * Implement function ToLowerCase() that has a string parameter str, and returns the same string in lowercase.
 *
 * Solution: If c is uppercase, just minus the differece between lowercase and uppercase 'A' - 'a', remember to
 * force transform the result to char type, otherwise it will be int type
 */
public class ToLowerCase {
    public String toLowerCase(String str) {
        if (str == null || str.length() == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (char c : str.toCharArray()) {
            if (c >= 'A' && c <= 'Z') {
                //remember to transform to char type
                sb.append((char)(c+'a'-'A'));
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}