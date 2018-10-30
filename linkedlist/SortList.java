package linkedlist;

/**
 * LeetCode148. Sort List
 *
 * Sort a linked list in O(n log n) time using constant space complexity.
 *
 * Solution: Define two pointers "slow" and "fast" to divide the linked list into two part. Sort these two half part of
 * the list respectively, and then merge the result together. Do it recursively.
 */
public class SortList {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            //check whether head and head.next both not null, here we return head instead of null
            return head;
        }
        ListNode fast = head;
        ListNode slow = head;
        //Notice!!! Define a prev node to avoid stack over flow error
        ListNode prev = null;
        while (fast != null && fast.next != null) {
            //prev node point to current slow node
            prev = slow;
            //move slow node one step forward
            slow = slow.next;
            //move fast node two steps foward
            fast = fast.next.next;
        }
        //set the next pointer of prev node to null, so the first half of the list will end here, in case of stackOverFlow
        prev.next = null;
        //sort the first half of the list
        ListNode list1 = sortList(head);
        //sort the second half of the list
        ListNode list2 = sortList(slow);
        //merge the two part sorting result
        return merge(list1, list2);
    }

    public ListNode merge(ListNode list1, ListNode list2) {
        //fake head
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        while(list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                current.next = list1;
                list1 = list1.next;
            } else {
                current.next = list2;
                list2 = list2.next;
            }
            current = current.next;
        }
        if (list1 != null) {
            current.next = list1;
        }
        if (list2 != null) {
            current.next = list2;
        }
        return dummy.next;
    }
}