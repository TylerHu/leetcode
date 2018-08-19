package bitmanipulation;

/**
 * LeetCode268. Missing Number(https://leetcode.com/problems/missing-number/description/)
 *
 * Given an array containing n distinct numbers taken from 0, 1, 2, ..., n, find the one that is missing from the array.
 *
 * Solution: The key point here is a xor a is 0, and 0 xor b is b, so a xor a xor b is b. In a complete array, xor all the index
 * and numbers, the result should be zero, and for a missing array, the result will the missing number, because there is only one
 * of that missing number in the xor operation.
 * Also this problem can be solved in a math approach. Since the sum of a complete array including numbers 0....n is n * (n+1) / 2,
 * the missing number will be n * (n+1) / 2 - currentSum. Note that this kind of approach may be overflow, even though the time complexity
 * is the same 0(n). I still prefer the bit manipulation one, it's for efficiently.
 */
public class MissingNumber {
    public int missingNumber(int[] nums) {
        int res = 0;
        int i = 0;
        for (i = 0; i < nums.length; ++i) {
            //xor all the index and numbers
            res = res ^ i ^ nums[i];
        }
        //corner case, since the array length is n-1, still has to xor the last index i which is n
        return res ^ i;
    }

    public int missingNumber2(int[] nums) {
        int sum = 0;
        int n = nums.length;
        for (int num : nums) {
            sum += num;
        }
        return n * (n+1) / 2 - sum;
    }
}