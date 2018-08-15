package array;

/**
 * LeetCode189. Rotate Array(https://leetcode.com/problems/rotate-array/description/)
 *
 * Given an array, rotate the array to the right by k steps, where k is non-negative.
 *
 * Solution: Split the array at k point. Reverse the whole array first, and then reverse the first part of the array,
 * reverse the second part of the array.
 */
public class RotateArray {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k = k % n;
        if (k == 0) {
            return;
        }
        reverse(nums, 0, n-1);
        reverse(nums, 0, k-1);
        reverse(nums, k, n-1);
    }

    public void reverse(int[] nums, int start, int end) {
        int temp = 0;
        while (start < end) {
            temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}