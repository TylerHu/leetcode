package twopointers;

/**
 * LeetCode19. Remove Nth Node From End of List(https://leetcode.com/problems/remove-nth-node-from-end-of-list/description/)
 *
 * Given a linked list, remove the n-th node from the end of list and return its head.
 *
 * Solution: Define two pointers fast and slow. Move fast pointer n+1 steps forward, so that we could maintain a gap of
 * n distance between two pointers. And then move both fast and slow pointer at the same spped until the fast pointer reaches
 * to the end of the list, at this point, the slow pointer will be n+1 behind fast pointer, and it's next element is the right node to
 * be deleted, so slow.next = slow.next.next to skip it's next node. Here we define a fake start node to avoid some check.
 */
public class RemoveNthNodeFromEndOfList {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        //fake start node
        ListNode start = new ListNode(0);
        start.next = head;
        //init slow and fast pointer
        ListNode slow = start, fast = start;
        for (int i = 1; i <= n+1; ++i) {
            //move fast pointer n+1 steps forward
            fast = fast.next;
        }
        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }
        //skip the nth node from the end of the list
        slow.next = slow.next.next;
        return start.next;
    }
}