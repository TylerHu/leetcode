package greedy;

/**
 * LeetCode621. Task Scheduler(https://leetcode.com/problems/task-scheduler/description/)
 *
 * Given a char array representing tasks CPU need to do. It contains capital letters A to Z where different letters represent
 * different tasks.Tasks could be done without original order. Each task could be done in one interval. For each interval, CPU
 * could finish one task or just be idle.However, there is a non-negative cooling interval n that means between two same tasks,
 * there must be at least n intervals that CPU are doing different tasks or just be idle.
 * You need to return the least number of intervals the CPU will take to finish all the given tasks.
 *
 * Solution: First, we need to find the most frequency charater and how many times it has appeared. Take "AAABBC" as an example,
 * and cooling interval is 2.
 * A "appeared" 3 times and it's the most frequency charater, Since there should be n intervals between two same tasks, character
 * A will use the most number of idle intervals than others. So the final sequence will look like this AXXAXXA, "X" represent some
 * empty slots, can be other tasks or idle. If we put all the remaining tasks into thess empty slot, like ABCAB#A, here "#" is an idle
 * inteval, so the length of this sequence is tasks.length + numberOfIdleIntervals. Then the problem becomes to find the number of
 * idle intervals. In the last example, there are 2 partitions separated by charater A, and the number of empty slot is
 * (numberOfCharaterA - 1) * n, the remaining tasks is tasks.length - numberOfCharacterA, so the number of idle intervals is
 * (numberOfCharacterA-1)*n - (tasks.length-numberOfCharacterA), and plus with tasks.length with get the length of the final sequence.
 * There are some other cases, if there more than one character appeared the most, for example AAABBBCCD, the sequence will become
 * ABXXABXXAB, we have to change the formula
 * is little bit. The number of partitions is still (the most frequency - 1), and the number of empty slots is
 * (number of partitions) * (n - (number of characters that appeared the most - 1)), the number of remaining tasks is
 * tasks.length - (most frequency * number of characters that appeared the most). So the number of idle intervals
 * is (number of empty slots - number of remaining tasks). There may be posible that number of empty slots is less than
 * number of remainning tasks, means we don't need any extra idle intervals.
 */
public class TaskScheduler {
    public int leastInterval(char[] tasks, int n) {
        int[] count = new int[26];
        //the most "appeared" times
        int mostFrequency = 0;
        //the number of characters that appeared the most
        int numOfCharWithMostFrequency = 0;
        for (char task : tasks) {
            //increase frequency
            count[task - 'A'] ++;
            if (mostFrequency == count[task-'A']) {
                //increase the number of characters that appeared the most,
                numOfCharWithMostFrequency++;
            } else if (mostFrequency < count[task-'A']) {
                //update the most "appeared" times
                mostFrequency = count[task-'A'];
                //reset the number of characters that appeared the most to 1
                numOfCharWithMostFrequency = 1;
            }
        }
        //number of partitions that separated by most frequency characters
        int partitions = mostFrequency - 1;
        //number of slots that fill in the partitions
        int emptySlots = partitions * (n - (numOfCharWithMostFrequency-1));
        //remaining tasks that exclude the most frequency characters
        int remainingTasks = tasks.length - mostFrequency * numOfCharWithMostFrequency;
        //number of empty slot - number of remaining tasks is the number of idle of intervals that we need.
        int idle = Math.max(0, emptySlots - remainingTasks);

        return tasks.length + idle;
    }
}