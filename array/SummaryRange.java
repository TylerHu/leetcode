package array;

/**
 * LeetCode228. Summary Ranges(https://leetcode.com/problems/summary-ranges/description/)
 *
 * Given a sorted integer array without duplicates, return the summary of its ranges.
 */
public class SummaryRange {
    public List<String> summaryRanges(int[] nums) {
        List<String> result = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return result;
        }

        int start = 0;
        int end = 0;
        for (int i = 1; i < nums.length; ++i) { 
            if (nums[i] - nums[i-1] == 1) {
                end++;
            } else {
                if (end == start) {
                    result.add(String.valueOf(nums[start]));
                } else {
                    result.add(String.valueOf(nums[start]) + "->" + String.valueOf(nums[end]));
                }
                start = i;
                end = i;
            }
        }
        if (end == start) {
            result.add(String.valueOf(nums[start]));
        } else {
            result.add(String.valueOf(nums[start]) + "->" + String.valueOf(nums[end]));
        }
        return result;
}