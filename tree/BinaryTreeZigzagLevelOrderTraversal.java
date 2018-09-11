package tree;

/**
 * LeetCode103. Binary Tree Zigzag Level Order Traversal(https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/description/)
 *
 * Given a binary tree, return the zigzag level order traversal of its nodes' values. (ie, from left to right, then right to left
 * for the next level and alternate between).
 *
 * Solution: The basic idea is when the current tree level is even, add the node to the end of the list, when the current tree
 * level is odd, add the node to the beginning of the list. And put current node's left and right children to the queue
 * for future traverse.
 */
public class BinaryTreeZigzagLevelOrderTraversal {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if (root == null) {
            return result;
        }
        //add the first root node to the queue
        queue.add(root);
        while(!queue.isEmpty()) {
            List<Integer> levelNodes = new ArrayList<>();
            //current level nodes count
            int nodes = queue.size();
            for (int i = 0; i < nodes; ++i) {
                //get all the nodes in current level
                TreeNode current = queue.poll();
                if (result.size() % 2 == 0) {
                    //level is even, add the node to the end of the list
                    levelNodes.add(current.val);
                } else {
                    //level is odd, add the node to the beginning of the list
                    //here we coud define levelNodes as a LinkedList, so that can use addFirst() method to reduce time complexity
                    levelNodes.add(0, current.val);
                }
                if (current.left != null) {
                    //add current node's left child to the queue
                    queue.offer(current.left);
                }
                if (current.right != null) {
                    //add current node's right child to the queue
                    queue.offer(current.right);
                }
            }
            result.add(levelNodes);
        }
        return result;
    }

    public List<List<Integer>> zigzagLevelOrder2(TreeNode root) {
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
        if (level % 2 == 0) {
            result.get(level).add(root.val);
        } else {
            result.get(level).add(0, root.val);
        }
        helper(result, root.left, level+1);
        helper(result, root.right, level+1);

    }
}