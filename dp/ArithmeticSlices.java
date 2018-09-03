package dp;

/**
 * LeetCode413. Arithmetic Slices(https://leetcode.com/problems/arithmetic-slices/description/)
 *
 * A sequence of number is called arithmetic if it consists of at least three elements and if the difference between any two consecutive elements is the same.
 * A zero-indexed array A consisting of N numbers is given. A slice of that array is any pair of integers (P, Q) such that 0 <= P < Q < N.
 * A slice (P, Q) of array A is called arithmetic if the sequence:
 * A[P], A[p + 1], ..., A[Q - 1], A[Q] is arithmetic. In particular, this means that P + 1 < Q.
 * The function should return the number of arithmetic slices in the array A.
 *
 * Solution: Define variable current represents the number of arithmetic slices with A[i] as the last number, if A[i] - A[i-1] == A[i-1] - A[i-2],
 * means A[i-2]A[i-1]A[i] can make a arithmetic slices, increase current count, and add to total number of arithmetic slices. Otherwise, reset
 * current count to zero.
 */
public class ArithmeticSlices {
    public int numberOfArithmeticSlices(int[] A) {
        int sum = 0;
        int current = 0;
        for (int i = 2; i < A.length; ++i) {
            if (A[i] - A[i-1] == A[i-1] - A[i-2]) {
                //A[i-2]A[i-1]A[i] can make a arithmetic slices, increase current count of arithmetic slices which ending with A[i]
                current++;
                // add to the total number
                sum += current;
            } else {
                //reset current count to zero
                current = 0;
            }
        }
        return sum;
    }
}