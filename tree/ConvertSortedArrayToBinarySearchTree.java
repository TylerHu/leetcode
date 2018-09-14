package tree;

/**
 * LeetCode108. Convert Sorted Array to Binary Search Tree(https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/description/)
 *
 * Given an array where elements are sorted in ascending order, convert it to a height balanced BST.
 * For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every
 * node never differ by more than 1.
 *
 * Solution: As for a sorted array, the elements before i is a left subtree of the tree rooted at ith element,
 * and the elements after i is a right subtree of the tree rooted at ith element. And to make it a height balaned BST, we
 * pick the middle number as the root node.
 */
public class ConvertSortedArrayToBinarySearchTree {
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums.length == 0) {
            return null;
        }
        return toBST(nums, 0, nums.length - 1);
    }

    public TreeNode toBST(int[] nums, int low, int high) {
        if (low > high) {
            return null;
        }
        int middle = (low + high) / 2;
        //use the middle number as root to make it a balanced BST
        TreeNode node = new TreeNode(nums[middle]);
        //build the left subtree
        node.left = toBST(nums, low, middle - 1);
        //build the right subtree
        node.right = toBST(nums, middle + 1, high);
        return node;
    }
}