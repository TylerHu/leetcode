package binarysearch;

/**
 * LeetCode69. Sqrt(x)(https://leetcode.com/problems/sqrtx/description/)
 *
 * Implement int sqrt(int x).
 * Compute and return the square root of x, where x is guaranteed to be a non-negative integer.
 * Since the return type is an integer, the decimal digits are truncated and only the integer part of the result is returned.
 *
 * Solution: we could just use binary search to find the number whose squrare is less than or equal to  target number
 * and it's next number's square is larger than target number, that is i^2 <= x and (i+1)^2 > x
 */
public class Sqrt {
    public int mySqrt(int x) {
        if (x == 0) {
            return 0;
        }
        //corner case
        if (x < 4) {
            return 1;
        }
        //init left and right pointer
        int left = 1, right = x / 2;
        while(true) {
            int mid = (left + right) / 2;
            if (mid > x / mid) {
                right = mid-1;
            } else {
                //mid^2 <= x and (mid+1)^2 > x
                if ((mid+1) > x / (mid+1)) {
                    return mid;
                }
                left = mid+1;
            }
        }
    }
}