package tree;

/**
 * LeetCode687. Longest Univalue Path(https://leetcode.com/problems/longest-univalue-path/description/)
 *
 * Given a binary tree, find the length of the longest path where each node in the path has the same value.
 * This path may or may not pass through the root.
 *
 * Solution: The basic idea is the same with leetcode 543, except that at this time when geting the depth of
 * the tree, we need to check whether it's value is the same as it's parent's.
 */
public class LongestUnivaluePath {
    int max = 0;
    public int longestUnivaluePath(TreeNode root) {
        if (root == null) {
            return 0;
        }
        maxDepth(root, root.val);
        return max;
    }

    public int maxDepth(TreeNode root, int val) {
        if (root == null) {
            return 0;
        }
        //get the left subtree depth
        int left = maxDepth(root.left, root.val);
        //get the right subtree depth
        int right = maxDepth(root.right, root.val);
        //update max diameter
        max = Math.max(max, left+right);
        if (root.val == val) {
            //value is the same as it's parent
            return Math.max(left, right) + 1;
        }
        return 0;
    }
}