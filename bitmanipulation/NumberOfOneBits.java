package bitmanipulation;

/**
 * LeetCode191. Number of 1 Bits(https://leetcode.com/problems/number-of-1-bits/description/)
 *
 * Write a function that takes an unsigned integer and returns the number of '1' bits it has (also known as the Hamming weight).
 *
 * Solution: We could right shift the number n and check whehter the last bit is 1 or 0.
 */
public class NumberOfOneBits {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int count = 0;
        while (n != 0) {
            //since 1&1 = 1, 0&1 = 0, we could add n&1 to the result count
            count += n & 1;
            //here need to use shifting unsigned operation >>> instead of shifting signed operation >>, since >> depends
            //on sign extension
            n = n >>> 1;
        }
        return count;
    }
}