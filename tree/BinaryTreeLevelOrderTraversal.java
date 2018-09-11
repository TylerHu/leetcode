package tree;

/**
 * LeetCode102. Binary Tree Level Order Traversal(https://leetcode.com/problems/binary-tree-level-order-traversal/description/)
 *
 * Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).
 *
 * Solution: When do it in iterative way, use a queue to store current node's left and right children for next round looping.
 * When do it in recursive way, increase level count when traverse it's left and right children nodes.
 */
public class BinaryTreeLevelOrderTraversal {

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        //add the root node to the queue first
        queue.offer(root);
        while (!queue.isEmpty()) {
            //how many nodes in current level
            int nodes = queue.size();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < nodes; ++i) {
                //get all the nodes in current level
                TreeNode currentNode = queue.poll();
                list.add(currentNode.val);
                if(currentNode.left != null) {
                    queue.offer(currentNode.left);
                }
                if (currentNode.right != null) {
                    queue.offer(currentNode.right);
                }
            }
            result.add(list);
        }
        return result;
    }

    public List<List<Integer>> levelOrder2(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        helper(result, root, 0);
        return result;
    }

    public void helper(List<List<Integer>> result, TreeNode root, int level) {
        if (root == null) {
            return;
        }
        if (result.size() <= level) {
            List<Integer> list = new ArrayList<>();
            result.add(list);
        }
        result.get(level).add(root.val);
        helper(result, root.left, level+1);
        helper(result, root.right, level+1);
    }
}