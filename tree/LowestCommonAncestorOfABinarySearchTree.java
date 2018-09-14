package tree;

/**
 * LeetCode235. Lowest Common Ancestor of a Binary Search Tree(https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/description/)
 *
 * Given a binary search tree (BST), find the lowest common ancestor (LCA) of two given nodes in the BST.
 * According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes p and q as the
 * lowest node in T that has both p and q as descendants (where we allow a node to be a descendant of itself).”
 *
 * Solution: Since it's a BST, we can compare the root's value with p and q, if root's value greater than both p and q, then
 * the LCA must in the left subtree of root, if root's value less than both p and q, then the LCA must in the right subtree
 * of root, if root's value is between p and p, then it's the LCA of p and q.
 */
public class LowestCommonAncestorOfABinarySearchTree {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root.val > p.val && root.val > q.val) {
            //search the left subtree
            return lowestCommonAncestor(root.left, p, q);
        }
        if (root.val < p.val && root.val < q.val) {
            //search the right subtree
            return lowestCommonAncestor(root.right, p, q);
        }
        //root is between p and q
        return root;
    }
}