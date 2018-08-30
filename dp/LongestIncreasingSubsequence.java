package dp;

/**
 * LeetCode300. Longest Increasing Subsequence(https://leetcode.com/problems/longest-increasing-subsequence/description/)
 *
 * Given an unsorted array of integers, find the length of longest increasing subsequence.
 *
 * Note: There may be more than one LIS combination, it is only necessary for you to return the length.
 * Your algorithm should run in O(n2) complexity.
 *
 * Solution: Maintain an array tailTable to store the tail element of all active subsequence, if nums[i] is less than tailTable[0],
 * replace tailTable with nums[i], if nums[i] > last element of tailTable, extend the tailTable with nums[i], if nums[i] is in between
 * tailTable, replace the largest element that is smaller than nums[i] with nums[i]. And the length of the tailTable is the
 * result we got.
 */
public class LongestIncreasingSubsequence {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        int[] tailTable = new int[n];
        int len;
        tailTable[0] = nums[0];
        len = 1;
        for (int i = 1; i < n; ++i) {
            if (nums[i] < tailTable[0]) {
                //new smallest value
                //replace tailTable[0] with nums[i]
                tailTable[0] = nums[i];
            } else if (nums[i] > tailTable[len - 1]) {
                //extend tailTable with nums[i]
                tailTable[len++] = nums[i];
            } else {
                //nums[i] is in between in tailTable
                int ceil = ceilIndex(tailTable, nums[i], 0, len);
                //replace the largest element that is smaller than nums[i] with nums[i]
                tailTable[ceil] = nums[i];
            }
        }
        return len;
    }

    //binary search
    public int ceilIndex(int[] array, int target, int left, int right) {
        while (left < right) {
            int middle = (left + right) >> 1;
            if (array[middle] < target) {
                left = middle + 1;
            } else {
                right = middle;
            }
        }
        return left;
    }
}