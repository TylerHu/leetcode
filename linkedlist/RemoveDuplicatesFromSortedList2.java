package linkedlist;

/**
 * LeetCode82. Remove Duplicates from Sorted List2(https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii/)
 *
 * Given a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list.
 *
 * Solution: Define a previous node and a current node. Check whether the value of current node is the same with it's next node.
 * If yes, move current node forward until they are not the same. And later, we could skip these duplicate nodes by setting
 * the next pointer of previous node to current node's next node.
 *
 */
public class RemoveDuplicatesFromSortedList2 {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;
        ListNode current = head;
        while (current != null) {
            while (current.next != null && current.val == current.next.val) {
                //keep move current node until adjent nodes are not the same
                current = current.next;
            }
            if (prev.next == current) {
                //no duplicates found in current iteration
                prev = current;
            } else {
                //some duplicates found, so skip them
                prev.next = current.next;
            }
            //move forward
            current = current.next;
        }
        return dummy.next;
    }
}