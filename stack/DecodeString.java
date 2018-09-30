package stack;

/**
 * LeetCode394. Decode String(https://leetcode.com/problems/decode-string/description/)
 *
 * Given an encoded string, return it's decoded string.
 * The encoding rule is: k[encoded_string], where the encoded_string inside the square brackets is being repeated exactly
 * k times. Note that k is guaranteed to be a positive integer.
 * You may assume that the input string is always valid; No extra white spaces, square brackets are well-formed, etc.
 * Furthermore, you may assume that the original data does not contain any digits and that digits are only for those
 * repeat numbers, k. For example, there won't be input like 3a or 2[4].
 *
 * Solution: Use two stack to store the temp result and string counts. Define string res to represent current string
 * in the bracket.
 */
public class DecodeString {
    public String decodeString(String s) {
        Stack<Integer> countStack = new Stack<>();
        Stack<String> resStack = new Stack<>();
        int idx = 0;
        //string in the current bracket
        String res = "";
        while (idx < s.length()) {
            if (Character.isDigit(s.charAt(idx))) {
                int count = 0;
                //count can be larger than two digits
                while (Character.isDigit(s.charAt(idx))) {
                    count = count * 10 + (s.charAt(idx) - '0');
                    idx++;
                }
                countStack.push(count);
            } else if (s.charAt(idx) == '[') {
                //push temp result into stack
                resStack.push(res);
                //reset current string
                res = "";
                idx++;
            } else if (s.charAt(idx) == ']') {
                StringBuilder sb = new StringBuilder(resStack.pop());
                int count = countStack.pop();
                for (int i = 0; i < count; ++i) {
                    //repeated string
                    sb.append(res);
                }
                res = sb.toString();
                idx++;
            } else {
                //append character to string
                res += s.charAt(idx++);
            }
        }
        return res;
    }
}