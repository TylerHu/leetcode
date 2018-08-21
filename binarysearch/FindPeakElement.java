package binarysearch;

/**
 * LeetCode162. Find Peak Element(https://leetcode.com/problems/find-peak-element/description/)
 *
 * A peak element is an element that is greater than its neighbors.
 * Given an input array nums, where nums[i] ≠ nums[i+1], find a peak element and return its index.
 * The array may contain multiple peaks, in that case return the index to any one of the peaks is fine.
 * You may imagine that nums[-1] = nums[n] = -∞.
 *
 * Solution: Use binary search approach. If middle number is larger than next number, update high pointer to middle index.
 * Otherwise update low pointer to middle+1 index. When low >= high, means found the peak element, and return the low
 * pointer.
 */
public class FindPeakElement {
    public int findPeakElement(int[] nums) {
        int low = 0, high = nums.length - 1;
        while (low < high) {
            int middle = (low + high) >>> 1;
            if (nums[middle] > nums[middle+1]) {
                //middle greater than next number, means the peak on the left side
                high = middle;
            } else {
                //the peak on the right side
                low = middle+1;
            }
        }
        return low;
    }
}