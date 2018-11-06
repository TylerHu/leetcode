package linkedlist;

/**
 * LeetCode138. Copy List With Random pointer(https://leetcode.com/problems/copy-list-with-random-pointer/)
 *
 * A linked list is given such that each node contains an additional random pointer which could point to any node in the list or null.
 * Return a deep copy of the list.
 *
 * Solution: Use map to store each node and it's copy node's mapping. First init new random nodes with all the value
 * in the list. And then update these new nodes next and random field.
 */
public class CopyListWithRandomPointer {
    public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null) {
            return null;
        }
        Map<RandomListNode, RandomListNode> map = new HashMap<>();
        RandomListNode node = head;
        while (node != null) {
            //init new nodes with value
            map.put(node, new RandomListNode(node.label));
            node = node.next;
        }
        node = head;
        while (node != null) {
            //update next field
            //map.get(node) represents current node's deep copy
            //map.get(node.next) represents the deep copy of the next node of current node
            //map.get(node.random) represents the deep copy of the random node of current node
            map.get(node).next = map.get(node.next);
            //update random field
            map.get(node).random = map.get(node.random);
            node = node.next;
        }
        return map.get(head);
    }
}