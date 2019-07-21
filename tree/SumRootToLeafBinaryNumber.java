package tree;

/**
 * 1022. Sum of Root To Leaf Binary Numbers(https://leetcode.com/problems/sum-of-root-to-leaf-binary-numbers/)
 *
 * Given a binary tree, each node has value 0 or 1.  Each root-to-leaf path represents a binary number starting with
 * the most significant bit.  For example, if the path is 0 -> 1 -> 1 -> 0 -> 1, then this could represent 01101 in binary, which is 13.
 * For all leaves in the tree, consider the numbers represented by the path from the root to that leaf.
 * Return the sum of these numbers
 *
 * Solution : Use DFS approach to traverse the tree from root to leaf, and along with the traversing, transfrom the
 * current binary into numbers. Sum up all the numbers in it's left and righ subtree.
 */
public class SumRootToLeafBinaryNumber {
    public int sumRootToLeaf(TreeNode root) {
        return dfs(root, 0);
    }

    public int dfs(TreeNode root, int val) {
        if (root == null) {
            return 0;
        }
        val = val * 2 + root.val;
        //root.left == null && root.right == null means root is the leaf node.
        return root.left == null && root.right == null ? dfs(root.left, val) + dfs(root.right, val);
    }
}