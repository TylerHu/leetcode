package heap;

/**
 * LeetCode692. Top K Frequent Words(https://leetcode.com/problems/top-k-frequent-words/description/)
 *
 * Given a non-empty list of words, return the k most frequent elements.
 * Your answer should be sorted by frequency from highest to lowest. If two words have the same frequency,
 * then the word with the lower alphabetical order comes first.
 *
 * Solution: The idea is the same with leetcode 347. Use priority queue to store all the words, and sort them according to
 * their appear times and the alphabetical order. At the end, get the first k element from the queue. Function topKFrequent
 * and topKFrequent2 are using the same idea, but it turned out that the second method runs faster than the first one.
 *
 */
public class TopKFrequentWords {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> map = new HashMap<>();
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        PriorityQueue<Map.Entry<String, Integer>> queue = new PriorityQueue<>((a, b) -> {
            if (a.getValue() == b.getValue()) {
                //if appear times are the same, compare their alphabetical order
                return a.getKey().compareTo(b.getKey());
            }
            //order by appear times
            return b.getValue() - a.getValue();
        });
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            queue.add(entry);
        }
        List<String> result = new ArrayList<>();
        while (k > 0) {
            //get the first k element from the queue
            result.add(queue.poll().getKey());
            k--;
        }
        return result;

    }

    public List<String> topKFrequent2(String[] words, int k) {
        List<String> result = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        PriorityQueue<Tuple> queue = new PriorityQueue<>();
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            queue.offer(new Tuple(entry.getKey(), entry.getValue()));
        }
        for (int i = 0; i < k && !queue.isEmpty(); ++i) {
            result.add(queue.poll().str);
        }
        return result;
    }

    class Tuple implements Comparable<Tuple> {
        String str;
        int count;

        public Tuple(String str, int count) {
            this.str = str;
            this.count = count;
        }

        @Override
        public int compareTo(Tuple other) {
            return other.count == this.count ? this.str.compareTo(other.str) : other.count - this.count;
        }
    }
}