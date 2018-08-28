package dp;

/**
 * LeetCode337. House Robber III(https://leetcode.com/problems/house-robber-iii/description/)
 *
 * The thief has found himself a new place for his thievery again. There is only one entrance to this area, called the "root."
 * Besides the root, each house has one and only one parent house. After a tour, the smart thief realized that "all houses in this place
 * forms a binary tree". It will automatically contact the police if two directly-linked houses were broken into on the same night.
 * Determine the maximum amount of money the thief can rob tonight without alerting the police.
 *
 * Solution: This can be solve with dp approach, since we could divede this problem into subproblems, and have optimal structure.
 * For each tree node, you can rob this node or rob it's two children node, so the dp formula is:
 * dp = max(rob current node, rob it's left child + rob it's right child). And we could use map to store previouse values.
 */
public class HouseRobber3 {
    public int rob(TreeNode root) {
        return helper(root, new HashMap<>());
    }

    public int helper(TreeNode root, Map<TreeNode, Integer> map) {
        if (root == null) {
            return 0;
        }
        if (map.containsKey(root)) {
            return map.get(root);
        }
        int val = 0;
        if (root.left != null) {
            //rob the node's left grandchildren nodes
            val += helper(root.left.left, map) + helper(root.left.right, map);
        }
        if (root.right != null) {
            //rob the node's right grandchildren nodes
            val += helper(root.right.left, map) + helper(root.right.right, map);
        }
        //max(rob current node, rob node's left child + rob node's right child)
        val = Math.max(val+root.val, helper(root.left, map) + helper(root.right, map));
        map.put(root, val);
        return val;
    }
}