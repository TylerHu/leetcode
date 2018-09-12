package tree;

/**
 * LeetCode112. Path Sum(https://leetcode.com/problems/path-sum/description/)
 *
 * Given a binary tree and a sum, determine if the tree has a root-to-leaf path such that adding up all the values along the path equals the given sum.
 *
 * Solution: Just check current root's left subtree or right subtree that can add up to given sum or not. Remember it should be
 * root-to-leaf, so the ending condition is sum == root.val && root.left == null && root.right == null. And also keep in
 * mind that the value in each node can be negative.
 */
public class PathSum {
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        if (sum == root.val && root.left == null && root.right == null) {
            //found it
            return true;
        }
        //recursive call
        return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
    }
}