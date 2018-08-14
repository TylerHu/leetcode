package binarysearch;

/**
 * LeetCode153. Find Minimum in Rotated Sorted Array(https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/description/)
 *
 * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
 * (i.e.,  [0,1,2,4,5,6,7] might become  [4,5,6,7,0,1,2]).
 * Find the minimum element.You may assume no duplicate exists in the array.
 *
 * Solution: For a sorted array, the middle element is always smaller or equals to the last element. An in a rotated sorted array, if
 * the middle element is bigger than the last element, means the rotate happens is the right part of the array, otherwise, the rotate
 * happens in the left part of the array. Since low < high, and the round operation during getting the middle between low and high, low
 * is never equals to high, we could set high = middle when iterate the left part.
 */
public class MinimumInRotatedSortedArray {
    public int findMin(int[] nums) {
        int low = 0, high = nums.length-1;
        while (low < high) {
            int middle = (low + high) >>> 1;
            if (nums[middle] > nums[high]) {
                // the rotate happens in the right part of the array
                low = middle+1;
            } else {
                // the rotate happens in the left part of the array
                high = middle;
            }
        }
        return nums[low];
    }
}