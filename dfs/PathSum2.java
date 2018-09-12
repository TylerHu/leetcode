package tree;

/**
 * LeetCode113. Path Sum II(https://leetcode.com/problems/path-sum-ii/description/)
 *
 * Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.
 *
 * Solution: Push intermedia result into stack and save it to the result list if we found a path that (root.val == sum
 * && root.left == null && root.right == null). Pop the top element from the stack to try other paths.
 */
public class PathSum2 {
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        if (root == null) {
            return result;
        }
        Stack<Integer> path = new Stack<>();
        findPath(root, sum, path);
        return result;

    }

    public void findPath(TreeNode root, int sum, Stack<Integer> stack) {
        //push current root value into stack
        stack.push(root.val);
        if (root.val == sum && root.left == null && root.right == null) {
            //found it
            result.add(new ArrayList<Integer>(stack));
        }
        if (root.left != null) {
            findPath(root.left, sum - root.val, stack);
        }
        if (root.right != null) {
            findPath(root.right, sum - root.val, stack);
        }
        //pop the top element of the stack
        stack.pop();
    }
}