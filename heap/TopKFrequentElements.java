package heap;

/**
 * LeetCode347. Top K Frequent Elements(https://leetcode.com/problems/top-k-frequent-elements/description/)
 *
 * Given a non-empty array of integers, return the k most frequent elements.
 *
 * Solution: Use hash map to store appear times of each elements in the array. And define a new class FrequencyMap
 * to represent the number and it's appear times. Use priority queue to sort these frequencymaps according to their
 * frequncy value in reverse order. At the end, get the first k element of the priority queue, and put it into the result list.
 *
 * Another Solution is using bucket sort, put the number into corresponding bucket according to their appear times.
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

    public List<Integer> topKFrequent2(int[] nums, int k) {
        List<Integer> result = new ArrayList<>();
        List<Integer>[] bucket = new ArrayList[nums.length+1];
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int frequency = entry.getValue();
            //use appear times as array index
            if (bucket[frequency] == null) {
                bucket[frequency] = new ArrayList<>();
            }
            bucket[frequency].add(entry.getKey());
        }

        for (int i = nums.length; i >= 0 && result.size() < k; --i) {
            if (bucket[i] != null) {
                result.addAll(bucket[i]);
            }
        }
        return result;
    }
}