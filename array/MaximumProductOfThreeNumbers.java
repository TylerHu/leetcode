package array;

/**
 * LeetCode628. Maximum Product of Three Numbers(https://leetcode.com/problems/maximum-product-of-three-numbers/)
 *
 * Given an integer array, find three numbers whose product is maximum and output the maximum product.
 *
 * Solution: Find the first three largest number in the array, and first two smallest nnumber in the array. Compare
 * the product of these three largest number and the product of the these two smallest number with the largest number
 */
public class MaximumProductOfThreeNumbers {

    int max1 = Integer.MIN_VALUE, max2 = Integer.MIN_VALUE, max3 = Integer.MIN_VALUE, min1 = Integer.MAX_VALUE, min2 = Integer.MAX_VALUE;
    for (int num : nums) {
        if (num > max1) {
            // be careful about the update order
            max3 = max2;
            max2 = max1;
            max1 = num;
        } else if (num > max2) {
            max3 = max2;
            max2 = num;
        } else if (num > max3) {
            max3 = num;
        }

        if (num < min1) {
            min2 = min1;
            min1 = num;
        } else if (num < min2) {
            min2 = num;
        }
    }
    return Math.max(max1*max2*max3, max1*min1*min2);
}