package hashtable;

/**
 * LeetCode219. Contains Duplicate II(https://leetcode.com/problems/contains-duplicate-ii/description/)
 *
 * Given an array of integers and an integer k, find out whether there are two distinct indices i and j in the array such that nums[i] = nums[j]
 * and the absolute difference between i and j is at most k.
 *
 * Solution: Use hashmap to store the index of each number, and check whether the number is already in the map and the difference between these
 * two index is less than or equal to k. If yes, return true, If no, put the new index of the number into the map, and go on the looping.
 */
public class ContainDuplicate2 {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        int n = nums.length;
        if (n < 2) {
            return false;
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; ++i) {
            if(map.containsKey(nums[i]) && ((i - map.get(nums[i]) <= k))) {
                //found nums[i] = nums[j] and i-j <= k
                return true;
            } else {
                map.put(nums[i], i);
            }
        }
        return false;
    }
}