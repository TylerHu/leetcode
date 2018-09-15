package tree;

/**
 * LeetCode437. Path Sum III(https://leetcode.com/problems/path-sum-iii/description/)
 *
 * You are given a binary tree in which each node contains an integer value.
 * Find the number of paths that sum to a given value.
 * The path does not need to start or end at the root or a leaf, but it must go downwards (traveling only from parent nodes to child nodes).
 * The tree has no more than 1,000 nodes and the values are in the range -1,000,000 to 1,000,000.
 *
 * Solution: Here we use two level recursive both in the pathSum function and findPath function. Or we could do it in a
 * more efficient way, use presum approach.
 *
 */
public class PathSum3 {
    public int pathSum(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }
        //Careful here the last two part are calling pathSum itself
        return findPath(root, sum) + pathSum(root.left, sum) + pathSum(root.right, sum);
    }

    public int findPath(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }
        return (root.val == sum ? 1 : 0) + findPath(root.left, sum - root.val) + findPath(root.right, sum - root.val);
    }

    public int pathSum2(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }
        Map<Integer, Integer> preSum = new HashMap<>();
        //init presum
        preSum.put(0, 1);
        return helper(root, 0, sum, preSum);
    }

    public int helper(TreeNode root, int curSum, int target, Map<Integer, Integer> preSum) {
        if (root == null) {
            return 0;
        }
        curSum += root.val;
        int res = preSum.getOrDefault(curSum-target, 0);
        preSum.put(curSum, preSum.getOrDefault(curSum, 0) + 1);

        res += helper(root.left, curSum, target, preSum) + helper(root.right, curSum, target, preSum);
        preSum.put(curSum, preSum.get(curSum) - 1);
        return res;
    }
}