package dp;

/**
 * LeetCode334. Increasing Triplet Subsequence(https://leetcode.com/problems/increasing-triplet-subsequence/description/)
 *
 * Given an unsorted array return whether an increasing subsequence of length 3 exists or not in the array.
 * Formally the function should:
 * Return true if there exists i, j, k
 *  such that arr[i] < arr[j] < arr[k] given 0 ≤ i < j < k ≤ n-1 else return false.
 *  Note: Your algorithm should run in O(n) time complexity and O(1) space complexity.
 *
 * Solution: Start with two largest number, as soon as we find a number larger than both, and both number have bean updated, return true
 *
 * Another solution is use the similar idea with leetcode300, and check where there is an increasing subsequence's length is 3, but the
 * run time complexity is O(nlogn)
 */
public class IncreasingTripletSubsequenc {
    public boolean increasingTriplet(int[] nums) {
        //maintain the smallest and "smallest greatest" number
        int min = Integer.MAX_VALUE, max = Integer.MAX_VALUE;
        for (int num : nums) {
            if (num <= min) {
                //num smaller than both number, update min
                min = num;
            } else if (num <= max) {
                //num smaller than larger number, update max
                max = num;
            } else {
                //num larger than both number, so min < max < num, return true
                return true;
            }
        }
        return false;
    }
}