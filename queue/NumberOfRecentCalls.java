package queue;

/**
 * LeetCode933. Number of Recent Calls
 *
 * Write a class RecentCounter to count recent requests.
 * It has only one method: ping(int t), where t represents some time in milliseconds.
 * Return the number of pings that have been made from 3000 milliseconds ago until now.
 * Any ping with time in [t - 3000, t] will count, including the current ping.
 * It is guaranteed that every call to ping uses a strictly larger value of t than before.
 *
 * Example 1:
 * Input: inputs = ["RecentCounter","ping","ping","ping","ping"], inputs = [[],[1],[100],[3001],[3002]]
 * Output: [null,1,2,3,3]
 *
 * Solution: Define a queue to store recent call times, when there is new ping call, remove the element from the queue
 * that is earlier than 3000ms ago, and then add the new call time to the queue. At the end, return the size of
 * the queue, which is the times of recent calls in 3000ms.
 */
public class NumberOfRecentCalls {

    Queue<Integer> queue;

    public RecentCounter() {
        queue = new LinkedList<>();
    }

    public int ping(int t) {
        while (!queue.isEmpty() && queue.peek() + 3000 < t) {
            //remove calls that is earlier than 3000ms ago
            queue.poll();
        }
        queue.add(t);
        return queue.size();
    }
}