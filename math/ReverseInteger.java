package math;

/**
 * LeetCode7. Reverse Integer(https://leetcode.com/problems/reverse-integer/description/)
 *
 * Given a 32-bit signed integer, reverse digits of an integer.
 *
 * Solution: Start from the last digit by x % 10, and sum up with the previous result. So the equation will be
 * res = res * 10 + x % 10. But we need to avoid number overflow or underflow, we use a temporary variable to store
 * the result of res * 10 + x % 10, and check whether (temp-tail/10 == res), if it's overflow or underflow, they will
 * not be the same.
 */
public class ReverseInteger {
    public int reverse(int x) {
        int res = 0;
        while (x != 0) {
            int tail = x % 10;
            //store the result in a temp variable
            int temp = res * 10 + tail;
            if ((temp-tail)/10 != res) {
                //check whether is overflow or underflow
                return 0;
            }
            //update result
            res = temp;
            //update x for next loop
            x = x / 10;
        }
        return res;
    }
}