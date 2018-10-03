package math;

/**
 * LeetCode 172. Factorial Trailing Zeroes(https://leetcode.com/problems/factorial-trailing-zeroes/description/)
 *
 * Given an integer n, return the number of trailing zeroes in n!.
 *
 * Solution: Since 10 is the product of 2 and 5, we need to count the minimum number of 2 and 5 in the n!. And as we know,
 * mutiply by 2 should be more often than multply by 5 in n!, so we could just count the number of factor 5 in all numbers
 * from 1 to n. And sometimes one number may have server 5 factors, like 25 have two 5 factors, 125 have three 5 factors.
 * So the format will be : n/5 + n/25 + n/125
 */
public class FactorialTrailingZeroes {
    public int trailingZeroes(int n) {
        if (n == 0) {
            return 0;
        }
        int count = 0;
        //here i is defined as long type
        //i start from 5
        for (long i = 5; n / i != 0; i *= 5) {
            count += (n / i);
        }
        return count;
    }
}