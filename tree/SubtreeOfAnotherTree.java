package tree;

/**
 * LeetCode572. Subtree of Another Tree(https://leetcode.com/problems/subtree-of-another-tree/description/)
 *
 * Given two non-empty binary trees s and t, check whether tree t has exactly the same structure and node values with a
 * subtree of s. A subtree of s is a tree consists of a node in s and all of this node's descendants. The tree s could
 * also be considered as a subtree of itself.
 *
 * Solution: Check current tree is the same with target tree, if yes, return true, if not, check it's left subtree and
 * it's right subtree
 */
public class SubtreeOfAnotherTree {
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if (s == null) {
            //check s is null first, in case of NullPointerException
            return false;
        }
        //check current tree
        if (isSame(s, t)) {
            return true;
        }
        //check left subtree and right subtree
        return isSubtree(s.left, t) || isSubtree(s.right, t);
    }

    public boolean isSame(TreeNode s, TreeNode t) {
        if (s == null && t == null) {
            return true;
        }
        if (s == null || t == null) {
            return false;
        }
        if (s.val != t.val) {
            return false;
        }
        //check whether left and right subtree are the same
        return isSame(s.left, t.left) && isSame(s.right, t.right);
    }
}