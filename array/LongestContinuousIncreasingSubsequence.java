package array;

/**
 * LeetCode 674. Longest Continuous Increasing Subsequence(https://leetcode.com/problems/longest-continuous-increasing-subsequence/)
 *
 * Given an unsorted array of integers, find the length of longest continuous increasing subsequence (subarray).
 *
 * Solution: Traverse through the array, and keep counting continuous increasing numbers, if start falling, reset the
 * couter to zero.
 */
public class LongestContinuousIncreasingSubsequence {
    public int findLengthOfLCIS(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int max = 1;
        int count = 1;
        for (int i = 1; i < nums.length; ++i) {
            if (nums[i] > nums[i-1]) {
                count++;
                max = Math.max(count, max);
            } else {
                count = 1;
            }
        }
        return max;
    }
}