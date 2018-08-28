package dp;

/**
 * LeetCode213. House Robber II(https://leetcode.com/problems/house-robber-ii/description/)
 *
 * You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed.
 * All houses at this place are arranged in a circle. That means the first house is the neighbor of the last one. Meanwhile,
 * adjacent houses have security system connected and it will automatically contact the police if two adjacent houses were broken
 * into on the same night.Given a list of non-negative integers representing the amount of money of each house, determine the maximum
 * amount of money you can rob tonight without alerting the police.
 *
 * Solution: We can split the list into two un-circle list, [0, n-2] and [1, n-1]. Then we can reuse the solution of leetcode198
 * and return the maximum of these two list.
 */
public class HouseRobber2 {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return nums[0];
        }
        if (n == 2) {
            return Math.max(nums[0], nums[1]);
        }
        //split into two uncircle list, [0, n-2], [1, n-1]
        return Math.max(helper(nums, 0, n-2), helper(nums, 1, n-1));
    }

    public int helper(int[] nums, int start, int end) {
        //size is end+1
        int[] dp = new int[end+1];
        for (int i = start; i <= end; ++i) {
            if (i == start) {
                dp[i] = nums[start];
            } else if (i == start+1) {
                //the largest of first two number
                dp[i] = Math.max(nums[start], nums[start+1]);
            } else {
                dp[i] = Math.max(dp[i-2] + nums[i], dp[i-1]);
            }
        }
        return dp[end];
    }
}