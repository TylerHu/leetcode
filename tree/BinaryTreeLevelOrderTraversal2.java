package tree;

/**
 * LeetCode107. Binary Tree Level Order Traversal II(https://leetcode.com/problems/binary-tree-level-order-traversal-ii/description/)
 *
 * Given a binary tree, return the bottom-up level order traversal of its nodes' values. (ie, from left to right, level by level from leaf to root).
 *
 * Solution: The idea is the same with leetcode 102, except that we use add list to the begin of the result each time
 * we going through a dedper level. For the recursive solution, every time when we define a new empty list, we add it
 * to the begin of the result, and also, when we get the corresponding list to current node, we use result.size() - level - 1 as
 * index to get the right list.
 */
public class BinaryTreeLevelOrderTraversal2 {

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        //here we use linkedlist so that we could use method addFirst instead of add(0, list)
        LinkedList<List<Integer>> result = new LinkedList<>();
        if (root == null) {
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()) {
            int nodes = queue.size();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < nodes; ++i) {
                TreeNode currentNode = queue.poll();
                list.add(currentNode.val);
                if (currentNode.left != null) {
                    queue.offer(currentNode.left);
                }
                if (currentNode.right != null) {
                    queue.offer(currentNode.right);
                }
            }
            result.addFirst(list);
        }
        return result;
    }

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        LinkedList<List<Integer>> result = new LinkedList<>();
        if (root == null) {
            return result;
        }
        helper(result, root, 0);
        return result;
    }

    public void helper(LinkedList<List<Integer>> result, TreeNode root, int level) {
        if (root == null) {
            return;
        }
        if (result.size() <= level) {
            List<Integer> list = new ArrayList<>();
            //use addFirst method to add to the begin of result
            result.addFirst(list);
        }
        //corresponding index is result.size()-level-1
        result.get(result.size() - level - 1).add(root.val);
        helper(result, root.left, level+1);
        helper(result, root.right, level+1);
    }
}