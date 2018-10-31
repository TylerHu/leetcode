package linkedlist;

/**
 * LeetCode328. Odd Even Linked List(https://leetcode.com/problems/odd-even-linked-list/)
 *
 * Given a singly linked list, group all odd nodes together followed by the even nodes. Please note here we are talking
 * about the node number and not the value in the nodes.
 * You should try to do it in place. The program should run in O(1) space complexity and O(nodes) time complexity.
 *
 * Solution: Define two pointers odd and even to point to odd nodes and even nodes respetively. For each pointer, skip it's
 * next node, so it will link it's next odd node or it's even node. At the end, link the end of the odd node list and the
 * head of the even node list together.
 */
public class OddEvenLinkedList {
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        //odd node pointer
        ListNode odd = head;
        //even node pointer
        ListNode even = head.next;
        //head of even node
        ListNode evenHead = head.next;
        while (even != null && even.next != null) {
            //skip even node
            odd.next = odd.next.next;
            //skip odd node
            even.next = even.next.next;
            odd = odd.next;
            even = even.next;
        }
        //linke odd node and even node together
        odd.next = evenHead;
        return head;
    }
}