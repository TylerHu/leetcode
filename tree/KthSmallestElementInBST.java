package tree;

/**
 * LeetCode230. Kth Smallest Element in a BST(https://leetcode.com/problems/kth-smallest-element-in-a-bst/description/)
 *
 * Given a binary search tree, write a function kthSmallest to find the kth smallest element in it.
 * You may assume k is always valid, 1 ≤ k ≤ BST's total elements.
 *
 * Solution: Use the same idea with leetcode98. Inorder traverse the binary search tree, so it's a sorted list in ascending
 * order, and return the kth element of the list.
 * Also can do it in recursive way to traverse the tree in inorder and get the kth element.
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

    int count;
    int num;
    public int kthSmallest2(TreeNode root, int k) {
        count = k;
        inorder(root);
        return num;
    }

    public void inorder(TreeNode root) {
        if (root == null) {
            return;
        }
        inorder(root.left);
        //minus iterating times
        count--;
        if (count == 0) {
            //found it
            num = root.val;
        }
        inorder(root.right);
    }
}