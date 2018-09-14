package tree;

/**
 * LeetCode437. Path Sum III(https://leetcode.com/problems/path-sum-iii/description/)
 *
 * You are given a binary tree in which each node contains an integer value.
 * Find the number of paths that sum to a given value.
 * The path does not need to start or end at the root or a leaf, but it must go downwards (traveling only from parent nodes to child nodes).
 * The tree has no more than 1,000 nodes and the values are in the range -1,000,000 to 1,000,000.
 *
 * Solution: Here we use two level recursive both in the pathSum function and findPath function.
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
}