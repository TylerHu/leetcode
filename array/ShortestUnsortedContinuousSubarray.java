package array;

/**
 * LeetCode581. Shortest Unsorted Continuous Subarray(https://leetcode.com/problems/shortest-unsorted-continuous-subarray/description/)
 *
 * Given an integer array, you need to find one continuous subarray that if you only sort this subarray in ascending order,
 * then the whole array will be sorted in ascending order, too.
 * You need to find the shortest such subarray and output its length.
 *
 * Solution: The idea is iterate through the array from the beginning to the end, and find the first number that make the array start falling,
 * then from that point, the array is surely unsorted, and find the minimum number from the point to the end of the array. Similary, iterate through
 * the array in an reversed order, and find the first number that make the array stop falling, then find the maximum number from that point
 * to the beginning of the array. And then traverse again from beginning of the array to find the first number that is bigger than the minimum number,
 * and mark the index as k. Traverse from the end of the array to find the first number that is smaller than the maximum number, and mark the index as
 * n. Finally, array[k,n] is the shortest unsorted continuous subarray, and it's length is n-k+1
 */
public class ShortestUnsortedContinuousSubarray {
    public int findUnsortedSubarray(int[] nums) {
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        boolean flag = false;
        for (int i = 1; i < nums.length; ++i) {
            if (nums[i] < nums[i-1]) {
                //the array start falling, become unsorted
                flag = true;
            }
            if (flag) {
                //store the minimum number from the falling point
                min = Math.min(min, nums[i]);
            }
        }
        flag = false;
        for (int i = nums.length-2; i >= 0; --i) {
            if (nums[i] > nums[i+1]) {
                //the array start rising
                flag = true;
            }
            if (flag) {
                //store the maximum number from the point
                max = Math.max(max, nums[i]);
            }
        }
        int k = 0, n = 0;
        for (k = 0; k < nums.length; ++k) {
            //find the first number that is bigger than minimum number
            if (nums[k] > min) {
                break;
            }
        }
        for (n = nums.length-1; n >= 0; --n) {
            //find the first number that is smaller than maximum number
            if (nums[n] < max) {
                break;
            }
        }
        return n - k < 0 ? 0 : n - k + 1;
    }
}