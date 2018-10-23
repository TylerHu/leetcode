package bitmanipulation;

/**
 * LeetCode190. Reverse Bits(https://leetcode.com/problems/reverse-bits/description/)
 *
 * Reverse bits of a given 32 bits unsigned integer.
 *
 * Example:
 * Input: 43261596
 * Output: 964176192
 * Explanation: 43261596 represented in binary as 00000010100101000001111010011100,
 * return 964176192 represented in binary as 00111001011110000010100101000000.
 *
 * Solution: The idea is straighforward, get the bits from right to left, and add them back.
 */
public class ReverseBits {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int result = 0;
        for (int i = 0; i < 32; ++i) {
            //get the last bit of number n, and add it to pervious result
            result += n & 1;
            //caution: unsigned right shifting
            n >>>= 1;
            //no need to left shift for last round
            if (i < 31) {
                //left shift
                result <<= 1;
            }
        }
        return result;
    }
}
}
