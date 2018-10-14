package design;

/**
 * LeetCode460. LFU Cache(https://leetcode.com/problems/lfu-cache/)
 *
 * Design and implement a data structure for Least Frequently Used (LFU) cache. It should support the following operations: get and put.
 * get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
 * put(key, value) - Set or insert the value if the key is not already present. When the cache reaches its capacity,
 * it should invalidate the least frequently used item before inserting a new item. For the purpose of this problem,
 * when there is a tie (i.e., two or more keys that have the same frequency), the least recently used key would be evicted.
 * Follow up:
 * Could you do both operations in O(1) time complexity?
 *
 * Solution: Define three hash maps. Map vals store the key and value of the cache. Map counts store the key and it's used
 * times. Map lists store the keys that have the same frequency. Also define a variable min to represent the current least
 * frequency. For get a key operation, we should increase the key's used count in the counts map, and
 * remove it from the previous frequncy hash set in the map lists, add it to the last of the hash set that belongs to the
 * new count+1 in the map lists. For put operation, if the key is contained in the cache, just do a get operation for the
 * key, and put its new value to the map vals. If the key is not contained in the cache, and we reach to the capacity, we
 * should remove the first element from the hash set that is bonding to the least frequency in the map lists. And reset the
 * least frequency to 1.
 */
public class LFUCache {

    //store the key and value of the cache
    Map<Integer, Integer> vals;
    //store the key and it's used time(frequency)
    Map<Integer, Integer> counts;
    //store the frequency and keys that have the same frequency
    Map<Integer, LinkedHashSet<Integer>> lists;
    //represent the curret least frequency
    int min;
    int capacity;

    public LFUCache(int capacity) {
        this.capacity = capacity;
        vals = new HashMap<>();
        counts = new HashMap<>();
        lists = new HashMap<>();
        //init a new hash set to frequency 1
        lists.put(1, new LinkedHashSet<>());
        min = -1;
    }

    public int get(int key) {
        if (!vals.containsKey(key)) {
            return -1;
        }
        int count = counts.get(key);
        //increase used time by 1
        counts.put(key, count+1);
        lists.get(count).remove(key);
        if (count == min && lists.get(count).size() == 0) {
            //key is the least frequency element, update min
            min++;
        }
        if (lists.get(count+1) == null) {
            lists.put(count+1, new LinkedHashSet<>());
        }
        lists.get(count+1).add(key);
        return vals.get(key);
    }

    public void put(int key, int value) {
        if (capacity == 0) {
            return;
        }
        if (vals.containsKey(key)) {
            get(key);
            vals.put(key, value);
        } else {
            if (vals.size() >= capacity) {
                //get the least frequency and least recently key to te removed
                int removed = lists.get(min).iterator().next();
                lists.get(min).remove(removed);
                vals.remove(removed);
                counts.remove(removed);
            }
            //reset least frequency to 1
            min = 1;
            vals.put(key, value);
            counts.put(key, 1);
            lists.get(min).add(key);
        }
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */