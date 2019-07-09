package heap;

/**
 * LeetCode973. K Closest Points to Origin(https://leetcode.com/problems/k-closest-points-to-origin/)
 *
 * We have a list of points on the plane.  Find the K closest points to the origin (0, 0).
 * (Here, the distance between two points on a plane is the Euclidean distance.)
 * You may return the answer in any order.  The answer is guaranteed to be unique (except for the order that it is in.
 *
 * Solution: Create a maximum heap, and keep its size to K. At the end result all the elements in the heap.
 * 
 */
public class KClosestPointsToOrigin {

    class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public int[][] kClosest(int[][] points, int K) {
        int[][] result = new int[K][2];
        PriorityQueue<Point> queue = new PriorityQueue<>((a, b) -> (b.x * b.x + b.y * b.y) - (a.x * a.x + a.y * a.y));
        for (int i = 0; i < points.length; ++i) {
            Point point = new Point(points[i][0], points[i][1]);
            queue.offer(point);
            if (queue.size() > K) {
                queue.poll();
            }
        }
        int i = 0;
        while (!queue.isEmpty()) {
            Point point = queue.poll();
            result[i][0] = point.x;
            result[i][1] = point.y;
            i++;
        }
        return result;
    }
}