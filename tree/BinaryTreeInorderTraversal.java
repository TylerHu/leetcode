package tree;

/**
 * LeetCode94. Binary Tree Inorder Traversal(https://leetcode.com/problems/binary-tree-inorder-traversal/description/)
 *
 * Given a binary tree, return the inorder traversal of its nodes' values.
 *
 * Solution: Inorder means traverse the tree in left->root->right order. We could do it in a recursive way and iterative way.
 * When do it in a iterative way, we could use a stack to store it's left nodes.   
 */
public class BinaryTreeInorderTraversal {

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        inorder(result, root);
        return result;
    }

    //recursive
    public void inorder(List<Integer> list, TreeNode root) {
        if (root == null) {
            return;
        }
        inorder(list, root.left);
        list.add(root.val);
        inorder(list, root.right);
    }

    public List<Integer> inorderTraversal2(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        if (root == null) {
            return result;
        }
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            result.add(root.val);
            root = root.right;
        }
        return result;
    }

}