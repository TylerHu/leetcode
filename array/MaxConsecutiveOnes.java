package array;

/**
 * LeetCode485. Max Consecutive Ones(https://leetcode.com/problems/max-consecutive-ones/description/)
 *
 * Given a binary array, find the maximum number of consecutive 1s in this array.
 *
 * Solution: Keep track of the current consecutive ones, and the maximum number of consecutive ones, if zero occurs, reset the count to zero
 */
public class MaxConsecutiveOnes {
    public int findMaxConsecutiveOnes(int[] nums) {
        int max = 0;
        int count = 0;
        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] == 1) {
                //increase count
                count++;
                //update max count
                max = Math.max(count, max);
            } else {
                //reset to zero
                count = 0;
            }
        }
        return max;
    }
}