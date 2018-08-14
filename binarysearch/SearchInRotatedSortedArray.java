package binarysearch;

/**
 * LeetCode33. Search in Rotated Sorted Array(https://leetcode.com/problems/search-in-rotated-sorted-array/description/)
 *
 * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
 * (i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]).
 * You are given a target value to search. If found in the array return its index, otherwise return -1.
 * You may assume no duplicate exists in the array.
 * Your algorithm's runtime complexity must be in the order of O(log n).
 *
 * Solution:
 */
public class SearchInRotatedSortedArray {

    public int search(int[] nums, int target) {
        int n = nums.length;
        int low = 0, high = n-1;
        while (low < high) {
            int middle = (low + high) >>> 1;
            if (nums[middle] > nums[high]) {
                low = middle+1;
            } else {
                high = middle;
            }
        }
        int rotateIndex = low;
        low = 0;
        high = n-1;
        while(low <= high) {
            int middle = (low + high) >>> 1;
            int realMiddle = (middle+rotateIndex) % n;
            if (nums[realMiddle] == target) {
                return realMiddle;
            } else if (nums[realMiddle] > target) {
                high = middle-1;
            } else {
                low = middle+1;
            }
        }
        return -1;
    }
}