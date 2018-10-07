package twopointers;

/**
 * LeetCode167. Two Sum II - Input array is sorted(https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/description/)
 *
 * Given an array of integers that is already sorted in ascending order, find two numbers such that they add up to a specific
 * target number. The function twoSum should return indices of the two numbers such that they add up to the target,
 * where index1 must be less than index2.
 *
 * Note:
 * Your returned answers (both index1 and index2) are not zero-based.
 * You may assume that each input would have exactly one solution and you may not use the same element twice.
 *
 * Solution: Since it's a sorted array, we could define two pointers low and high, can sum up the numbers at these two
 * pointers. If current sum equals to target, return both indexes, if current sum is larger than target, move the high pointer
 * to the left, otherwise move the left pointer to the right
 */
public class TwoSum2 {
    public int[] twoSum(int[] numbers, int target) {
        int low = 0, high = numbers.length-1;
        while (low < high) {
            int sum = numbers[low] + numbers[high];
            if (sum == target) {
                return new int[]{low+1, high+1};
            } else if (sum < target) {
                //move left pointer to the right
                low++;
            } else {
                //move right pointer to the left
                high--;
            }
        }
        return new int[2];
    }
}