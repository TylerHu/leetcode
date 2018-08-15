package binarysearch;

/**
 * LeetCode81. Search in Rotated Sorted Array II(https://leetcode.com/problems/search-in-rotated-sorted-array-ii/description/)
 *
 * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
 * (i.e., [0,0,1,2,2,5,6] might become [2,5,6,0,0,1,2]).
 * You are given a target value to search. If found in the array return true, otherwise return false.
 *
 * Solution: Use binarysearch approach. Since there will be duplicated numbers, there are chances that the middle number is equal
 * to the low number or the high number. When nums[low] == nums[middle] == nums[high], just shrink the array by one step from both
 * side. When nums[low] <= nums[middle], means that the left part of the array is sorted, so when target is bigger than the low number
 * and smaller than the middle number, the target number is in the left part, we could set high = middle-1, to search in the left part
 * later, otherwise, the target is in the right part of the array, set how = middle+1 to search in the right part later.
 * When nums[low] > nums[middle], means that the rotation point is in the left part, and the right part of the array is sorted.
 */
public class SearchInRotatedSortedArray2 {
    public boolean search(int[] nums, int target) {
        int n = nums.length;
        if (n == 0) {
            return false;
        }
        int low = 0, high = n-1;
        while(low <= high) {
            int middle = (low + high) >>> 1;
            if (nums[middle] == target) {
                return true;
            }
            if (nums[low] == nums[middle] && nums[high] == nums[middle]) {
                //just shrink the array from both size
                low++;
                high--;
            } else if (nums[low] <= nums[middle]) {
                if (nums[low] <= target && nums[middle] > target) {
                    //the target is in the left part of the array
                    high = middle-1;
                } else {
                    //the target is in the right part of the array
                    low = middle+1;
                }
            } else {
                if (nums[middle] < target && nums[high] >= target) {
                    //the target is in the right part of the array
                    low = middle+1;
                } else {
                    //the target is in the left part of the array
                    high = middle-1;
                }
            }
        }
        return false;
    }
}