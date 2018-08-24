package array;

/**
 * LeetCode448. Find All Numbers Disappeared in an Array(https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/description/)
 * Given an array of integers where 1 ≤ a[i] ≤ n (n = size of array), some elements appear twice and others appear once.
 * Find all the elements of [1, n] inclusive that do not appear in this array.
 * Could you do it without extra space and in O(n) runtime? You may assume the returned list does not count as extra space.
 *
 * Solution: The basic idea is mark all the numbers that has seen to be negative, and for the second iterating, find the numbers that are still
 * positive, and the index of these numbers plus one are the missing numbers.
 */
public class FindNumbersDisappearedInArray {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < nums.length; ++i) {
            int val = Math.abs(nums[i]) - 1;
            if (nums[val] > 0) {
                //mark the val as negative
                nums[val] = -nums[val];
            }
        }

        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] > 0) {
                //index+1 is the missing number
                result.add(i+1);
            }
        }
        return result;
    }
}