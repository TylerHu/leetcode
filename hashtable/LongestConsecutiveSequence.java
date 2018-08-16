package hashtable;

/**
 * LeetCode128. Longest Consecutive Sequence(https://leetcode.com/problems/longest-consecutive-sequence/description/)
 *
 * Given an unsorted array of integers, find the length of the longest consecutive elements sequence.
 * Your algorithm should run in O(n) complexity.
 *
 * Solution: Use a hashmap to keep track of the sequence length when a new element is reached. For example, when element n is reached,
 * check whether it's neighbors (n-1) or (n+1) exists in the map, and get the value stored in the map as the left sequence length
 * and right sequence length around element n. Sum the left sequence length, the right sequence length and one to be the new length
 * of new sequence that include element n. And also update the length of the two sequences boundary in the map.
 */
public class LongestConsecutiveSequence {
    public int longestConsecutive(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int maxLength = 0;
        for (int i = 0; i < nums.length; ++i) {
            int n = nums[i];
            //avoid duplicate numbers
            if (map.containsKey(n)) {
                continue;
            }
            //the left sequence length
            int left = map.containsKey(n-1) ? map.get(n-1) : 0;
            //the right sequence length
            int right = map.containsKey(n+1) ? map.get(n+1) : 0;
            //new sequence length include number n
            int newLength = left + right + 1;
            map.put(n, newLength);
            //update boundary
            map.put(n-left, newLength);
            map.put(n+right, newLength);
            maxLength = Math.max(maxLength, newLength);
        }
        return maxLength;
    }
}