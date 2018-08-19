package dp;

/**
 * LeetCode53. Maximum Subarray(https://leetcode.com/problems/maximum-subarray/description/)
 *
 * Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.
 *
 * Solution: dp[i] represents the largest ending at element i, so dp[i] is either previous sum plus current element, or is current elemnt if
 * previous sum is negative. The dp formula is : dp[i] = max(dp[i-1] + nums[i], nums[i])
 *
 */
public class MaximumSubarray {
    public int maxSubArray(int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        int[] dp = new int[n];
        dp[0] = nums[0];
        //init largest sum of the whole array to zero
        int max = dp[0];
        for (int i = 1; i < n; ++i) {
            dp[i] = Math.max(dp[i-1] + nums[i], nums[i]);
            //update largest sum of the whole array
            max = Math.max(max, dp[i]);
        }
        return max;
    }
}