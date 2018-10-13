package design;

/**
 * LeetCode295. Find Median from Data Stream(https://leetcode.com/problems/find-median-from-data-stream/description/)
 *
 * Median is the middle value in an ordered integer list. If the size of the list is even, there is no middle value.
 * So the median is the mean of the two middle value.
 * For example,
 * [2,3,4], the median is 3
 * [2,3], the median is (2 + 3) / 2 = 2.5
 * Design a data structure that supports the following two operations:
 * void addNum(int num) - Add a integer number from the data stream to the data structure.
 * double findMedian() - Return the median of all elements so far.
 *
 * Solution: Define two heap: max heap and min heap. The max heap store the values in the left half of the data stream in
 * sorted order, the min heap store the values in the righ half of the data stream in sorted order.
 * So the median number is the mean of the top element of the max heap and the top element of the min heap if the size if
 * even, otherwise just return the top element of the max heap, that is the largest number in the left part of the sorted
 * data stream.
 *
 */
public class MedianFinder {
    //min heap, store the numbers in the right half of the data stream in sorted order
    //the top element of the min heap is the smallest number of the right half of the data stream
    PriorityQueue<Integer> min = new PriorityQueue<>();
    //max heap, store the numbers in the left half of the data stream in sorted order
    //the top element of the max heap is the largest number of the left half of the data stream
    PriorityQueue<Integer> max = new PriorityQueue<>(Collections.reverseOrder());

    /** initialize your data structure here. */
    public MedianFinder() {

    }

    public void addNum(int num) {
        //put into the left part first
        max.offer(num);
        //put the largest of the left part heap into the right part heap
        min.offer(max.poll());
        if (max.size() < min.size()) {
            //make sure the size of the left part heap is always larger than or equal to the right part heap
            max.offer(min.poll());
        }
    }

    public double findMedian() {
        if (max.size() == min.size()) {
            //return the mean of the two middle value
            return (max.peek() + min.peek()) / 2.0;
        } else {
            //return the largest number of the left part
            return max.peek();
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */