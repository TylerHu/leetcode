package linkedlist;

/**
 * LeetCode234. Palindrome Linked List(https://leetcode.com/problems/palindrome-linked-list/)
 *
 * Given a singly linked list, determine if it is a palindrome.
 *
 * Solution: First, use two pointer approach to find the middle node of the linked list.  Now we have two half of the list,
 * the first half is nodes before middle node, and the second half is nodes after middle node. Reverse the second half
 * linked list, and compare the reverse result with the first half linked list. If nodes in these two list are the same,
 * then it's a palindrome linked list, if not, return false.
 */
public class PalindromeLinkedList {
    public boolean isPalindrome(ListNode head) {
        if (head == null) {
            return true;
        }
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        if (fast != null) {
            //handle the length of the linked list is even situation, the middle node is the next node
            slow = slow.next;
        }
        //reverse second half
        slow = reverse(slow);
        fast = head;
        while(slow != null) {
            //compare the first half with the reverse result
            if (slow.val != fast.val) {
                return false;
            }
            slow = slow.next;
            fast = fast.next;
        }
        return true;
    }

    public ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode current = head;
        ListNode next = null;
        while(current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;
    }
}