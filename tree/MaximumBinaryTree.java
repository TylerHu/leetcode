package tree;

/**
 * LeetCode654. Maximum Binary Tree(https://leetcode.com/problems/maximum-binary-tree/)
 *
 * Given an integer array with no duplicates. A maximum tree building on this array is defined as follow:
 * The root is the maximum number in the array.
 * The left subtree is the maximum tree constructed from left part subarray divided by the maximum number.
 * The right subtree is the maximum tree constructed from right part subarray divided by the maximum number.
 * Construct the maximum tree by the given array and output the root node of this tree.
 *
 * Solution: Use recursive approach, check maximum number in the current array between start and end index. Build
 * it's left subtree by it's left subarray, build it's right subtree by it's right subarray.
 */
public class MaximumBinaryTree {

    public TreeNode constructMaximumBinaryTree(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        return helper(nums, 0, nums.length - 1);
    }

    public TreeNode helper(int[] nums, int start, int end) {
        if (start > end) {
            //stop recursive
            return null;
        }
        int max = Integer.MIN_VALUE;
        int index = start;
        // end inclusive
        for (int i = start; i <= end; ++i) {
            if (nums[i] > max) {
                max = nums[i];
                index = i;
            }
        }
        TreeNode node = new TreeNode(max);
        node.left = helper(nums, start, index-1);
        node.right = helper(nums, index+1, end);
        return node;
    }
}