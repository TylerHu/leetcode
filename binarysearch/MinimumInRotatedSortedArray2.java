package binarysearch;

/**
 * LeetCode154. Find Minimum in Rotated Sorted Array II(https://leetcode.com/problems/find-minimum-in-rotated-sorted-array-ii/description/)
 *
 * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
 * (i.e.,  [0,1,2,4,5,6,7] might become  [4,5,6,7,0,1,2]).
 * Find the minimum element.The array may contain duplicates.
 *
 * Solution: It's very similar to problem 153, except that the array may contain duplicates. When the middle number is equal to the last number,
 * move the last pointer backward by one step to shrink the array.
 */
public class MinimumInRotatedSortedArray {
    public int findMin(int[] nums) {
        int low = 0, high = nums.length -1;
        while(low < high) {
            int middle = (low + high) >>> 1;
            if (nums[middle] > nums[high]) {
                low = middle+1;
            } else if (nums[middle] < nums[high]) {
                high = middle;
            } else {
                //nums[middle]==num[high], shrink the array
                high--;
            }
        }
        return nums[low];
    }
}