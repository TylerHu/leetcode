package dp;

/**
 * LeetCode198. House Robber(https://leetcode.com/problems/house-robber/description/)
 *
 * You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed,
 * the only constraint stopping you from robbing each of them is that adjacent houses have security system connected and it will automatically
 * contact the police if two adjacent houses were broken into on the same night.
 * Given a list of non-negative integers representing the amount of money of each house, determine the maximum amount of money
 * you can rob tonight without alerting the police.
 *
 * Solution: Use dp approach, defina a dp array, dp[i] represents the maximum amount of money the robber can rob on [0,i] houses. For the ith house,
 * there are only two situations: 1, rob the ith house, and the accumulative money is the house before last house's money plus
 * current house's money, that is dp[i-2]+nums[i]. 2, don't rob the ith house, and the money is last house's accumulative money, that is dp[i-1]. So
 * the dp formula is : dp[i] = Math.max(dp[i-2] + nums[i], dp[i-1])
 *
 * According to the above analysize, for the ith house, the robber can either rob the house or do not rob the house, we can define
 * two variables "rob" and "dontRob" to store these two states to reduce the space complexity to 0(1)
 */
public class HouseRobber {

    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return nums[0];
        }
        int[] dp = new int[n];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < n; ++i) {
            //the maximum money of rob the ith house and dont rob the ith house
            dp[i] = Math.max(dp[i-2] + nums[i], dp[i-1]);
        }
        return dp[n-1];
    }

    public int rob2(int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        int rob = 0, dontRob = 0;
        for (int i = 0; i < n; ++i) {
            //temp is now the previous rob, represents rob (i-1)th house
            int temp = rob;
            //rob the house, and update rob variable
            rob = dontRob + nums[i];
            //dont rob the house
            dontRob = Math.max(temp, dontRob);
        }
        return Math.max(rob, dontRob);
    }
}