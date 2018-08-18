package array;

/**
 * LeetCode26. Remove Duplicates from Sorted Array(https://leetcode.com/problems/remove-duplicates-from-sorted-array/description/)
 *
 * Given a sorted array nums, remove the duplicates in-place such that each element appear only once and return the new length.
 * Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.
 *
 * Solution: Define a variable index, only increase index when the number is first seen, and insert the number at the index position.
 * When numbers are duplicated, increase pointer i until other number is seen. And the last index is the new length of the array.
 */
public class RemoveDuplicatesFromSortedArray {
    public int removeDuplicates(int[] nums) {
        int index = 0;
        for (int i = 0; i < nums.length; ++i) {
            //only increase index where the number is first seen, and insert at the index position
            nums[index++] = nums[i];
            //skip duplicated numbers
            while(i < nums.length-1 && nums[i] == nums[i+1]) ++i;
        }
        return index;
    }
}