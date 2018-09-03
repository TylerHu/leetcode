package dp;

/**
 * LeetCode416. Partition Equal Subset Sum(https://leetcode.com/problems/partition-equal-subset-sum/description/)
 *
 * Given a non-empty array containing only positive integers, find if the array can be partitioned into two subsets such
 * that the sum of elements in both subsets is equal.
 *
 * Solution: This is a knapsack problem. For each number, we could decide to pick it or not. Define an 2D array dp.
 * dp[i][j] represents whether specific sum j can be gotten from the first i numbers(0,1,2,...i). If we could pick
 * a series number from first i numbers(0,1,2...i), dp[i][j] is true, otherwise, dp[i][j] is false.
 * For each number i, if we don't pick it, dp[i][j] = dp[i-1][j], means dp[i][j] depends on the previous i-1 numbers to make it
 * to sum up to j. If we pick number i, dp[i][j] = dp[i-1][j-nums[i], means sum j is composed of current number i and previous i-1 numbers,
 * and the sum of previous i-1 numbers should be j-nums[i]. So dp[i][j] = dp[i-1][j] || dp[i-1][j-nums[i];
 */
public class PartitionEqualSubsetSum {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        //sum is odd
        if (sum % 2 != 0) {
            return false;
        }
        //get half of sum
        sum = sum >>> 1;
        int n = nums.length;
        //dp array, size if n*(sum+1)
        boolean[][] dp = new boolean[n][sum+1];
        dp[0][0] = true;
        for (int i = 1; i < n; ++i) {
            //any number can make it sum to 0
            dp[i][0] = true;
        }
        for (int j = 1; j < sum+1; ++j) {
            dp[0][j] = false;
        }

        for (int i = 1; i < n; ++i) {
            for (int j = 1; j < sum+1; ++j) {
                dp[i][j] = dp[i-1][j];
                // j >= nums[i], so nums[i] may be possible to be included
                if (j >= nums[i]) {
                    //dp[i][j] depends on whether we pick current number i
                    dp[i][j] = dp[i][j] || dp[i-1][j-nums[i]];
                }
            }
        }
        //return wheter number(0,1,2...n-1) can sum up to half of the total sum.
        return dp[n-1][sum];
    }
}