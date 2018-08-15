package array;

/**
 * LeetCode27. Remove Element(https://leetcode.com/problems/remove-element/description/)
 *
 * Given an array nums and a value val, remove all instances of that value in-place and return the new length.
 * Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.
 * The order of elements can be changed. It doesn't matter what you leave beyond the new length.
 *
 * Solution: Use insert index, when the current element is not equal to val, set to nums[index], and increse index, also increase the length
 * The length if the final new length.
 */
public class RemoveElement {
    public int removeElement(int[] nums, int val) {
        int length = 0;
        int index = 0;
        for (int num : nums) {
            if (num != val) {
                nums[index++] = num;
                length++;
            }
        }
        return length;
    }
}