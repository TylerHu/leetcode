package tree;

/**
 * LeetCode98. Validate Binary Search Tree(https://leetcode.com/problems/validate-binary-search-tree/description/)
 *
 * Given a binary tree, determine if it is a valid binary search tree (BST).
 * Assume a BST is defined as follows:
 *  The left subtree of a node contains only nodes with keys less than the node's key.
 *  The right subtree of a node contains only nodes with keys greater than the node's key.
 *  Both the left and right subtrees must also be binary search trees.
 *
 *  Solution: The basic idea is to use inorder iterate. Since when doing the inorder traversal the binary search tree,
 *  it's a sorted list at the end. If the current node's value is less than or equal to previous node's value, then
 *  it break the ordering, thus the tree is not a binary tree.
 *  Or we could do it in a recursive way, it's similar to inorder traversal, and it turns out to run faster than iterative
 *  way.
 */
public class ValidateBinarySearchTree {
    public boolean isValidBST(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode prev = null;
        //inorder traversal
        while(root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            //current node's value less than or equal to previous node's value, means this is not a binary search tree
            if (prev != null && root.val <= prev.val) {
                return false;
            }
            //update previous node to current node
            prev = root;
            root = root.right;
        }
        return true;
    }



    TreeNode prev = null;
    public boolean isValidBST2(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (!isValidBST(root.left)) {
            return false;
        }
        if (prev != null && root.val <= prev.val) {
            return false;
        }
        prev = root;
        if (!isValidBST(root.right)) {
            return false;
        }
        return true;
    }
}