package tree;

/**
 * LeetCode111. Minimum Depth of Binary Tree(https://leetcode.com/problems/minimum-depth-of-binary-tree/description/)
 *
 * Given a binary tree, find its minimum depth.
 * The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.
 *
 * Solution: Use recursive approach, get the minimum of left subtree depth and right subtree depth, and plus 1. There
 * is one case need to be mentioned, that is when left subtree depth is 0 or right subtree depth is 0, return the
 * unzero depth plus 1
 */
public class MinimumDepthOfBinaryTree {
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = minDepth(root.left);
        int right = minDepth(root.right);
        //special case left is zero or right zero
        return (left == 0 || right == 0) ? left+right+1 : Math.min(left, right) + 1;
    }
}