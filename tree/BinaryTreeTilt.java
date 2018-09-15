package tree;

/**
 * LeetCode563. Binary Tree Tilt(https://leetcode.com/problems/binary-tree-tilt/description/)
 *
 * Given a binary tree, return the tilt of the whole tree.
 * The tilt of a tree node is defined as the absolute difference between the sum of all left subtree node values and
 * the sum of all right subtree node values. Null node has tilt 0.
 * The tilt of the whole tree is defined as the sum of all nodes' tilt.
 *
 * Solution: Traverse the tree in post order left->right->root, and calulate it's left tree sum and right tree sum. And
 * the get the tilt of current node, and sum them up.
 */
public class BinaryTreeTilt {

    int tilt;
    public int findTilt(TreeNode root) {
        if (root == null) {
            return 0;
        }
        postOrder(root);
        return tilt;
    }

    public int postOrder(TreeNode root) {
        if (root == null) {
            return 0;
        }
        //left tree sum
        int left = postOrder(root.left);
        //right tree sum
        int right = postOrder(root.right);
        //sum up tilt
        tilt += Math.abs(left - right);
        //sum the subtree nodes
        return left + right + root.val;
    }
}