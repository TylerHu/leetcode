package array;

/**
 * LeetCode152. Maximum Product Subarray
 *
 * Given an integer array nums, find the contiguous subarray within an array (containing at least one number) which has the largest product.
 *
 * Solution: Since when two numbers multiply a negative number, the result of the bigger number mulitply a negative number will be smaller than the
 * result of the smaller number multiply a negative number, we have to store the max product and min product of the last previous result. When looping
 * over the array, use the last previus result multiply the current number, and compare with current number, update the max product and min product
 * with the compare result. Note, when the current number is negative, swap the max product and min product.
 */
public class MaximumProductSubarray {
    public int maxProduct(int[] nums) {
        int max = nums[0], min = nums[0], res = nums[0];
        int temp = 0;
        for (int i = 1; i < nums.length; ++i) {
            //if nums[i] < 0, swap the max and min
            if (nums[i] < 0) {
                temp = max;
                max = min;
                min = temp;
            }
            max = Math.max(max * nums[i], nums[i]);
            min = Math.min(min * nums[i], nums[i]);
            res = Math.max(res, max);
        }
        return res;
    }
}