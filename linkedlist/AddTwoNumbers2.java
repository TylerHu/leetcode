package linkedlist;

/**
 * LeetCode 445. Add Two Numbers2(https://leetcode.com/problems/add-two-numbers-ii/)
 *
 * You are given two non-empty linked lists representing two non-negative integers. The most significant digit comes
 * first and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 * Follow up:
 * What if you cannot modify the input lists? In other words, reversing the lists is not allowed.
 *
 * Solution: The basic idea is similar to leetcode2. Since we can not reverse the list, we could do it in another way,
 * use stack to store the values in the lists. So we could get the value from the stack in the right order - The least
 * significant digit comes first.
 */
public class AddTwoNumbers2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();
        //push nodes in l1 into stack1
        while (l1 != null) {
            s1.push(l1.val);
            l1 = l1.next;
        }
        //push nodes in l2 into stack2
        while (l2 != null) {
            s2.push(l2.val);
            l2 = l2.next;
        }
        int carry = 0;
        //current node
        ListNode current = null;
        //prev node
        ListNode prev = null;
        while (!s1.isEmpty() ||!s2.isEmpty() || carry != 0) {
            int sum = (s1.isEmpty() ? 0 : s1.pop()) + (s2.isEmpty() ? 0 : s2.pop())+ carry;
            current = new ListNode(0);
            current.val = sum % 10;
            carry = sum / 10;
            current.next = prev;
            prev = current;
        }
        //return last current node as the head of the linked list
        return current;
    }
}