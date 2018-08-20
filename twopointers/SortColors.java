package twopointers;

/**
 * LeetCode75. Sort Colors(https://leetcode.com/problems/sort-colors/description/)
 *
 * Given an array with n objects colored red, white or blue, sort them in-place so that objects of the same color are adjacent,
 * with the colors in the order red, white and blue. Here, we will use the integers 0, 1, and 2 to represent the color red, white,
 * and blue respectively.
 * Note: You are not suppose to use the library's sort function for this problem.
 *
 * Solution: Define two pointers left and right represent the current index of the next smallest number and the current index of
 * the next biggest number. If nums[i] == 0 means it's the smallest number, and if i != left, we have to swap the number at index i and at index
 * left. If nums[i] == 2 means it's the biggest number, and if i != right, we have to swap the number at index i and at index right.
 *
 */
public class SortColors {
    public void sortColors(int[] nums) {
        int left = 0, right = nums.length-1;
        for (int i = 0; i <= right; ++i) {
            if (nums[i] == 0 && i != left) {
                //swap the number at index i and index left
                swap(nums, i, left);
                //stay at index i
                i--;
                //move left pointer one step forward
                left++;
            } else if (nums[i] == 2 && i != right) {
                //swap the number at index i and index right
                swap(nums, i, right);
                //stay at index i
                i--;
                //move right pointer one step backward
                right--;
            }
        }
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}