package linkedlist;

/**
 * LeetCode203. Remove Linked List Elements(https://leetcode.com/problems/remove-linked-list-elements/description/)
 *
 * Remove all elements from a linked list of integers that have value val.
 *
 * Solution: Use a dummy node as a previous node, whose next pointer is the head node. Iterate the linked list, when the current
 * node's value is equal to the target value, set the next pointer of the previous node to the next pointer of the current node.
 * Otherwise, set previous to it's next pointer. And set current node to it's next node. When done. return dummy.next, which is the
 * head of the linked list.
 */
public class RemoveLinkedListElements {
    public ListNode removeElements(ListNode head, int val) {
        ListNode dummy = new ListNode(0);
        ListNode prev = dummy;
        dummy.next = head;
        ListNode current = head;
        while (current != null) {
            if (current.val == val) {
                //jump over the current node
                prev.next = current.next;
            } else {
                prev = prev.next;
            }
            current = current.next;
        }
        return dummy.next;
    }
}