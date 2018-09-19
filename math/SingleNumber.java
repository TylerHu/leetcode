package math;

/**
 * LeetCode136. Single Number(https://leetcode.com/problems/single-number/description/)
 *
 * Given a non-empty array of integers, every element appears twice except for one. Find that single one.
 *
 * Solution: Since a ^ a = 0, and 0 ^ b = b, we could just xor all the numbers in the array, the final result
 * is the number that appear once.
 */
public class SingleNumber {
    public int singleNumber(int[] nums) {
        int result = nums[0];
        for (int i = 1; i < nums.length; ++i) {
            result = result ^ nums[i];
        }
        return result;
    }
}