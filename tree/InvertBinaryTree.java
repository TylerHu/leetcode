package tree;

/**
 * LeetCode226. Invert Binary Tree(https://leetcode.com/problems/invert-binary-tree/description/)
 *
 * Invert a binary tree.
 *
 * Solution: Traverse the tree in preorder, and swap current node's left node and right node, and inverse it's
 * left and right subtree recursively.
 */
public class InvertBinaryTree {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        //swap root's left node and right node
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }
}