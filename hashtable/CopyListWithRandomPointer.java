package hashtable;

/**
 * LeetCode138. Copy List with Random Pointer(https://leetcode.com/problems/copy-list-with-random-pointer/description/)
 *
 * A linked list is given such that each node contains an additional random pointer which could point to any node in the list or null.
 * Return a deep copy of the list.
 *
 * Solution: Deap copy means copy every child nodes of the list, not just the reference, or just the head of the node. So we
 * could use a hash map to store a new list of the nodes, and then set all these nodes' next and random pointer to
 * the corresponding nodes in the map. At the end, return the head node in the map.
 */
public class CopyListWithRandomPointer {
    public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null) {
            return null;
        }
        Map<RandomListNode, RandomListNode> map = new HashMap<>();
        RandomListNode node = head;
        while(node != null) {
            //create new nodes with the same value
            map.put(node, new RandomListNode(node.label));
            node = node.next;
        }

        node = head;
        while (node != null) {
            //set new nodes next and random pointer
            map.get(node).next = map.get(node.next);
            map.get(node).random = map.get(node.random);
            node = node.next;
        }
        //return the head node in the map
        return map.get(head);
    }
}