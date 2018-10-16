package heap;

/**
 * LeetCode218. The Skyline Problem(https://leetcode.com/problems/the-skyline-problem/description/)
 *
 * A city's skyline is the outer contour of the silhouette formed by all the buildings in that city when viewed from a distance.
 * Now suppose you are given the locations and height of all the buildings as shown on a cityscape photo (Figure A),
 * write a program to output the skyline formed by these buildings collectively (Figure B).
 * The geometric information of each building is represented by a triplet of integers [Li, Ri, Hi], where Li and Ri are
 * the x coordinates of the left and right edge of the ith building, respectively, and Hi is its height. It is guaranteed
 * that 0 ≤ Li, Ri ≤ INT_MAX, 0 < Hi ≤ INT_MAX, and Ri - Li > 0. You may assume all buildings are perfect rectangles
 * grounded on an absolutely flat surface at height 0.
 * For instance, the dimensions of all buildings in Figure A are recorded as: [ [2 9 10], [3 7 15], [5 12 12], [15 20 10], [19 24 8] ] .
 * The output is a list of "key points" (red dots in Figure B) in the format of [ [x1,y1], [x2, y2], [x3, y3], ... ]
 * that uniquely defines a skyline. A key point is the left endpoint of a horizontal line segment. Note that the last key point,
 * where the rightmost building ends, is merely used to mark the termination of the skyline, and always has zero height.
 * Also, the ground in between any two adjacent buildings should be considered part of the skyline contour.
 * For instance, the skyline in Figure B should be represented as:[ [2 10], [3 15], [7 12], [12 0], [15 10], [20 8], [24, 0] ].
 *
 * Solution: Define a list to store all the buildings height and their x coordinates. One tricky thing here is store
 * the heigh of left edge of the building as negative, so when we go through the list, we could determine whether current
 * point is the left or the right edge of the building. Sort the heigh list according to their x coordinate and height in
 * ascending order. And then use a priority queue to store the heights of all the buildings in descending order. Iterate
 * the height list and put their height into the queue, check whether a critical point is met, if so, add it to the result
 * list.
 */
public class SkylineProblem {
    public List<int[]> getSkyline(int[][] buildings) {
        List<int[]> result = new ArrayList<>();
        //store all the buildings height and their x coordinates
        List<int[]> height = new ArrayList<>();
        for (int[] b : buildings) {
            //left edge of the building, height is stored as negative
            height.add(new int[]{b[0], -b[2]});
            //right edge of the building, height is stored as positive
            height.add(new int[]{b[1], b[2]});
        }
        //sort the height list from left to right, short to tall
        Collections.sort(height, (a, b) -> {
            if (a[0] == b[0]) {
                return a[1] - b[1];
            }
            return a[0] - b[0];
        });
        //sort the height in descending order
        PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> b - a);
        //init the queue
        queue.offer(0);
        int prev = 0;
        for (int[] h : height) {
            if (h[1] < 0) {
                //the left edge of a building, means meet a new building, add to the queue
                queue.offer(-h[1]);
            } else {
                //the right edge of a building, means reach the end of the building, remove it from the queue
                queue.remove(h[1]);
            }
            //current max height in all encounter buildings
            int current = queue.peek();
            if (current != prev) {
                //meet a critical point, add to the result list
                result.add(new int[]{h[0], current});
                //update previous max height
                prev = current;
            }
        }
        return result;
    }
}