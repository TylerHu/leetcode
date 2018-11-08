package linkedlist;

/**
 * LeetCode237. Delete Node in a linked list.
 *
 * Write a function to delete a node (except the tail) in a singly linked list, given only access to that node.
 *
 * Solution: It's a little tricky, since the method does not provide the head of the list, only the node to be deleted.
 * So we could update the node's value and it's next pointer.
 */
public class DeleteNodeInALinkedList {
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}