package twopointers;

/**
 * LeetCode61. Rotate List(https://leetcode.com/problems/rotate-list/description/)
 *
 * Given a linked list, rotate the list to the right by k places, where k is non-negative.
 *
 * Solution: Assume the length of the list is n, then the basic idea is move the nodes after k%n to the front of the list.
 * Define two pointers fast and slow. The fast pointer is used to figured out the length of the list. and the slow pointer
 * is used to find the last n-k%n node. And then do the rotation, here we also define a fake node named "dummy" for the
 * convenient of some check.
 */
public class RotateList {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || k == 0) {
            return head;
        }
        //fake node
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode fast = dummy;
        ListNode slow = dummy;
        //the length of the list
        int length = 0;
        while (fast.next != null) {
            fast = fast.next;
            length++;
        }
        for (int i = 0; i < length - k % length; ++i) {
            //get the n-k%n node
            slow = slow.next;
        }
        //the last node of the list point to the head of the list
        fast.next = dummy.next;
        //slow.next is the start of the roation, aka the new head of the list
        dummy.next = slow.next;
        //now slow.next is the last node of the list
        slow.next = null;
        return dummy.next;
    }
}