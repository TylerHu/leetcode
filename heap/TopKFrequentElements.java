package heap;

/**
 * LeetCode347. Top K Frequent Elements(https://leetcode.com/problems/top-k-frequent-elements/description/)
 *
 * Given a non-empty array of integers, return the k most frequent elements.
 *
 * Solution: Use hash map to store appear times of each elements in the array. And define a new class FrequencyMap
 * to represent the number and it's appear times. Use priority queue to sort these frequencymaps according to their
 * frequncy value in reverse order. At the end, get the first k element of the priority queue, and put it into the result list.
 */
public class TopKFrequentElements {
    public List<Integer> topKFrequent(int[] nums, int k) {
        List<Integer> result = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            //store each element's appear times
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        PriorityQueue<FrequencyMap> queue = new PriorityQueue<>();
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            queue.add(new FrequencyMap(entry.getKey(), entry.getValue()));
        }
        for (int i = 0; i < k; ++i) {
            //get the first k element of the queue
            result.add(queue.poll().num);
        }
        return result;
    }

    //represents the number and it's appear times
    class FrequencyMap implements Comparable<FrequencyMap> {
        int num;
        int frequency;

        public FrequencyMap(int num, int frequency) {
            this.num = num;
            this.frequency = frequency;
        }

        @Override
        public int compareTo(FrequencyMap other) {
            //sort in reverse order
            return other.frequency - this.frequency;
        }
    }
}