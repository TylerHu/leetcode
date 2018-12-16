package bitmanipulation;

/**
 * LeetCode338. Counting Bits(https://leetcode.com/problems/counting-bits/description/)
 *
 * Given a non negative integer number num. For every numbers i in the range 0 ≤ i ≤ num calculate the number of 1's in their binary
 * representation and return them as an array.
 *
 * Follow up:
 * It is very easy to come up with a solution with run time O(n*sizeof(integer)). But can you do it in linear time O(n) /possibly in a single pass?
 * Space complexity should be O(n).
 * Can you do it like a boss? Do it without using any builtin function like __builtin_popcount in c++ or in any other language.
 *
 * Solution: Let's try to figure out the pattern
 * f[01] = f[0] + 1 = f[1>>1] + 1 & 1
 * f[10] = f[1] + 0 = f[10>>1] + (10) & 1
 * f[11] = f[1] + 1 = f[11>>1] + (11) & 1
 * f[110] = f[11] + 0 = f[110>>1] + (110) & 1
 * ....
 * From above example, split the current number into two parts, the last bit, and remainder except last bit. To get the last
 * bit, just do i&1, and to get the remainder except last bit, just right shift one bit i>>1. So the pattern is : f[i] = f[i>>1] + i&1;
 */
public class CountBits {
    public int[] countBits(int num) {
        int[] result = new int[num+1];
        result[0] = 0;
        for (int i = 1; i <= num; ++i) {
            //the bits count of the number right shift one bit, and plus the last bit
            result[i] = result[i>>1] + (i&1);
        }
        return result;
    }
}