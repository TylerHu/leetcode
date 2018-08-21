package hashtable;

/**
 * LeetCode217. Contains Duplicate(https://leetcode.com/problems/contains-duplicate/description/)
 *
 * Given an array of integers, find if the array contains any duplicates.
 * Your function should return true if any value appears at least twice in the array, and it should return false if every element is distinct.
 *
 * Solution: Quite simple, just use hashmap to store each number in the array, and check whether the number is already in the map.
 */
public class ContainDuplicate {
    public boolean containsDuplicate(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if (map.containsKey(num)) {
                return true;
            } else {
                map.put(num, 1);
            }
        }
        return false;
    }
}