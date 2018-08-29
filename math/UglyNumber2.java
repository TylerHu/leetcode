package math;

/**
 * LeetCode264. Ugly Number II(https://leetcode.com/problems/ugly-number-ii/description/)
 *
 * Write a program to find the n-th ugly number.
 * Ugly numbers are positive numbers whose prime factors only include 2, 3, 5.
 *
 * Solution: Because every number can only be divided by 2, 3, 5, we can split the sequnce into three groups as follows:
 * [1*2, 2*2, 3*2, 4*2, 5*2...]
 * [1*3, 2*3, 3*3, 4*3, 5*3...]
 * [1*5, 2*5, 3*5, 4*5, 5*5...]
 * Every number can be (1,2,3,4,5..) multiply 2, or 3, or 5. We could define 3 pointers to represent the index of uglyNumber to
 * multiply 2, 3, 5 respectly.
 * Reference:https://www.geeksforgeeks.org/ugly-numbers/
 */
public class UglyNumber2 {
    public int nthUglyNumber(int n) {
        if (n == 0) {
            return 1;
        }
        int[] uglyNumber = new int[n];
        uglyNumber[0] = 1;
        int index2 = 0, index3 =  0, index5 = 0;
        for (int i = 1; i < n; ++i) {
            uglyNumber[i] = Math.min(Math.min(uglyNumber[index2]*2, uglyNumber[index3]*3), uglyNumber[index5]*5);
            if (uglyNumber[i] == uglyNumber[index2]*2) {
                index2++;
            }
            if (uglyNumber[i] == uglyNumber[index3]*3) {
                index3++;
            }
            if (uglyNumber[i] == uglyNumber[index5]*5) {
                index5++;
            }
        }
        return uglyNumber[n-1];
    }
}