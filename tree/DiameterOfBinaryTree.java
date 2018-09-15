package tree;

/**
 * LeetCode543. Diameter of Binary Tree(https://leetcode.com/problems/diameter-of-binary-tree/description/)
 *
 * Given a binary tree, you need to compute the length of the diameter of the tree. The diameter of a binary tree is the
 * length of the longest path between any two nodes in a tree. This path may or may not pass through the root.
 *
 * Solution: THe lonest path between two nodes is the sum of the length of left subtree and the length of right subtree.
 * So we could get the max depth of current node's left and right subtree, and keep track of the largest (left+right).
 */
public class DiameterOfBinaryTree {
    int max;
    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        maxDepth(root);
        return max;
    }

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        //left subtree depth
        int left = maxDepth(root.left);
        //right subtree depth
        int right = maxDepth(root.right);
        //update max
        max = Math.max(max, left+right);
        return Math.max(left, right) + 1;
    }
}