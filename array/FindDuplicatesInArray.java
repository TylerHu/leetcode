package array;

/**
 * LeetCode442. Find All Duplicates in an Array(https://leetcode.com/problems/find-all-duplicates-in-an-array/description/)
 *
 * Given an array of integers, 1 ≤ a[i] ≤ n (n = size of array), some elements appear twice and others appear once.
 * Find all the elements that appear twice in this array.
 * Could you do it without extra space and in O(n) runtime?
 *
 * Solution: Similar to leetcode 448. The idea is mark the numbers that has seen to be negative,  if found an number that is negative, means that number
 * has appeared twice, and that's the number we are looking for.
 */
public class FindDuplicatesInArray {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < nums.length; ++i) {
            int val = Math.abs(nums[i]) - 1;
            if (nums[val] > 0) {
                //mark the number that first seen to be negative
                nums[val] = -nums[val];
            } else {
                //has seen before, add it to the result list
                result.add(Math.abs(nums[i]));
            }
        }
        return result;
    }
}