package dp;

/**
 * LeetCode95. Unique Binary Search Trees II(https://leetcode.com/problems/unique-binary-search-trees-ii/description/)
 *
 * Given an integer n, generate all structurally unique BST's (binary search trees) that store values 1 ... n.
 *
 * Solution: The idea is the same with leetcode96, that is picking one number i (1<=i<=n) from the sequence as the root
 * of the BST, as sequence [1,i-1] as its' left subtree, and sequence[i+1, n] as its' right subtree, do it recursivetly.
 */
public class UniqueBinarySearchTree2 {
    public List<TreeNode> generateTrees(int n) {
        if (n == 0) {
            return new ArrayList<>();
        }
        return helper(1, n);
    }

    public List<TreeNode> helper(int start, int end) {
        List<TreeNode> result = new ArrayList<>();
        if (start > end) {
            //to the end of the tree
            result.add(null);
            return result;
        }
        for (int i = start; i <= end; ++i) {
            //generate left subtrees with number i as the root
            List<TreeNode> leftSubtrees = helper(start, i-1);
            //generate right subtrees with number i as the root
            List<TreeNode> rightSubtrees = helper(i+1, end);

            for (TreeNode leftNode: leftSubtrees) {
                for (TreeNode rightNode : rightSubtrees) {
                    //combine the left subtrees and right subtrees together
                    //it's cartesian product 
                    TreeNode root = new TreeNode(i);
                    root.left = leftNode;
                    root.right = rightNode;
                    result.add(root);
                }
            }
        }
        return result;
    }
}