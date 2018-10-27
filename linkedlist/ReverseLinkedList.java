package linkedlist;

/**
 * LeetCode206. Reverse Linked List(https://leetcode.com/problems/reverse-linked-list/)
 *
 * Reverse a singly linked list.
 * Example:
 * Input: 1->2->3->4->5->NULL
 * Output: 5->4->3->2->1->NULL
 *
 * Solution: The idea is very straight forward, define a "prev" node to store previous element, and define a "next" node
 * to store current's next element. So set current element's next pointer point to previous element, and update previous
 * element to current element, move current lement to next element. Afterall, return the last previous element as the head
 * of the new list.
 */
public class ReverseLinkedList {
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        while (head != null) {
            //store current's next element
            ListNode next = head.next;
            //set current element's next pointer point to previous element
            head.next = prev;
            //update previous elemnet as current element
            prev = head;
            //move current element to next element
            head = next;
        }
        //return last previous element as the new head of the list
        return prev;
    }
}