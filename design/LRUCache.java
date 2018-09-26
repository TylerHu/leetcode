package design;

/**
 * LeetCode146. LRU Cache(https://leetcode.com/problems/lru-cache/description/)
 *
 * Design and implement a data structure for Least Recently Used (LRU) cache. It should support the following operations: get and put.
 * get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
 * put(key, value) - Set or insert the value if the key is not already present. When the cache reached its capacity,
 * it should invalidate the least recently used item before inserting a new item.
 * Follow up:
 * Could you do both operations in O(1) time complexity?
 *
 * Solution: The key to this problem is us double linked list to store nodes, so that we could add and delete nodes in 0(1) time
 * complexity, and use hashmap to store key and it's corresponding double linked list node.
 * For put operation, check whether the key is already in the map, if yes, remove the node from the
 * linked list, and add a new node to the head of the linked list, and also update the map with the new node. If no, and
 * reach the capacity, we need to remove the last element of the list, that is "tail.prev" node, and then add the new node
 * to the list and update map.
 * For get operation, if the key is already in the map, move it to the head of the list, that is : remove the correspoding
 * node, and add this node to the head of the list.
 */
class LRUCache {
    //double linked list node
    class Node {
        int key;
        int val;
        Node prev;
        Node next;

        public Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    //fake head and tail, it's convenient so that we don't need to do NULL check
    Node head = new Node(0, 0);
    Node tail = new Node(0, 0);
    // cache capacity
    int capacity;
    //store key and it's node
    Map<Integer, Node> map = new HashMap<>();

    public LRUCache(int capacity) {
        this.capacity = capacity;
        head.next = tail;
        tail.prev = head;
    }

    void put(int key, int val) {
        if (map.containsKey(key)) {
            //remove previous node
            remove(map.get(key));
            Node node = new Node(key, val);
            map.put(key, node);
            //add new node to the head of the list
            addFirst(node);
        } else {
            if (map.size() >= capacity) {
                //beyond capacity, remove least used element, that is remove the last element of the linked list
                map.remove(tail.prev.key);
                remove(tail.prev);
            }
            Node node = new Node(key, val);
            map.put(key, node);
            //add the new node to the head of the list
            addFirst(node);
        }
    }

    int get(int key) {
        int res = -1;
        if (map.containsKey(key)) {
            Node node = map.get(key);
            res = node.val;
            //move the node to the head of the list
            remove(node);
            addFirst(node);
        }
        return res;
    }

    void remove(Node node) {
        //remove node from linked list
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    void addFirst(Node node) {
        //add to the head of the linked list
        node.next = head.next;
        node.prev = head;
        head.next.prev = node;
        head.next = node;
    }

}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */