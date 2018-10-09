package greedy;

/**
 * LeetCode406. Queue Reconstruction by Height(https://leetcode.com/problems/queue-reconstruction-by-height/description/)
 *
 * Suppose you have a random list of people standing in a queue. Each person is described by a pair of integers (h, k),
 * where h is the height of the person and k is the number of people in front of this person who have a height greater than
 * or equal to h. Write an algorithm to reconstruct the queue.
 *
 * Solution: Sort the list of people by their heigh from tall to short, if they are at the same height, sort them by their k-value.
 * And then insert these people into the list use their k-value as index.
 */
public class QueueReconstructionByHeight {
    public int[][] reconstructQueue(int[][] people) {
        //sort the list by their heigh and k-value
        Arrays.sort(people, (p1, p2) -> p1[0] == p2[0] ? p1[1] - p2[1] : p2[0] - p1[0]);
        List<int[]> list = new ArrayList<>();
        for (int[] p : people) {
            //insert into the list, use it's k-value as index
            list.add(p[1], p);
        }
        return list.toArray(people);
    }
}