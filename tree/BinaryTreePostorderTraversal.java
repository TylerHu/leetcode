package tree;

/**
 * LeetCode145. Binary Tree Postorder Traversal(https://leetcode.com/problems/binary-tree-postorder-traversal/description/)
 *
 * Given a binary tree, return the postorder traversal of its nodes' values.
 *
 * Solution: The basic idea is the same with leetcode 94. Postorder traversal means traverse the tree in left->right->root
 * order. For the iterative way, define a linked list instead of arraylist, since we need to addFirst method to
 * add the value in a reverse order. And also push the right nodes. into the stack first, rather than left nodes.
 */
public class BinaryTreePostorderTraversal {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        postorder(result, root);
        return result;
    }

    public void postorder(List<Integer> list, TreeNode root) {
        if (root == null) {
            return;
        }
        postorder(list, root.left);
        postorder(list, root.right);
        list.add(root.val);
    }

    public List<Integer> postorderTraversal(TreeNode root) {
        //here we use linkedlist
        LinkedList<Integer> result = new LinkedList<>();
        if (root == null) {
            return result;
        }
        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                //use addFirst method to add value in reverse order
                result.addFirst(root.val);
                stack.push(root);
                root = root.right;
            }
            root = stack.pop();
            root = root.left;
        }
        return result;
    }
}