package array;

/**
 * LeetCode238. Product of Array Except Self(https://leetcode.com/problems/product-of-array-except-self/description/)
 * Given an array nums of n integers where n > 1,  return an array output such that output[i] is equal to the product of all the elements of nums except nums[i].
 * Note: Please solve it without division and in O(n).
 * Follow up:
 * Could you solve it with constant space complexity? (The output array does not count as extra space for the purpose of space complexity analysis.)
 *
 * Solution: To solve with in O(n) without division and with constant space, just do the product operation in two direction.
 * First calculate from left to rigth and store the product it's left element in current index. Second calulate from right to left using the previous result,
 * and keep update right.
 */
public class ProductOfArrayExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        result[0] = 1;
        for (int i = 1; i < n; ++i) {
            //calculate the left side result
            result[i] = result[i-1] * nums[i-1];
        }

        int right = 1;
        for (int i = n-1; i >= 0; --i) {
            //muplity the left side result with the right side result
            result[i] *= right;
            //update right
            right *= nums[i];
        }
        return result;
    }
}