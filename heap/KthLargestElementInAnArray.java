package heap;

/**
 * LeetCode215. Kth Largest Element in an Array(https://leetcode.com/problems/kth-largest-element-in-an-array/description/)
 *
 * Find the kth largest element in an unsorted array. Note that it is the kth largest element in the sorted order,
 * not the kth distinct element.
 *
 * Solution: Define a min heap, and keep it's size to k, everytime when put a new element into the heap, check it's size is
 * whether exceed k or not, if the queue size is larger than k, than pop the top element of the queue, and the queue will
 * always contains k largest element. At the end, pop the top element of the queue, and that is the kth largest element.
 */
public class KthLargetElementInAnArray {
    public int findKthLargest(int[] nums, int k) {
        //min heap
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int num : nums) {
            //put all the numbers into the queue
            queue.offer(num);
            if (queue.size() > k) {
                //keep the size of queue to k, so the queue will always contains k largest element
                queue.poll();
            }
        }
        //the top element is the kth largest element
        return queue.peek();
    }
}