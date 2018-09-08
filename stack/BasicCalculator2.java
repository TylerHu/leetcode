package stack;

/**
 * LeetCode227. Basic Calculator II(https://leetcode.com/problems/basic-calculator-ii/description/)
 *
 * Implement a basic calculator to evaluate a simple expression string.
 * The expression string contains only non-negative integers, +, -, *, / operators and empty spaces .
 * The integer division should truncate toward zero.
 *
 * Solution: Use stack to store numbers and temp calculation result. And define a variable sign to represent
 * previous operator. At the end, sum up all the numbers in the stack. Keep in mind that operand can be more than
 * two digits.
 */
public class BasicCalculator2 {
    public int calculate(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        Stack<Integer> stack = new Stack<>();
        int res = 0;
        int num = 0;
        char sign = '+';
        for (int i = 0; i < s.length(); ++i) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                //turn into number
                num = num * 10 + c - '0';
            }
            //notice when i reach to the end of the string, also need to do the calculation
            if ((!Character.isDigit(c) && c != ' ') || i == s.length() - 1) {
                if (sign == '+') {
                    stack.push(num);
                } else if (sign == '-') {
                    //if previous operand is '-', push the negative of current number to the stack
                    stack.push(-num);
                } else if (sign == '*') {
                    //if previous operand is '*', pop the top number of the stack and times by current number,
                    //push the result into the stack
                    stack.push(stack.pop() * num);
                } else if (sign == '/') {
                    //if previous operand is '/', pop the top number of the stack and divided by current number,
                    //push the result into the stack
                    stack.push(stack.pop() / num);
                }
                //update sign to current character
                sign = c;
                //reset number to 0
                num = 0;
            }
        }
        for (int i : stack) {
            //sum up all the numbers in the stack
            res += i;
        }
        return res;
    }
}