package tree;

/**
 * LeetCode101. Symmetric Tree(https://leetcode.com/problems/symmetric-tree/description/)
 *
 * Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).
 *
 * Solution: Check whether left.left = right.right and left.right = right.left
 */
public class SymmetricTree {
    public boolean isSymmetric(TreeNode root) {
        return helper(root, root);
    }

    public boolean helper(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        if (left == null || right == null) {
            return false;
        }
        if (left.val != right.val) {
            return false;
        }
        return helper(left.left, right.right) && helper(left.right, right.left);
    }
}