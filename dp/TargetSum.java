package dp;

/**
 * LeetCode494. Target Sum(https://leetcode.com/problems/target-sum/description/)
 *
 * You are given a list of non-negative integers, a1, a2, ..., an, and a target, S. Now you have 2 symbols + and -. For each integer,
 * you should choose one from + and - as its new symbol.Find out how many ways to assign symbols to make sum of integers equal to target S.
 *
 * Solution: Let's split the array into two subsets, positive subset P and negative subset N, and the sum of these two subsets should be
 * equal to target. So sum(P) - sum(N) = target, sum(P) - sum(N) + sum(P) + sum(N) = target + sum(P) + sum(N), 2*sum(P) = target + totalSum,
 * sum(P) = (target+totalSum) / 2. According to above analyse, the origin problem can to converted to subset sum problem which is similar to
 * leetcode416, to find how many subsets that their sum equal to (target+totalSum)/2.
 *
 */
public class TargetSum {

    public int findTargetSumWays(int[] nums, int S) {
        //total sum
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        //if sum less than target, or the combination of sum and target is not even, means there is no way to make it euqal to target S
        //otherwise get the number of subsets that can make sum to (sum+S)/2
        return sum < S || (sum+S) % 2 != 0 ? 0 : subsetSum(nums, (sum + S) >>> 1);
    }

    public int subsetSum(int[] nums, int target) {
        //dp[i][j] represents how many ways that subset (0,i-1) can make sum to j
        int[][] dp = new int[nums.length+1][target+1];
        dp[0][0] = 1;
        for (int i = 1; i <= nums.length; ++i) {
            dp[i][0] = 1;
        }
        for (int i = 1; i <= nums.length; ++i) {
            for (int j = 0; j <= target; ++j) {
                //for each nums[i-1], we can decide to pick it or not pick it
                //if we do not pick nums[i-1], then dp[i][j] = dp[i-1][j], means nums j is composes of previous (0,i-2)numbers
                //if we pick nums[i-1], then dp[i][j] = dp[i-1][j-nums[i-1]], means nums[j] is composed of nums[i-1] and previous
                //(0,i-2) numbers, whose sum should be j-nums[i-1]
                dp[i][j] = dp[i-1][j];
                if (j >= nums[i-1]) {
                    dp[i][j] += dp[i-1][j-nums[i-1]];
                }
            }
        }
        return dp[nums.length][target];
    }
}