package string;

/**
 * LeetCode43. Multiply Strings(https://leetcode.com/problems/multiply-strings/)
 *
 * Given two non-negative integers num1 and num2 represented as strings, return the product of num1 and num2,
 * also represented as a string.
 *
 */
public class MultiplyStrings {

    public String multiply(String num1, String num2) {
        int m = num1.length();
        int n = num2.length();
        int[] pos = new int[m+n];
        int sum = 0;
        for (int i = m-1; i >= 0; --i) {
            int digit1 = num1.charAt(i) - '0';
            for (int j = n-1; j >= 0; --j) {
                int digit2 = num2.charAt(j) - '0';
                sum = digit1 * digit2 + pos[i+j+1];
                pos[i+j] += sum / 10;
                pos[i+j+1] = sum % 10;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int num : pos) {
            if (!(sb.length() == 0 && num == 0)) {
                sb.append(num);
            }
        }
        return sb.length() == 0 ? "0" : sb.toString();
    }
}