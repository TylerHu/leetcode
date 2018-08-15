package array;

/**
 * LeetCode283. Move Zeroes(https://leetcode.com/problems/move-zeroes/description/)
 *
 * Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.
 * Note:
 * You must do this in-place without making a copy of the array.
 * Minimize the total number of operations.
 *
 * Solution: Use insert index to set non-zero elements to the array first, and then set the left element to zeroes.
 */
public class MoveZeroes {
    public void moveZeroes(int[] nums) {
        int n = nums.length;
        int index = 0;
        for (int num : nums) {
            if (num != 0) {
                nums[index++] = num;
            }
        }
        while(index < n) {
            nums[index++] = 0;
        }
    }
}