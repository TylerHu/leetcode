package design;

/**
 * LeetCode297. Serialize and Deserialize Binary Tree(https://leetcode.com/problems/serialize-and-deserialize-binary-tree/description/)
 *
 * Serialization is the process of converting a data structure or object into a sequence of bits so that it can be stored in a file or memory buffer,
 * or transmitted across a network connection link to be reconstructed later in the same or another computer environment.
 * Design an algorithm to serialize and deserialize a binary tree. There is no restriction on how your serialization/deserialization
 * algorithm should work. You just need to ensure that a binary tree can be serialized to a string and this string can be
 * deserialized to the original tree structure.
 *
 * Solution: When serialize a binary tree, preorder traverse the tree, and sperate each element with comma, and denote 'N' as
 * the end of the tree. When deserialize the string, split the string by comma into string array, and put it into queue.
 * Then we can construct the tree from this queue. 
 */
public class SerializeAndDeserializeBinaryTree {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        serializeTree(root, sb);
        return sb.toString();
    }

    public void serializeTree(TreeNode root, StringBuilder sb) {
        if (root == null) {
            sb.append("N").append(",");
        } else {
            sb.append(root.val).append(",");
            serializeTree(root.left, sb);
            serializeTree(root.right, sb);
        }
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null || data.length() == 0) {
            return null;
        }
        Queue<String> deque = new LinkedList<>();
        deque.addAll(Arrays.asList(data.split(",")));
        return buildTree(deque);
    }

    public TreeNode buildTree(Queue<String> nodes) {
        String current = nodes.remove();
        if (current.equals("N")) {
            return null;
        }
        TreeNode node = new TreeNode(Integer.valueOf(current));
        node.left = buildTree(nodes);
        node.right = buildTree(nodes);
        return node;

    }
}

// Your Codec object will be instantiated and called as such:
// SerializeAndDeserializeBinaryTree codec = new SerializeAndDeserializeBinaryTree();
// codec.deserialize(codec.serialize(root));