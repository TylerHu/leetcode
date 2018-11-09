package linkedlist;

/**
 * LeetCode876. Middle of the Linked List(https://leetcode.com/problems/middle-of-the-linked-list/)
 *
 * Given a non-empty, singly linked list with head node head, return a middle node of linked list.
 * If there are two middle nodes, return the second middle node.
 *
 * Solution: This is a typical two pointer problem. Define two pointers fast and slow, the fast pointer moves two step
 * forward each time, while the slow pointer moves one step, when the fast pointer reaches to the end of the list, the
 * slow pointer points to the middle of the linked list. So just return the current slow pointer.
 * */
public class MiddleOfTheLinkedList {
    public ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}