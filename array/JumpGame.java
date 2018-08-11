package array;

/**
 * LeetCode55. Jump Game(https://leetcode.com/problems/jump-game/description/)
 *
 * Given an array of non-negative integers, you are initially positioned at the first index of the array.
 * Each element in the array represents your maximum jump length at that position.
 * Determine if you are able to reach the last index.
 *
 * Solution: The idea is simple, record the reach point the current elemnt can jump. Iterate the array, in
 * the end, check the current elemnt is the last one.
 */
public class JumpGame {

    public boolean canJump(int[] nums) {
        // note that we define variable i here, not inside the loop
        int i = 0;
        // define the reach variable, check whether i is already reached the end or the last reach point
        for (int reach = 0; i < nums.length && i <= reach; ++i) {
            reach = Math.max(reach, i + nums[i]);
        }
        //check whether i is the last element
        return i == nums.length;
    }
}