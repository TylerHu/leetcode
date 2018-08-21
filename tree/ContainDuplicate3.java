package tree;

/**
 * LeetCode220. Contains Duplicate III(https://leetcode.com/problems/contains-duplicate-iii/description/)
 *
 * Given an array of integers, find out whether there are two distinct indices i and j in the array such that the absolute
 * difference between nums[i] and nums[j] is at most t and the absolute difference between i and j is at most k
 *
 * Solution: Use tree set to maintain a window of size k for value querying. Treeset.floor returns the greatest key less than
 * or equal to the given key, TreeSet.ceiling returns the least key greater than or equal to the given key. So we could check
 * whether the floor and ceiling exists and floor >= nums[i] and ceiling <= nums[i].
 */
public class ContainDuplicate3 {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        int n = nums.length;
        if (n < 2) {
            return false;
        }
        TreeSet<Long> treeSet = new TreeSet<>();
        for (int i = 0; i < nums.length; ++i) {
            //floor returns the greatest key less than or equal to key(nums[i]+t)
            Long floor = treeSet.floor(Long.valueOf(nums[i])+t);
            //ceiling returns the least key greater than or equal to key(nums[i]-t)
            Long ceiling = treeSet.ceiling(Long.valueOf(nums[i])-t);
            if ((floor != null && floor >= nums[i])  || (ceiling != null && ceiling <= nums[i])) {
                return true;
            }
            treeSet.add(Long.valueOf(nums[i]));
            if (i >= k) {
                //slid the window, and keep it's size to k
                treeSet.remove(Long.valueOf(nums[i-k]));
            }
        }
        return false;
    }
}