package twopointers;

/**
 * LeetCode167. Two Sum II - Input array is sorted(https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/description/)
 *
 * Given an array of integers that is already sorted in ascending order, find two numbers such that they add up to a specific target number.
 * The function twoSum should return indices of the two numbers such that they add up to the target, where index1 must be less than index2.
 * Note: Your returned answers (both index1 and index2) are not zero-based.
 * You may assume that each input would have exactly one solution and you may not use the same element twice.
 *
 * Solution: Typical two pointers approach. Since it's a sorted array, when sum is bigger than target, just move the right pointer towards left,
 * otherwise, move the left pointer towards right.
 *
 */
public class TwoSumForSortedArray2 {
    public int[] twoSum(int[] numbers, int target) {
        int left = 0, right = numbers.length-1;
        while (left < right) {
            int sum = numbers[left] + numbers[right];
            if (sum == target) {
                return new int[]{left+1, right+1};
            } else if (sum > target) {
                right--;
            } else {
                left++;
            }
        }
        return null;
    }
}