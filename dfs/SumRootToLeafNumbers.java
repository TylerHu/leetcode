package dfs;

/**
 * LeetCode 129. Sum Root to Leaf Numbers(https://leetcode.com/problems/sum-root-to-leaf-numbers/)
 *
 * Given a binary tree containing digits from 0-9 only, each root-to-leaf path could represent a number.
 * An example is the root-to-leaf path 1->2->3 which represents the number 123.
 * Find the total sum of all root-to-leaf numbers.
 *
 * Solution: Define a global variable 'total', when reaching the leaf of a tree, add the current path sum to this 'total' sum
 * After iterating all the nodes in the tree, return 'total' sum
 */
public class SumRootToLeafNumbers {

    public int sumNumbers(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return pathSum(root, 0);
    }

    public int pathSum(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }
        sum = sum * 10 + root.val;
        if (root.left == null && root.right == null) {
            return sum;
        }
        return pathSum(root.left, sum) + pathSum(root.right, sum);
    }
}