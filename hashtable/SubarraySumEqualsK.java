package hashtable;

/**
 * LeetCode560. Subarray Sum Equals K(https://leetcode.com/problems/subarray-sum-equals-k/description/)
 *
 * Given an array of integers and an integer k, you need to find the total number of continuous subarrays whose sum equals to k.
 * Note:
 * he length of the array is in range [1, 20,000].
 * The range of numbers in the array is [-1000, 1000] and the range of the integer k is [-1e7, 1e7].
 *
 * Solution: Apparently, this problem is to find subarrays [i,j](i<=j), and the sum of numbers between [i,j] is equals to k. But we
 * could do it in another way, if we know the sum of [0, i-1] and the sum of [0, j], then k is sum[0,j]-sum[0,i-1]. So we could
 * store the presum of previous numbers, and check whether sum[0,j]-k is already in the map, if so, the number of presum in the map
 * is the number of subarrays whose sum equals to k so far.
 */
public class SubarraySumEqualsK {
    public int subarraySum(int[] nums, int k) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        int count = 0;
        Map<Integer, Integer> preSum = new HashMap<>();
        //when the current sum is equal to k, sum - k is 0, in this case
        //init the map and set the value of key 0 to 1
        preSum.put(0, 1);
        int sum = 0;
        for (int i = 0; i < n; ++i) {
            sum += nums[i];
            if (preSum.containsKey(sum-k)) {
                //found subarrsy
                //the number of sum-k in the map is also the number of subarrays whose sum equals to k
                count += preSum.get(sum-k);
            }
            //update the map
            preSum.put(sum, preSum.getOrDefault(sum, 0) + 1);
        }
        return count;
    }
}