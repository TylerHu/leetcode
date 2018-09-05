package dp;

/**
 * LeetCode646. Maximum Length of Pair Chain(https://leetcode.com/problems/maximum-length-of-pair-chain/description/)
 *
 * You are given n pairs of numbers. In every pair, the first number is always smaller than the second number.
 * Now, we define a pair (c, d) can follow another pair (a, b) if and only if b < c. Chain of pairs can be formed in this fashion.
 * Given a set of pairs, find the length longest chain which can be formed. You needn't use up all the given pairs. You can select pairs in any order.
 *
 * Solution: Sort the array according to it's second number. And then iterate through the array, check whether current pair's
 * first number is larger than the second number of the last pair in the chain.
 */
public class MaximumLengthOfPairChain {
    public int findLongestChain(int[][] pairs) {
        //sort the array according to the second number
        Arrays.sort(pairs, (a, b) -> a[1] - b[1]);
        int max = 0;
        //keep track of the second number of the last pair in the chain
        int pre = Integer.MIN_VALUE;
        for (int[] pair : pairs) {
            //check whether current pair's first number is larger than previous second number
            if (pair[0] > pre) {
                max++;
                //update previous second number
                pre = pair[1];
            }
        }
        return max;
    }
}