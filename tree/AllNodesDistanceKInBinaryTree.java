package tree;

/**
 * LeetCode863. All Nodes Distance K in Binary Tree(https://leetcode.com/problems/all-nodes-distance-k-in-binary-tree/description/)
 *
 * We are given a binary tree (with root node root), a target node, and an integer value K.
 * Return a list of the values of all nodes that have a distance K from the target node.  The answer can be returned in any order.
 *
 * Solution: Use hash map to build a undirected graph using treenodes as vertices, and the parent-child relation as edges. And then
 * start from the target node to do BFS to find all vertices with distance k to it.
 */
public class AllNodesDistanceKInBinaryTree {
    //store a undirected graph
    Map<TreeNode, List<TreeNode>> map = new HashMap<>();
    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        List<Integer> result = new ArrayList<>();
        if (root == null || K < 0) {
            return result;
        }
        //build the undirected graph, start from root, and it's parent is null
        buildMap(root, null);
        Queue<TreeNode> queue = new LinkedList<>();
        //mark the node has been visited or not
        Set<TreeNode> visited = new HashSet<>();
        //BFS, start from target
        queue.offer(target);
        visited.add(target);
        while (!queue.isEmpty()) {
            int size = queue.size();
            if (K == 0) {
                //found distance K nodes
                for (int i = 0; i < size; ++i) {
                    //now all the nodes in the queue are distance K nodes
                    result.add(queue.poll().val);
                }
                return result;
            }

            for (int i = 0; i < size; ++i) {
                TreeNode current = queue.poll();
                //not distanc K nodes, add them to the queue, and marked visited
                for (TreeNode node : map.get(current)) {
                    if (!visited.contains(node)) {
                        queue.offer(node);
                        visited.add(node);
                    }
                }
            }
            //update K until K = 0
            K--;
        }
        return result;

    }

    public void buildMap(TreeNode node, TreeNode parent) {
        if (node == null) {
            return;
        }
        if (!map.containsKey(node)) {
            map.put(node, new ArrayList<>());
        }
        if (parent != null) {
            //build edges
            map.get(node).add(parent);
            map.get(parent).add(node);
        }
        //traverse left subtree
        buildMap(node.left, node);
        //traverse right subtree
        buildMap(node.right, node);
    }
}