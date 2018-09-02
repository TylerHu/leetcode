package dp;

/**
 * LeetCode70. Climbing Stairs(https://leetcode.com/problems/climbing-stairs/description/)
 *
 * You are climbing a stair case. It takes n steps to reach to the top.
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 * Note: Given n will be a positive integer.
 *
 * Solution: Typical dp problem, for step i, we could reach step i from step (i-1) or from step (i-2). So the dp formula
 * is dp[i] = dp[i-1] + dp[i-2]
 */
public class ClimbingStairs {
    public int climbStairs(int n) {
        if (n == 1) {
            return 1;
        }
        int[] dp = new int[n+1];
        //init first two steps
        dp[1] = 1;
        dp[2] = 2;
        //start from the third step, and ending with the nth step
        for (int i = 3; i <= n; ++i) {
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];

    }
}