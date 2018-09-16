package tree;

/**
 * LeetCode617. Merge Two Binary Trees(https://leetcode.com/problems/merge-two-binary-trees/description/)
 *
 * Given two binary trees and imagine that when you put one of them to cover the other, some nodes of the two trees are
 * overlapped while the others are not.
 * You need to merge them into a new binary tree. The merge rule is that if two nodes overlap, then sum node values up
 * as the new value of the merged node. Otherwise, the NOT null node will be used as the node of new tree.
 *
 * Solution: Check whether current node is null, if it's null, use 0 as it's value instead, and null as it's left and
 * right child for next recursive call.
 */
public class MergeTwoBinaryTrees {
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) {
            return null;
        }
        //use zero as it's value if current node is null
        int val = (t1 == null ? 0 : t1.val) + (t2 == null ? 0 : t2.val);
        TreeNode root = new TreeNode(val);
        //use null as it's left child if current node is null
        root.left = mergeTrees(t1 == null ? null : t1.left, t2 == null ? null : t2.left);
        //use null as it's right child if current node is null
        root.right = mergeTrees(t1 == null ? null : t1.right, t2 == null ? null : t2.right);
        return root;
    }
}