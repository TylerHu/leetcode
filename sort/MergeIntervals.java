package sort;

/**
 * LeetCode56. Merge Intervals(https://leetcode.com/problems/merge-intervals/description/)
 *
 * Given a collection of intervals, merge all overlapping intervals.
 *
 * Solution: The idea is sort the intervals by their start value. Iterate over the sorted intervals, and check whether the start of
 * current interval is smaller than last end, if so, means there is overlap between these two intervals, and update the end with
 * the max value of current end and last end. Otherwise, there is no overlap, take last start and last end as a new interval and add
 * to the result list.
 */
public class MergeIntervals {
    public List<Interval> merge(List<Interval> intervals) {
        List<Interval> result = new ArrayList<>();
        if (intervals.size() == 0) {
            return result;
        }
        //sort the list by start value
        intervals.sort((i1, i2) -> {
            return i1.start - i2.start;
        });
        //init start and end with the first element in the list
        int start = intervals.get(0).start, end = intervals.get(0).end;
        for (Interval interval : intervals) {
            if ( end < interval.start) {
                //no overlap, add a new interval to the result list
                result.add(new Interval(start, end));
                //update start with current interval start
                start = interval.start;
                //update end with current interval end
                end = interval.end;
            } else {
                //there is overlap
                //update end with the maximum of last end and current end
                end = Math.max(end, interval.end);
            }
        }
        //do not miss the last interval
        result.add(new Interval(start, end));
        return result;
    }
}