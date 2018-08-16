package binarysearch;

/**
 * LeetCode34. Find First and Last Position of Element in Sorted Array
 * (https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/submissions/1)
 *
 * Given an array of integers nums sorted in ascending order, find the starting and ending position of a given target value.
 * Your algorithm's runtime complexity must be in the order of O(log n).
 * If the target is not found in the array, return [-1, -1].
 *
 * Solution: First, use binary search to search the index of first element that is equal to or larger than the target. If the
 * index is the same with the array length or the element at the index position is not equal to the target, means that the target
 * is not found in the array. Second, the last position of the target is the index just before the position of the target's next
 * bigger number. So we could search the index of the target's next bigger number, and minus one to get the real last postion.
 *
 */
public class FirstAndLastPositionInSortedArray {
    public int[] searchRange(int[] nums, int target) {
        int start = searchFirstGreaterEqual(nums, target);
        if (start == nums.length || nums[start] != target) {
            //index is the same with the lenth or the elemnt at the index position is not equal to target, means not found
            return new int[]{-1, -1};
        }
        //search the target's next bigger number
        return new int[]{start, searchFirstGreaterEqual(nums, target+1) - 1};
    }

    public int searchFirstGreaterEqual(int[] nums, int target) {
        int low = 0;
        //high is set to nums.length
        int high = nums.length;
        // note low < high not low <= high
        while(low < high) {
            int middle = (low + high) / 2;
            //low <= middle < high
            if (nums[middle] < target) {
                low = middle + 1;
            } else {
                //not middle+1, because nums[middle] > target, nums[high] > target, the result could be middle
                high = middle;
            }
        }
        return low;
    }
}