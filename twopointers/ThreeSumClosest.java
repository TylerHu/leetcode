package twopointers;

/**
 * LeetCode16. 3Sum Closest(https://leetcode.com/problems/3sum-closest/description/)
 *
 * Given an array nums of n integers and an integer target, find three integers in nums such that the sum is closest to target.
 * Return the sum of the three integers. You may assume that each input would have exactly one solution.
 *
 * Solution: Sort the array first, so that we could use the two pointer solution. Iterate the array, and define two pointers,
 * start and end. Let start pointer as the next element of current iterating element, and let end as the last element.
 * When the sum of the current element, start element and end element is equal to the target, means we already found the
 * answer. If the sum is larger than the target, then move the end pointer towards to the begining to make the sum smaller,
 * otherwise, move the start pointer towards to the end to make the sum larger, so that the sum is getting closed to the
 * target.
 */
public class ThreeSumClosest {

    public int threeSumClosest(int[] nums, int target) {
        int result = 0;
        int difference = Integer.MAX_VALUE;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; ++i){
            int start = i + 1;
            int end = nums.length - 1;
            while (start < end) {
                int sum = nums[i] + nums[start] + nums[end];
                if (sum == target) {
                    //equal to the target, return the answer
                    return sum;
                } else if (sum > target) {
                    // larger then target, decrease end pointer;
                    end --;
                } else if (sum < target) {
                    // smaller than target, increase start pointer
                    start++;
                }
                if (Math.abs(target - sum) < difference) {
                    //replace the difference with a smaller one
                    difference = Math.abs(target-sum);
                    result = sum;
                }
            }
        }
        return result;
    }
}