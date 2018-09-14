package tree;

/**
 * LeetCode104. Maximum Depth of Binary Tree(https://leetcode.com/problems/maximum-depth-of-binary-tree/description/)
 *
 * Given a binary tree, find its maximum depth.
 * The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
 *
 * Solution: The easist way is to get the maximum height of it's left and right subtree, and do it recursively. Another
 * solution is BFS, count how many levels have been traversed.
 */
public class MaximumDepthOfBinaryTree {

    public int maxDepth(TreeNode root) {
        if (root == null){
            return 0;
        }
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }


    public int maxDepth2(TreeNode root) {
        if (root == null){
            return 0;
        }
        int depth = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            //nodes count in current level
            int nodes = queue.size();
            for (int i = 0; i < nodes; ++i) {
                TreeNode current = queue.poll();
                //put current node's children into queue
                if (current.left != null) {
                    queue.offer(current.left);
                }
                if (current.right != null) {
                    queue.offer(current.right);
                }
            }
            //increase depth
            depth++;
        }
        return depth;

    }
}