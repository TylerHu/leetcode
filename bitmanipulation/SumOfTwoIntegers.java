package bitmanipulation;

/**
 * LeetCode371. Sum of Two Integers(https://leetcode.com/problems/sum-of-two-integers/description/)
 *
 * Calculate the sum of two integers a and b, but you are not allowed to use the operator + and -.
 *
 * Solution: Use & to get the carry bits of a and b, and use ^ to add the different bits of a and b and assign to a, left
 * shift the carry bits and assigned to b, until there is no carry bits. For example, 001 + 011, first get the carry bits:
 * by 001 & 011 = 001, and get the sum of different bits by 001 ^ 011 = 010, left shift the carry bits as 010, now a becomes
 * 010, b becomes 010. And then do it agin, carry = 010 & 010 = 010, a = 010 ^ 010 = 000, left shift carry as 100, now a becomes
 * 000, b becomes 100. Do it one more time, carry = 000 & 100 = 000, a = 000 ^ 100 = 100, left shift carry as 000, so the
 * result is 100.
 */
public class SumOfTwoIntegers {
    public int getSum(int a, int b) {
        if (a == 0) {
            return b;
        }
        if (b == 0) {
            return a;
        }
        while (b != 0) {
            //get the carry bits
            int carry = a & b;
            //get the sum of different bits
            a = a ^ b;
            //left shift carry bit
            b = carry << 1;
        }
        return a;
    }
}