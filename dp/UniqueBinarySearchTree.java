package dp;

/**
 * LeetCode96. Unique Binary Search Trees(https://leetcode.com/problems/unique-binary-search-trees/description/)
 *
 * Given n, how many structurally unique BST's (binary search trees) that store values 1 ... n?
 *
 * Solution: The essential idea is to build a BST from sequence[1,n], we can pick a number i (1<=i<=n) from the sequence
 * as the root, and sequence[i-1] is it's left subtree, sequence[i+1, n] is it's right subtree. The number of unique
 * BST with root i, is the cartesian product of the number of BST for it's left subtree and right subtree. Take [1,2,3,4,5,6,7]
 * as an example, and with 3 as the root, so we need to construct an unique BST for it's left subsequence[1,2], and another
 * unique BST for it's right subsequence[4,5,6], and then combine them together. So the dp formula is :
 * dp[i] += dp[j-1] * dp[i-j], (1<=j<=i, 1<=i<=n);
 */
public class UniqueBinarySearchTree {
    public int numTrees(int n) {
        if (n <= 0) {
            return 0;
        }
        int[] dp = new int[n+1];
        //init dp[0] as 1
        dp[0] = 1;
        dp[1] = 1;
        //i start from 2, and less to or equal to n
        for (int i = 2; i <= n; ++i) {
            // j start from 1, and less to or equal to i
            for (int j = 1; j <= i; ++j) {
                //cartesian product of left subtree and right subtree
                dp[i] += dp[j-1] * dp[i-j];
            }
        }
        return dp[n];
    }
}