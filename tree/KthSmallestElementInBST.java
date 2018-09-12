package tree;

/**
 * LeetCode230. Kth Smallest Element in a BST(https://leetcode.com/problems/kth-smallest-element-in-a-bst/description/)
 *
 * Given a binary search tree, write a function kthSmallest to find the kth smallest element in it.
 * You may assume k is always valid, 1 ≤ k ≤ BST's total elements.
 *
 * Solution: Use the same idea with leetcode98. Inorder traverse the binary search tree, so it's a sorted list in ascending
 * order, and return the kth element of the list.
 */
public class KthSmallestElementInBST {
    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<>();
        int kthValue = 0;
        //inorder traversal
        while(root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            kthValue = root.val;
            if (--k == 0) {
                //found the kth element
                break;
            }
            root = root.right;
        }
        return kthValue;
    }
}