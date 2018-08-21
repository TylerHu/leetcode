package hashtable;

/**
 * LeetCode1. Two Sum(https://leetcode.com/problems/two-sum/description/)
 *
 *Given an array of integers, return indices of the two numbers such that they add up to a specific target.
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 *
 * Solution: Use hash map to store the index of each number in the array, and check whether there is anther number in the map
 * that the sum of these two numbers is equal to the target number.
 */
public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        if(nums == null || nums.length < 2) {
            return null;
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; ++i) {
            int remain = target - nums[i];
            //find the other number
            if (map.containsKey(remain)) {
                return new int[]{i, map.get(remain)};
            } else {
                map.put(nums[i], i);
            }
        }
        return null;
    }
}