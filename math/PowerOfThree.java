package math;

/**
 * LeetCode326. Power of Three(https://leetcode.com/problems/power-of-three/description/)
 *
 * Given an integer, write a function to determine if it is a power of three.
 *
 * Solution: Just keep divided the number n by three until n % 3 != 0, and check whether n is equal to 1 or not.
 * Another solution without looping is since the largest number that is power of three is 1162261467, we could check
 * whether n > 0 && 1162261467 % n == 0, but this solution is a little bit tricky.
 */
public class PowerOfThree {
    public boolean isPowerOfThree(int n) {
        if (n == 0) {
            return false;
        }
        while (n % 3 == 0) {
            n = n / 3;
        }
        return n == 1;
    }
}