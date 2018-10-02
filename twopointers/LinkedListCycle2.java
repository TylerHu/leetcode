package twopointers;

/**
 * LeetCode142. Linked List Cycle II(https://leetcode.com/problems/linked-list-cycle-ii/description/)
 *
 * Given a linked list, return the node where the cycle begins. If there is no cycle, return null.
 * Note: Do not modify the linked list.
 * Follow up:
 * Can you solve it without using extra space?
 *
 * Solution: Define two pointers slow and fast. Slow pointer moves one step forward while fast pointer moves two steps
 * forward. If slow pointer meets the fast pointer at some point, then it's a cycle linked list, otherwise it's not a
 * cycle list. If it's a cycle linked list, reset the slow pointer to the head, and move these two pointers one step
 * forward each, when they meet each other agin, the meeting point is hte start of the cycle.
 */
public class LinkedListCycle2 {
    public ListNode detectCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while(fast != null) {
            //slow pointer moves one steps
            slow = slow.next;
            if (fast.next != null) {
                //fast pointer moves two steps
                fast = fast.next.next;
            } else {
                break;
            }
            if (fast == slow) {
                //there is cycle
                break;
            }
        }
        if (fast != slow) {
            return null;
        }
        slow = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        //now the meeting point is the start of the cycle
        return slow;
    }
}