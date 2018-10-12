package heap;

/**
 * LeetCode378. Kth Smallest Element in a Sorted Matrix(https://leetcode.com/problems/kth-smallest-element-in-a-sorted-matrix/description/)
 *
 * Given a n x n matrix where each of the rows and columns are sorted in ascending order, find the kth smallest element in the matrix.
 * Note that it is the kth smallest element in the sorted order, not the kth distinct element.
 *
 * Solution: The basic idea is to build a priority queue from the first row, and then pop the top element from the queue,
 * and put it next element in the same column into the queue, until we have pop (k-1)th times, and then pop last time from
 * the queue, that is the kth smallest element that we are looking for.
 *
 * Another solution is to use binary search to find the number that have k-1 numbers less than it in the matrix.
 */
public class KthSmallestElementInSortedMatrix {
    public int kthSmallest(int[][] matrix, int k) {
        int m = matrix.length;
        int n = matrix[0].length;

        PriorityQueue<Tuple> queue = new PriorityQueue<Tuple>();
        for (int i = 0; i < n; ++i) {
            //build the queue from the first row
            queue.offer(new Tuple(0, i, matrix[0][i]));
        }
        for (int i = 0; i < k-1; ++i) {
            //pop the smallest elemnt from the queue
            Tuple t = queue.poll();
            if (t.x == n-1) {
                continue;
            }
            //put it's next element in the same column into the queue
            queue.offer(new Tuple(t.x+1, t.y, matrix[t.x+1][t.y]));
        }
        return queue.poll().val;
    }

    //Define a new Tuple class to represent the element in the queue
    class Tuple implements Comparable<Tuple> {
        int x;
        int y;
        int val;

        public Tuple(int x, int y, int val) {
            this.x = x;
            this.y = y;
            this.val = val;
        }

        @Override
        public int compareTo(Tuple other) {
            //sort by their value in descendent order
            return this.val - other.val;
        }
    }


    public int kthSmallest2(int[][] matrix, int k) {
        int m = matrix.length;
        int n = matrix[0].length;
        int low = matrix[0][0];
        int high = matrix[m-1][n-1];
        while (low < high) {
            int middle = (low + high) >>> 1;
            int count = 0;
            for (int i = 0; i < m; ++i) {
                int j = n-1;
                while (j >= 0 && matrix[i][j] > middle) {
                    j--;
                }
                count += (j+1);
            }
            if (count < k) {
                //the number of elements that smaller than given value is less than k, skip it
                low = middle+1;
            } else {
                //the number of elements that smaller than given value is larger than or equal to k, keep it and keep
                //looking for the smallest number
                high = middle;
            }
        }
        return low;
    }
}