package greedy;

/**
 * LeetCode134. Gas Station(https://leetcode.com/problems/gas-station/description/)
 *
 * There are N gas stations along a circular route, where the amount of gas at station i is gas[i].
 * You have a car with an unlimited gas tank and it costs cost[i] of gas to travel from station i to its next station (i+1).
 * You begin the journey with an empty tank at one of the gas stations.
 * Return the starting gas station's index if you can travel around the circuit once in the clockwise direction, otherwise return -1.
 * Note:
 * If there exists a solution, it is guaranteed to be unique.
 * Both input arrays are non-empty and have the same length.
 * Each element in the input arrays is a non-negative integer.
 *
 * Solution: The basic idea is start from any station, and increase end as long as the gas left in the tank is not less than 0.
 * If end meets the start point, it means we cand travel around the circuit and start from the 'start' point. If gas left in
 * the tank is less than 0, we could move start point backforward until the we have any gas, and then start over again to
 * check whether we could meet the start point again. Here start from the last station is to avoid some corner cases.
 */
public class GasStation {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        //start from the last station
        int start = gas.length - 1;
        //next station
        int end = 0;
        //init gas
        int gasLeft = gas[start] - cost[start];
        while (start > end) {
            if (gasLeft >= 0) {
                //we have some gas left, so could move end forward
                gasLeft += gas[end] - cost[end];
                end++;
            } else {
                //not enough gas, move start station backward, and do it again
                --start;
                gasLeft += gas[start] - cost[start];
            }
        }
        return gasLeft >= 0 ? start : -1;
    }
}