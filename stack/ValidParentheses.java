package stack;

/**
 * LeetCode20. Valid Parentheses(https://leetcode.com/problems/valid-parentheses/description/)
 *
 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 * An input string is valid if:
 * Open brackets must be closed by the same type of brackets.
 * Open brackets must be closed in the correct order.
 * Note that an empty string is also considered valid.
 *
 * Solution: Every time when '(', '{', '[' is encountered, push it into the stack, and when ')', '}', ']' is encountered,
 * check whether the top of stack is it's counterpart open bracket. i.e, '(' is ')' counterpart open bracket.
 */
public class ValidParentheses {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '[' || c == '{') {
                //push to the stack
                stack.push(c);
            } else if (c == ')') {
                if (stack.isEmpty() || stack.pop() != '(') {
                    return false;
                }
            } else if (c == ']') {
                if (stack.isEmpty() || stack.pop() != '[') {
                    return false;
                }
            } else if (c == '}') {
                if (stack.isEmpty() || stack.pop() != '{') {
                    return false;
                }
            }
        }
        //check whether stack is empty, if valid, the stack should be empty
        return stack.isEmpty();
    }
}