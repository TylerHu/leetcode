package linkedlist;

/**
 * LeetCode2. Add Two Numbers(https://leetcode.com/problems/add-two-numbers/description/)
 *
 * You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit.
 * Add the two numbers and return it as a linked list.
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 *
 * Solution:
 * The key point here is using 0 instead when l1 is null or l2 is null,  and keep the loop going when the one of the following three conditions is matched:
 * l1 is not null , l2 is not null, or carry is not equal to zero. When the loop is over, return dummy.next as the result node.
 *
 */

import definition.ListNode;

class AddTwoNumbers {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        int carry = 0;
        while (l1 != null || l2 != null || carry != 0) {
            ListNode node = new ListNode(0);
            // when l1 is null or l2 is null, use 0 instead
            int sum = (l1 == null ? 0 : l1.val) + (l2 == null ? 0 : l2.val) + carry;
            node.val = sum % 10;
            carry = sum / 10;
            // set the next of current node to the new created node
            current.next = node;
            current = current.next;
            l1 = (l1 == null ? l1 : l1.next);
            l2 = (l2 == null ? l2 : l2.next);
        }
        return dummy.next;
    }
}
