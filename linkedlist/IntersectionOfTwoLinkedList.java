package linkedlist;

/**
 * LeetCode160. Intersection of Two Linked List(https://leetcode.com/problems/intersection-of-two-linked-lists/)
 *
 * Write a program to find the node at which the intersection of two singly linked lists begins.
 *
 * For example, the following two linked lists:
 * A:          a1 → a2
 *                     ↘
 *                        c1 → c2 → c3
 *                     ↗
 * B:     b1 → b2 → b3
 * begin to intersect at node c1.
 * Notes:
 * If the two linked lists have no intersection at all, return null.
 * The linked lists must retain their original structure after the function returns.
 * You may assume there are no cycles anywhere in the entire linked structure.
 * Your code should preferably run in O(n) time and use only O(1) memory.
 *
 * Solution: The first solution is quite straigh forward, check the tail of those two list whether are the same or not. It tails
 * are not the same, thus there is no intersection. Also calculate the length of the two list. For the next iteration,
 * the longer length list can get a head start so that these two list can iterate at the same pace later.
 *
 * The second solution is that, in fact, we don't have to get the length of the lists. We could use two iteration, in the first
 * iteration, if we reach the tail of the list, we could reset it to the head of another list, and do the iteration again.
 */
public class IntersectionOfTwoLinkedList {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode nodeA = headA;
        ListNode nodeB = headB;
        int lengthA = 1;
        int lengthB = 1;
        //here we check nodeA.next not nodeA, since we have to get the tail of the list
        while (nodeA.next != null) {
            nodeA = nodeA.next;
            lengthA++;
        }
        while (nodeB.next != null) {
            nodeB = nodeB.next;
            lengthB++;
        }
        if (nodeA != nodeB) {
            //no intersection
            return null;
        }
        nodeA = headA;
        nodeB = headB;
        int diff = Math.abs(lengthA - lengthB);
        if (lengthA > lengthB) {
            for(int i = 0; i < diff; ++i) {
                nodeA = nodeA.next;
            }
        } else if (lengthA < lengthB) {
            for (int i = 0; i < diff; ++i) {
                nodeB = nodeB.next;
            }
        }
        while (nodeA != nodeB) {
            nodeA = nodeA.next;
            nodeB = nodeB.next;
        }
        return nodeA;
    }

    public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode nodeA = headA;
        ListNode nodeB = headB;

        //the iteration will be stop in two cases: nodeA and nodeB both are null, means we have reached the end of both two
        //list; nodeA and nodeB are the same but not null, means we found the intersection point
        while (nodeA != nodeB) {
            //reset A to the head of B
            nodeA = nodeA == null ? headB : nodeA.next;
            //resaet B to the head of A
            nodeB = nodeB == null ? headA : nodeB.next;
        }
        //nodeA can be null or the intersection node
        return nodeA;
    }
}