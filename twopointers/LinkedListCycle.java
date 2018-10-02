package twopointers;

/**
 * LeetCode141. Linked List Cycle(https://leetcode.com/problems/linked-list-cycle/description/)
 *
 * Given a linked list, determine if it has a cycle in it.
 * Follow up:
 * Can you solve it without using extra space?
 *
 * Solution: Define two pointers slow and fast. Slow pointer move one step forward while fast pointer move two steps forward.
 * Check whether will these two pointers meet at some point inside the list. If so, it's a cycle linked list, if not. it's
 * not a cycle linked list.
 */
public class LinkedListCycle {
    public boolean hasCycle(ListNode head) {
        if (head == null) {
            return false;
        }
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null) {
            //move one step
            slow = slow.next;
            if (fast.next != null) {
                //move two steps
                fast = fast.next.next;
            } else {
                //not a cycle
                return false;
            }
            if (fast == slow) {
                //there is a cycle
                return true;
            }
        }
        return false;
    }
}