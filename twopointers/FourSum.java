package twopointers;

/**
 * LeetCode18. 4Sum(https://leetcode.com/problems/4sum/description/)
 *
 * Given an array nums of n integers and an integer target, are there elements a, b, c, and d in nums such that a + b + c + d = target?
 * Find all unique quadruplets in the array which gives the sum of target.
 * Note:The solution set must not contain duplicate quadruplets.
 *
 * Solution: Every Kth sum problem can be narrow down to two sum and three sum problem. So the main task for this problem is
 * to figure out how to downgrade to two sum problem. Every time we iterate the element in the array, call the recursive method
 * and decrease k until k equals to 2, also, set the start index of two sum as the next element of current element. Now
 * the problem becomes to find two numbers between the next element and the last element, and the sum of these two numbers
 * are equals to target-(current element). 
 */
public class FourSum {

    public List<List<Integer>> fourSum(int[] nums, int target) {
        if (nums.length == 0) {
            return new ArrayList<>();
        }
        Arrays.sort(nums);
        return kSum(nums, target, 4, 0);
    }

    public List<List<Integer>> kSum(int[] nums, int target, int k, int index) {
        List<List<Integer>> result = new ArrayList<>();
        if (k == 2) {
            // Solution to 2Sum
            int start = index;
            int end = nums.length - 1;
            int sum = 0;
            while (start < end) {
                sum = nums[start] + nums[end];
                if (sum == target) {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[start]);
                    list.add(nums[end]);
                    result.add(list);

                    // prevent the duplicate result
                    while(start < end && nums[start] == nums[start+1]) start++;
                    while(start < end && nums[end] == nums[end-1]) end--;
                    start++;
                    end--;
                } else if (sum > target) {
                    end--;
                } else {
                    start++;
                }
            }
        } else {
            for (int i = index; i < nums.length - k + 1; ++i) {
                //recursive
                List<List<Integer>> list = kSum(nums, target-nums[i], k-1, i+1);
                if (list != null) {
                    for (List<Integer> temp : list) {
                        //add the current element back to the two sum result
                        temp.add(0, nums[i]);
                    }
                    result.addAll(list);
                }
                //prevent the duplicate result
                while(i < nums.length - k + 1 && nums[i] == nums[i+1]) ++i;
            }

        }
        return result;
    }
}