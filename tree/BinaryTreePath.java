package tree;

/**
 * LeetCode257. Binary Tree Paths(https://leetcode.com/problems/binary-tree-paths/description/)
 *
 * Given a binary tree, return all root-to-leaf paths.
 *
 * Solution: Use recursive approach, if current node is leaf, add it to the path and also add the path to the result list.
 * If current node is not leaf, and it to the path and also "->". 
 */
public class BinaryTreePath {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        binaryTreePathsRecursive(root, "", result);
        return result;
    }

    public void binaryTreePathsRecursive(TreeNode root, String path, List<String> list) {
        if (root.left == null && root.right == null) {
            list.add(path + root.val);
        }
        if (root.left != null) {
            binaryTreePathsRecursive(root.left, path + root.val + "->", list);
        }
        if (root.right != null) {
            binaryTreePathsRecursive(root.right, path + root.val + "->", list);
        }
    }
}