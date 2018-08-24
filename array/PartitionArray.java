package array;

/**
 * LeetCode561. Array Partition I(https://leetcode.com/problems/array-partition-i/description/)
 *
 * Given an array of 2n integers, your task is to group these integers into n pairs of integer, say (a1, b1), (a2, b2), ..., (an, bn)
 * which makes sum of min(ai, bi) for all i from 1 to n as large as possible.
 *
 * Solution: Sort the array first, and then sum all the even index numbers. The sum is the final result
 */
public class PartitionArray {
    public int arrayPairSum(int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        int sum = 0;
        Arrays.sort(nums);
        //iterate the even index numbers
        for (int i = 0; i < n; i+=2) {
            sum += nums[i];
        }
        return sum;
    }
}