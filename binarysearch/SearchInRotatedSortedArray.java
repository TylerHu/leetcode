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
 * Solution: First need to find the start index of the rotation in the array, about how to find the rotation index is mentioned in leetcode153.
 * After getting the rotateIndex, use binary search to find the target number. When doing the searching, need to do some transformation for the
 * middle index. Take the following array as an example:
 *
 * sorted array:  [0,1,2,3,4,5,6,7]
 *                      ||
 * rotated array: [4,5,6,7,0,1,2,3]
 * For the sorted array, the middle number is 3, and it's index is 3 in the sorted array, after rotation, the index of each number becomes:
 * (originIndex + rotateIndex) % n, where orginIndex is the index in the sorted array, and rotateIndex is the starting point of the rotation, and n
 * is the length of the array. So the index of number 3 is the rotated array is (3+4)%8=7.
 *
 * In fact, the left part array to the rotation point is a sorted array, and the righ part array the the rotation point(including the point) is another
 * sorted array, so can do normal binary search in this two array, without dealing the "realMiddle index".
 */
public class SearchInRotatedSortedArray {

    public int search(int[] nums, int target) {
        int n = nums.length;
        int low = 0, high = n-1;
        //find the rotate index, also is the index of the minimum number is the rotated array.
        while (low < high) {
            int middle = (low + high) >>> 1;
            if (nums[middle] > nums[high]) {
                low = middle+1;
            } else {
                high = middle;
            }
        }
        //set rotate index to the low pointer
        int rotateIndex = low;
        low = 0;
        high = n-1;
        //binary search the target number
        while(low <= high) {
            //the middle index in a normal sorted array
            int middle = (low + high) >>> 1;
            //the index of the middle number in the rotated array
            int realMiddle = (middle+rotateIndex) % n;
            //use the real middle index to get the number
            if (nums[realMiddle] == target) {
                //return the real middle index, not the middle index above
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