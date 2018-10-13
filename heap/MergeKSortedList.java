package heap;

/**
 * LeetCode23. Merge k Sorted Lists(https://leetcode.com/problems/merge-k-sorted-lists/description/)
 *
 * Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.
 *
 * Solution: Build a priority queue from the first element in all the listnodes. Everytime pop the smallest element from
 * the queue, set the next pointer of the tail node to this element, and put it's next element into the queue until
 * the queue is empty.
 */
public class MergeKSortedList {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        //dummy node to avoid some corner check
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;

        //sort by the value in descendent order
        PriorityQueue<ListNode> queue = new PriorityQueue<ListNode>((a, b) -> a.val - b.val);
        for (ListNode node : lists) {
            if (node != null) {
                //build from the first element in all the listnodes
                queue.offer(node);
            }
        }

        while (!queue.isEmpty()) {
            ListNode node = queue.poll();
            //set next pointer of the tail node to current pop element
            tail.next = node;
            //move tail node forward
            tail = tail.next;

            if (tail.next != null) {
                //put current pop element's next element into the queue
                queue.offer(tail.next);
            }
        }
        return dummy.next;
    }
}