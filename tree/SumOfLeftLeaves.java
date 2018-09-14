package tree;

/**
 * LeetCode404. Sum of Left Leaves(https://leetcode.com/problems/sum-of-left-leaves/description/)
 *
 * Find the sum of all left leaves in a given binary tree.
 *
 * Solution: Check whether current node is the left leave, if yes, sum them up, if not continue looking at it's left and
 * right subtree. Or we could use DFS approach, and check whether current node is the left leave, if yes, sum them up,
 * if not, and it's also not a right leave, push it into the stack.
 */
public class SumOfLeftLeaves {
    public int sumOfLeftLeaves(TreeNode root) {
        int sum = 0;
        if (root == null) {
            return sum;
        }
        if (root.left != null) {
            if (root.left.left == null && root.left.right == null) {
                //current node is the left leaves
                sum += root.left.val;
            } else {
                //recursive in it's left subtree
                sum += sumOfLeftLeaves(root.left);
            }
        }
        //recursive in it's right subtree
        sum += sumOfLeftLeaves(root.right);
        return sum;
    }

    public int sumOfLeftLeaves2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int sum = 0;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (node.left != null) {
                if (node.left.left == null && node.left.right == null) {
                    //node is the left leave
                    sum += node.left.val;
                } else {
                    //node is not the left leave
                    stack.push(node.left);
                }
            }
            if (node.right != null) {
                if (node.right.left != null || node.right.right != null) {
                    //node is not the left leave nor the right leave
                    stack.push(node.right);
                }
            }
        }
        return sum;
    }
}