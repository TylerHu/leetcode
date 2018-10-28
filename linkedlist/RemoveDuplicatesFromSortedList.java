package linkedlist;

/**
 * LeetCode83. Remove Duplicates from Sorted List(https://leetcode.com/problems/remove-duplicates-from-sorted-list/)
 *
 * Given a sorted linked list, delete all duplicates such that each element appear only once.
 *
 * Solution: The idea is simple, check whether current element's value is the same with it's next element's value, if yes,
 * skip next element by seting current element's next pointer to the second next element, until the next element's value is
 * not the same with current one. If no, keep looping over the linked list.
 */
public class RemoveDuplicatesFromSortedList {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode current = head;
        while (current != null) {
            //check whether the next element's value is the same with current one
            while (current.next != null && current.val == current.next.val) {
                //skip next element
                current.next = current.next.next;
            }
            //keep on looping
            current = current.next;
        }
        return head;
    }
}