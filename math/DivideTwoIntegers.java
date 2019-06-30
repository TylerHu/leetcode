package math;

/**
 * Leetcode29. Divide Two Integers(https://leetcode.com/problems/divide-two-integers/)
 *
 * Given two integers dividend and divisor, divide two integers without using multiplication, division and mod operator.
 * Return the quotient after dividing dividend by divisor.
 * The integer division should truncate toward zero.
 *
 */
public class DivideTwoIngegers {
    public int divide(int dividend, int divisor) {
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }
        long dvd = Math.abs((long)dividend);
        long dvs = Math.abs((long)divisor);
        int sign = (dividend >= 0 && divisor >= 0 || dividend < 0 && divisor < 0) ? 1 : -1;
        int result = 0;
        while (dvd >= dvs) {
            long temp  = dvs;
            int times = 1;
            while (temp << 1 <= dvd) {
                temp <<= 1;
                times <<= 1;
            }
            dvd -= temp;
            result += times;
        }
        return sign == 1 ? result : -result;
    }
}