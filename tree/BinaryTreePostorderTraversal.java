package tree;

/**
 * LeetCode145. Binary Tree Postorder Traversal(https://leetcode.com/problems/binary-tree-postorder-traversal/description/)
 *
 * Given a binary tree, return the postorder traversal of its nodes' values.
 *
 * Solution: The basic idea is the same with leetcode 94. Postorder traversal means traverse the tree in left->right->root
 * order.
 */
public class BinaryTreePostorderTraversal {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                result.add(root.val);
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            root = root.right;
        }
        return result;
    }
}