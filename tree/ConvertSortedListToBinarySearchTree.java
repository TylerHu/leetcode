package tree;

/**
 * LeetCode109. Convert Sorted List to Binary Search Tree(https://leetcode.com/problems/convert-sorted-list-to-binary-search-tree/description/)
 *
 * Given a singly linked list where elements are sorted in ascending order, convert it to a height balanced BST.
 * For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of
 * every node never differ by more than 1.
 *
 * Solution: The basic idea is the same with leetcode 108. Find the middle node of the linked list, nodes before it are in
 * it's left subtree, nodes after it are in it's right subtree. And we could use two pointers "slow" and "fast"
 * to find the middle of the linked list.
 */
public class ConvertSortedListToBinarySearchTree {
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) {
            return null;
        }
        return toBST(head, null);
    }

    public TreeNode toBST(ListNode head, ListNode tail) {
        if (head == tail) {
            //reach the end
            return null;
        }
        ListNode slow = head, fast = head;
        while (fast != tail && fast.next != tail) {
            //fast pointer moves two steps
            fast = fast.next.next;
            //slow pointer moves one steps
            slow = slow.next;
        }
        //now slow pointer is at the middle of the list(head, tail)
        TreeNode node = new TreeNode(slow.val);
        //recursive in left subtree(head, slow)
        node.left = toBST(head, slow);
        //recursive in right subtree(slow.next, tail)
        node.right = toBST(slow.next, tail);
        return node;
    }
}