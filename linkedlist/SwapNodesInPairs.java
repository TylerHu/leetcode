package linkedlist;

/**
 * LeetCode24. Swap Nodes in Pairs(https://leetcode.com/problems/swap-nodes-in-pairs/)
 *
 * Given a linked list, swap every two adjacent nodes and return its head.
 * Example:
 * Given 1->2->3->4, you should return the list as 2->1->4->3.
 *
 * Note:
 * Your algorithm should use only constant extra space.
 * You may not modify the values in the list's nodes, only nodes itself may be changed.
 *
 * Solution: Define two nodes first and second to represent current pair nodes. At first current->first->second->third, then
 * first->third, second->first, current->second, so after transformation current->second->first->third, here we already
 * swap first and second node. After transformation, move current node to the first node again.
 */
public class SwapNodesInPairs {
    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode current = dummy;
        ListNode first;
        ListNode second;
        while (current.next != null && current.next.next != null) {
            //the first node in the pair
            first = current.next;
            //the secnd node in the pair
            second = current.next.next;
            //swap first and second
            first.next = second.next;
            second.next = first;
            current.next = second;
            //take the first node in the pair for next round
            current = first;
        }
        return dummy.next;
    }
}