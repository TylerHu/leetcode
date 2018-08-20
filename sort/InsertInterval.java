package sort;

/**
 * LeetCode57. Insert Interval(https://leetcode.com/problems/insert-interval/description/)
 *
 * Given a set of non-overlapping intervals, insert a new interval into the intervals (merge if necessary).
 * You may assume that the intervals were initially sorted according to their start times.
 *
 * Solution: Since the interval list is already sorted by their start times, we could just iterating the list. If the end of current
 * interval is smaller than the start of new interval, means no overlap, add the current interval to the result list. If the end of current
 * interval is largr than or equal to the start of new interval, merge them into a new interval, until the start of current interval is
 * larger than the end of the new interval. And add the rest of the intervals list to the result list.
 */
public class InsertInterval {
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        List<Interval> result = new ArrayList<>();
        if (intervals == null || intervals.size() == 0) {
            result.add(newInterval);
            return result;
        }
        int i = 0;
        while (i < intervals.size() && intervals.get(i).end < newInterval.start) {
            //no overlap, add to the result list directly
            result.add(intervals.get(i));
            ++i;
        }
        //has overlap, merge into new interval, and update the start and end of the new interval
        //until the start of current interval is larger than the end of new interval
        while (i < intervals.size() && intervals.get(i).start <= newInterval.end) {
            newInterval.start = Math.min(intervals.get(i).start, newInterval.start);
            newInterval.end = Math.max(intervals.get(i).end, newInterval.end);
            ++i;
        }
        //add the new interval to the result list
        result.add(newInterval);
        while (i < intervals.size()) {
            //add the rest of the interval list to the result list
            result.add(intervals.get(i));
            ++i;
        }
        return result;
    }
}