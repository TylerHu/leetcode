package tree;

/**
 * LeetCode538. Convert BST to Greater Tree(https://leetcode.com/problems/convert-bst-to-greater-tree/description/)
 *
 * Given a Binary Search Tree (BST), convert it to a Greater Tree such that every key of the original BST is changed to
 * the original key plus sum of all keys greater than the original key in BST.
 *
 * Solution: The basic idea is simple, just traverse the tree in right->root->left order, so that it's in reversed order,
 * and store the sum of previous node, and then add the presum up to current node as it's new value.
 */
public class ConvertBSTToGreaterTree {
    int sum = 0;
    public TreeNode convertBST(TreeNode root) {
        if (root == null) {
            return root;
        }
        //traverse right tree first
        convertBST(root.right);
        //add presum to node's value
        root.val += sum;
        //update presum
        sum = root.val;
        //traverse left tree later
        convertBST(root.left);
        return root;
    }
}