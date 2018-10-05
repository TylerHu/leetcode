package math;

/**
 * LeetCode 50. Pow(x, n)(https://leetcode.com/problems/powx-n/description/)
 *
 * Implement pow(x, n), which calculates x raised to the power n (x n).
 *
 * Solution: If n is even, pow(x, n) = pow(x*x, n/2), otherwise, pow(x, n) = x*pow(x*x, n/2), so we could use this feature
 * to redece loop times. And for negative n situation, there is a transformation should be done, that is pow(x, -n) =
 * pow(1/x, n)
 */
public class Pow {
    public double myPow(double x, int n) {
        if (n == 0) {
            return 1;
        }
        if (n == Integer.MIN_VALUE) {
            //handle the interger overflow corner case
            return myPow(x, n+1)/x;
        }
        if (n < 0) {
            //pow(x, -n) = pow(1/x, n)
            n = -n;
            x = 1/x;
        }
        //pow(x,n) = pow(x*x, n/2) or pow(x, n) = x*pow(x*x, n/2)
        return (n % 2 == 0) ? myPow(x*x, n/2) : x*myPow(x*x, n/2);
    }
}