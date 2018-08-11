package greedy;

/**
 * LeetCode45. Jump Game II
 *
 * Given an array of non-negative integers, you are initially positioned at the first index of the array.
 * Each element in the array represents your maximum jump length at that position.
 * Your goal is to reach the last index in the minimum number of jumps.
 *
 * Solution: Define a variable "current" denoted as longest distance in current minimum steps, when the index
 * reach this distance, update the distance and increase steps.
 */
public class JumpGame2 {

    public int jump(int[] nums) {
        //minimum steps
        int steps = 0;
        //longest distance the current index can reach
        int maxReach = 0;
        //longest distance in minimum steps
        int current = 0;
        for (int i = 0; i < nums.length-1; ++i) {
            maxReach = Math.max(maxReach, i + nums[i]);
            if (i == current) {
                // when reach the current longest distance, increase steps
                steps++;
                current = maxReach;
            }
        }
        return steps;
    }
}