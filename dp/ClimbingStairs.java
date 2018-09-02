package dp;

/**
 * LeetCode70. Climbing Stairs(https://leetcode.com/problems/climbing-stairs/description/)
 *
 * You are climbing a stair case. It takes n steps to reach to the top.
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 * Note: Given n will be a positive integer.
 *
 * Solution: Typical dp problem, for step i, we could reach step i from step (i-1) or from step (i-2). So the dp formula
 * is dp[i] = dp[i-1] + dp[i-2]. In fact, this is also a Fabonacci number, so we could define variables f0, f1, f2, and
 * f2 = f0 + f1, swap f0 with f1, and f1 with f2 each time when looping over.
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

    public int climbStairs2(int n) {
        if (n == 1) {
            return 1;
        }
        int f0 = 1;
        int f1 = 1;
        int f2 = 1;
        for (int i = 2; i <= n; ++i) {
            f2 = f0 + f1;
            f0 = f1;
            f1 = f2;
        }
        return f2;
    }
}