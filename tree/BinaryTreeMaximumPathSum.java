package tree;

/**
 * LeetCode124. Binary Tree Maximum Path Sum(https://leetcode.com/problems/binary-tree-maximum-path-sum/description/)
 *
 * Given a non-empty binary tree, find the maximum path sum.
 * For this problem, a path is defined as any sequence of nodes from some starting node to any node in the tree along the
 * parent-child connections. The path must contain at least one node and does not need to go through the root.
 *
 * Solution: Traverse the tree in post order, and pick the max sum between left branch and right branch, and add it to current
 * value.
 */
public class BinaryTreeMaximumPathSum {
    int max = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        helper(root);
        return max;
    }

    public int helper(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = Math.max(0, helper(root.left));
        int right = Math.max(0, helper(root.right));
        //update max sum
        max = Math.max(max, left + right + root.val);
        //pick the max path between left branch and right branch
        return Math.max(left, right) + root.val;
    }

}