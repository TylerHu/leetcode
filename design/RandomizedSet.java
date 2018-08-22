package design;

/**
 * LeetCode380. Insert Delete GetRandom O(1)(https://leetcode.com/problems/insert-delete-getrandom-o1/description/)
 *
 * Design a data structure that supports all following operations in average O(1) time.
 * insert(val): Inserts an item val to the set if not already present.
 * remove(val): Removes an item val from the set if present.
 * getRandom: Returns a random element from current set of elements. Each element must have the same probability of being returned.
 *
 * Solution: Define a arraylist to store all the numbers, and define a hashmap to store the location of each number in the list.
 * When insert a value to the set, check whether the number is already in the map, if so, return false, otherwise, add the value to the
 * tail of the list, and put it into the map. When remove a value from the set, if the value is not in the map, return false. If the value
 * is in the map, get the location of this value in the list, if it's not the last number of the list, replace this number with the last
 * number of the list, and update the last number's location in the map. And then remove this value from the map, and remove the last
 * number of the list.
 */
public class RandomizedSet {
    Map<Integer, Integer> locations;
    List<Integer> numbers;
    Random random;
    /** Initialize your data structure here. */
    public RandomizedSet() {
        locations = new HashMap<>();
        numbers = new ArrayList<>();
        random = new Random();
    }

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if (locations.containsKey(val)) {
            return false;
        }
        numbers.add(val);
        locations.put(val, numbers.size()-1);
        return true;
    }

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if (!locations.containsKey(val)) {
            return false;
        }
        int loc = locations.get(val);
        if (loc < numbers.size() - 1) {
            //replace this value with the last number of the list, so the list does not contain this value anymore, and then remove
            //the duplicated last number
            int lastNumber = numbers.get(numbers.size() - 1);
            numbers.set(loc, lastNumber);
            //update the last number's location in the map
            locations.put(lastNumber, loc);
        }
        //remove this value from the map
        locations.remove(val);
        //remove last number of list
        numbers.remove(numbers.size()-1);
        return true;
    }

    /** Get a random element from the set. */
    public int getRandom() {
        return numbers.get(random.nextInt(numbers.size()));
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */