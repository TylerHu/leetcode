package dp;

/**
 * LeetCode746. Min Cost Climbing Stairs(https://leetcode.com/problems/min-cost-climbing-stairs/description/)
 *
 * On a staircase, the i-th step has some non-negative cost cost[i] assigned (0 indexed).
 * Once you pay the cost, you can either climb one or two steps. You need to find minimum cost to reach the top of the floor,
 * and you can either start from the step with index 0, or the step with index 1.
 *
 * Solution: Use dp approach. For every step(except 0th, 1th), can be reached from last step or last two steps, so the dp formula
 * is : dp[i] = cost[i] + Math.min(dp[i-1], dp[i-1]). The min cost to reach the top of the stairs is min(dp[n-1], dp[n-2])
 *
 * Since we only need to know the cost of last step dp[i-1], and the cost of last two steps dp[i-2], we can define two variables
 * f0 and f1 to reduce the space complexity from O(n) to O(1).
 */
public class MinCostClimbingStairs {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int[] dp = new int[n];
        //init dp[0] and dp[1]
        dp[0] = cost[0];
        dp[1] = cost[1];

        for (int i = 2; i < cost.length; ++i) {
            //every step can be reached from last step or last two steps
            dp[i] = cost[i] + Math.min(dp[i-1], dp[i-2]);
        }
        //the min cost to reach the top of the stairs
        return Math.min(dp[n-1], dp[n-2]);
    }

    public int minCostClimbingStairs2(int[] cost) {
        int n = cost.length;
        int f0 = cost[0];
        int f1 = cost[1];
        int f2 = 0;

        for (int i = 2; i < cost.length; ++i) {
            f2 = cost[i] + Math.min(f0, f1);
            f0 = f1;
            f1 = f2;
        }
        return Math.min(f0, f1);
    }
}