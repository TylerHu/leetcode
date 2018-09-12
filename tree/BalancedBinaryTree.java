package tree;

/**
 * LeetCode110. Balanced Binary Tree(https://leetcode.com/problems/balanced-binary-tree/description/)
 *
 * Given a binary tree, determine if it is height-balanced.
 * For this problem, a height-balanced binary tree is defined as:
 * a binary tree in which the depth of the two subtrees of every node never differ by more than 1.
 *
 * Solution: Get the depth of it left subtree and right subtree, and check whether their depth differ more than 1, if equal to
 * or less than 1, check their subtrees recursively.
 */
public class BalancedBinaryTree {
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        return Math.abs(depth(root.left) - depth(root.right)) <= 1 && isBalanced(root.left) && isBalanced(root.right);
    }

    public int depth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        //get it's max depth
        return Math.max(depth(root.left), depth(root.right)) + 1;
    }
}