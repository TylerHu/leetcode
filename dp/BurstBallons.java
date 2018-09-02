package dp;

/**
 * LeetCode312. Burst Balloons(https://leetcode.com/problems/burst-balloons/description/)
 *
 * Given n balloons, indexed from 0 to n-1. Each balloon is painted with a number on it represented by array nums.
 * You are asked to burst all the balloons. If the you burst balloon i you will get nums[left] * nums[i] * nums[right] coins.
 * Here left and right are adjacent indices of i. After the burst, the left and right then becomes adjacent.
 * Find the maximum coins you can collect by bursting the balloons wisely.
 *
 * Solution: dp[i][j] represents the maximum coins we get after we burst all the ballons between i and j in the original array.
 */
public class BurstBallons {
    public int maxCoins(int[] nums) {
        int[] extendNums = new int[nums.length+2];
        int n = 1;
        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] > 0) {
                //burst all the ballons that has zeor coin
                extendNums[n++] = nums[i];
            }
        }
        //extend the array in both sides
        extendNums[0] = extendNums[n++] = 1;

        int[][] dp = new int[n][n];
        for (int k = 2; k < n; k ++) {
            for (int left = 0; left < n-k; ++left) {
                int right = left + k;
                for (int i = left+1; i < right; ++i) {
                    dp[left][right] = Math.max(dp[left][right], extendNums[left]*extendNums[i]*extendNums[right] + dp[left][i] + dp[i][right]);
                }

            }
        }
        return dp[0][n-1];
    }
}