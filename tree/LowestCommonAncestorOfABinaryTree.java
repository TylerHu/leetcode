package tree;

/**
 * LeetCode236. Lowest Common Ancestor of a Binary Tree(https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/description/)
 *
 * Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.
 * According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes p and q as the
 * lowest node in T that has both p and q as descendants (where we allow a node to be a descendant of itself).”
 *
 * Solution: Find the root where p and q in difference subtree of tree rooted at root. If p and q exist in the Tree rooted at root, then return their LCA,
 * if neither p nor q exist in the tree rooted at root, return null, if only one of p and q exist in tree rooted at root, return it.
 */
public class LowestCommonAncestorOfBinaryTree {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        }

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if (left != null && right != null) {
            //both p and q exist in the tree rooted at root
            return root;
        }

        //only one of p and q exist in the tree rooted at root
        return left != null ? left : right;
    }
}