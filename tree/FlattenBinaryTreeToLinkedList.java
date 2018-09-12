package tree;

/**
 * LeetCode114. Flatten Binary Tree to Linked List(https://leetcode.com/problems/flatten-binary-tree-to-linked-list/description/)
 *
 * Given a binary tree, flatten it to a linked list in-place.
 *
 * Solution: The traverse order after flattening is root->left->right, which is preorder of the origin tree, [1->2->3->4->5->6].
 * If we traversed the flattened tree in a reversed order, that is right->left->root of the origin tree [6->5->4->3->2->1].
 * So we could traverse the origin tree in this "postorder" [6->5->4->3->2->1]. And set the right pointer to it's previous node,
 * i.e, 5's right pointer points to 6, 4's right pointer points to 5, etc. Set the left pointer to null. Then we could
 * get the final linkelist.
 */
public class FlattenBinaryTreeToLinkedList {
    TreeNode prev = null;

    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        //traverse in right->left->root order
        flatten(root.right);
        flatten(root.left);
        //set the right pointer to previous root
        root.right = prev;
        root.left = null;
        //update previous root to current node
        prev = root;
    }
}