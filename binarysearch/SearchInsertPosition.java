package binarysearch;

/**
 * LeetCode35. Search Insert Position(https://leetcode.com/problems/search-insert-position/description/)
 *
 * Given a sorted array and a target value, return the index if the target is found. If not, return the index where it
 * would be if it were inserted in order.You may assume no duplicates in the array.
 *
 * Solution: This problem can be easily solved by using the binary search approach, just a littble bit difference when
 * the target is not found is the array, return the start pointer as the insert position.
 */
public class SearchInsertPosition {

    public int searchInsert(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        //note that here start is equal to or less than end
        while (start <= end) {
            int middle = (start + end) / 2;
            if (nums[middle] == target) {
                return middle;
            } else if (nums[middle] > target) {
                end = middle-1;
            } else {
                start = middle+1;
            }
        }
        // return the start point, which the insert position of the target
        return start;
    }
}