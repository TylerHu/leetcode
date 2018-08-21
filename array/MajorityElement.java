package array;

/**
 * LeetCode169. Majority Element(https://leetcode.com/problems/majority-element/description/)
 *
 * Given an array of size n, find the majority element. The majority element is the element that appears more than ⌊ n/2 ⌋ times.
 * You may assume that the array is non-empty and the majority element always exist in the array.
 *
 * Solution: There are many solutions to this question, like hashtable, sorting, bit manipulation and moore voting. Here I choose
 * the Moore Voting Algorithm to solve this problem, since it's very straight forward and easy to implement and run fast.
 */
public class MajorityElement {

    public int majorityElement(int[] nums) {
        int n = nums.length;
        int major = nums[0];
        int count = 0;
        for (int num : nums) {
            if (count == 0) {
                major = num;
                count = 1;
            } else if (num == major) {
                count++;
            } else {
                count--;
            }
        }
        return major;
    }
}