package design;

/**
 * LeetCode381. Insert Delete GetRandom O(1) - Duplicates allowed
 * (https://leetcode.com/problems/insert-delete-getrandom-o1-duplicates-allowed/description/)
 *
 * Design a data structure that supports all following operations in average O(1) time.
 * Note: Duplicate elements are allowed.
 * insert(val): Inserts an item val to the collection.
 * remove(val): Removes an item val from the collection if present.
 * getRandom: Returns a random element from current collection of elements. The probability of each element being returned is linearly related to the number of same value the collection contains.
 *
 * Solution: Similar to leetcode 380, but this time, we use a map to store indices of each number.
 */
public class RandomizedCollection {
    List<Integer> numbers;
    Map<Integer, LinkedHashSet<Integer>> locations;
    Random random;

    /** Initialize your data structure here. */
    public RandomizedCollection() {
        numbers = new ArrayList<>();
        locations = new HashMap<>();
        random = new Random();
    }

    /** Inserts a value to the collection. Returns true if the collection did not already contain the specified element. */
    public boolean insert(int val) {
        boolean contain = locations.containsKey(val);
        if (!contain) {
            locations.put(val, new LinkedHashSet<Integer>());
        }
        //since numbers.add(val) is after locations.get(val).add(), so the location is numbers.size() not numbers.size() - 1
        locations.get(val).add(numbers.size());
        numbers.add(val);
        return !contain;
    }

    /** Removes a value from the collection. Returns true if the collection contained the specified element. */
    public boolean remove(int val) {
        if (!locations.containsKey(val)) {
            return false;
        }
        int loc = locations.get(val).iterator().next();
        //import! need to remove the location from the map first, because the location get from the map is the first index
        // of the number, so there is one case that the lastNumber maybe is equal to the val. If the location is not at the
        // end of the list, we will get the last number and remove it's last index, and add the new location to the set.
        // If we put this line of code after the "if condition", it will becomes
        // locations.get(lastNumber).add(loc); locations.get(val).remove(loc); here lastNumber maybe equal to val.
        locations.get(val).remove(loc);
        if (loc < numbers.size() - 1) {
            int lastNumber = numbers.get(numbers.size() - 1);
            //remove the last number's last index
            locations.get(lastNumber).remove(numbers.size() - 1);
            //add a new location to the last number's index
            locations.get(lastNumber).add(loc);
            //update the number at position loc to lastNumber
            numbers.set(loc, lastNumber);
        }
        //remove the last number in the list
        numbers.remove(numbers.size() - 1);
        if (locations.get(val).isEmpty()) {
            //if the number not in the list any more, remove it's index set
            locations.remove(val);
        }
        return true;
    }

    /** Get a random element from the collection. */
    public int getRandom() {
        return numbers.get(random.nextInt(numbers.size()));
    }
}

/**
 * Your RandomizedCollection object will be instantiated and called as such:
 * RandomizedCollection obj = new RandomizedCollection();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
}