package heap;

/**
 * LeetCode373. Find K Pairs with Smallest Sums(https://leetcode.com/problems/find-k-pairs-with-smallest-sums/description/)
 *
 * You are given two integer arrays nums1 and nums2 sorted in ascending order and an integer k.
 * Define a pair (u,v) which consists of one element from the first array and one element from the second array.
 * Find the k pairs (u1,v1),(u2,v2) ...(uk,vk) with the smallest sums.
 *
 * Solution: The basic idea is the same with leetcode378, build a priority queue with the sum of first array and the first
 * element in second array(nums1[i]+nums2[0]). And then pop the smallest element from the queue, and put the sum of it's current element in
 * the first array and it's next element in the second array into the queue(nums1[i]+nums2[j+1]), until we have pop Math.min(k, m*n) times from
 * the queue.
 */
public class FindKPairsWithSmallestSum {
    public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        int m = nums1.length;
        int n = nums2.length;
        PriorityQueue<Tuple> queue = new PriorityQueue<>();
        List<int[]> result = new ArrayList<>();
        if(m == 0 || n == 0) {
            //avoid null pointer exception
            return result;
        }
        for (int i = 0; i < m; ++i) {
            //build from the first array and the first number in second array
            queue.offer(new Tuple(i, 0, nums1[i] + nums2[0]));
        }

        //Math.min(k, m*n) handle the corner case when there are not enough k pairs
        for (int index = 0; index < Math.min(k, m*n); index ++) {
            Tuple t = queue.poll();
            //put into the result
            result.add(new int[]{nums1[t.i], nums2[t.j]});
            if (t.j == n - 1) {
                continue;
            }
            //put it's next sum into the queue
            queue.offer(new Tuple(t.i, t.j+1, nums1[t.i] + nums2[t.j+1]));
        }
        return result;

    }

    //a Tuple represents the sum of numbers in two arrays
    class Tuple implements Comparable<Tuple> {
        //index in first array
        int i;
        //index in second array
        int j;
        //sum of nums1[i], and nums2[j]
        int val;

        public Tuple(int i, int j, int val) {
            this.i = i;
            this.j = j;
            this.val = val;
        }

        @Override
        public int compareTo(Tuple other) {
            return this.val - other.val;
        }
    }
}