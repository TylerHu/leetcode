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

    //total sum
    int total;
    public int sumNumbers(TreeNode root) {
        if (root == null) {
            return 0;
        }
        pathSum(root, 0);
        return total;

    }

    public void pathSum(TreeNode root, int sum) {
        //new sum from root to leaf
        sum = sum * 10 + root.val;
        if (root.left == null && root.right == null) {
            //add to total sum
            total += sum;
            return;
        }
        if (root.left != null) {
            pathSum(root.left, sum);
        }
        if (root.right != null) {
            pathSum(root.right, sum);
        }
    }
}