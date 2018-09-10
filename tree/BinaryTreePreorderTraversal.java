package tree;

/**
 * LeetCode144. Binary Tree Preorder Traversal(https://leetcode.com/problems/binary-tree-preorder-traversal/description/)
 *
 * Given a binary tree, return the preorder traversal of its nodes' values.
 *
 * Solution: Just the same idea with leetcode 94 inorder traversal. Preorder traversal means traverse the tree in
 * root->left->right order.
 */
public class BinaryTreePreorderTraversal {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        preorder(result, root);
        return result;
    }

    public void preorder(List<Integer> list, TreeNode root) {
        if (root == null) {
            return;
        }
        list.add(root.val);
        preorder(list, root.left);
        preorder(list, root.right);
    }

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                //only one line difference with inorder solution
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