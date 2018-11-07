package linkedlist;

/**
 * LeetCode21. Merge Two Sorted List
 *
 * Merge two sorted linked lists and return it as a new list. The new list should be made by splicing together the nodes of the first two lists.
 *
 * Solution: The idea is quite simple, just compare every nodes in these two list, and set the smaller one as current node until
 * iterating all nodes in the lists.
 */
public class MergeTwoSortedList {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        //dummy node for final return
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                //assigin current node's next node
                current.next = l1;
                //move to next
                l1 = l1.next;
            } else {
                current.next = l2;
                l2 = l2.next;
            }
            //move to next
            current = current.next;
        }
        if (l1 != null) {
            //link to the remaining nodes
            current.next = l1;
        }
        if (l2 != null) {
            // link to the remaining nodes
            current.next = l2;
        }
        return dummy.next;
    }
}