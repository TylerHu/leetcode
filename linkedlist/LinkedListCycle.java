package linkedlist;

/**
 * LeetCode141. Linked List Cycle
 *
 * Given a linked list, determine if it has a cycle in it.
 *
 * Soution: Define two pointer fast and slow, the fast pointer move two steps while the slow pointer move one step forward.
 * If there is a cycle in the list, these two pointers will meet at some point of the list.
 */
public class LinkedListCycle {
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                // has a cycle
                break;
            }
        }
        return slow == fast;
    }
}