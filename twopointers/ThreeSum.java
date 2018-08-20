package twopointers;

/**
 * LeetCode15. 3Sum(https://leetcode.com/problems/3sum/description/)
 *
 * Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0? Find all unique triplets
 * in the array which gives the sum of zero.
 * Note:
 * The solution set must not contain duplicate triplets.
 *
 * Solution: Define two pointers left and right represent the next element of the current iterating element, and last element of the array.
 * One thing need to pay attention to is that we both need to skip duplicate triplets in the two pointer looping and the outside iterating.
 */
public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums.length < 3) {
            return result;
        }
        //sort the array first
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; ++i) {
            int target = 0 - nums[i];
            int left = i+1, right = nums.length-1;
            while (left < right) {
                int sum = nums[left] + nums[right];
                if (sum == target) {
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    left++;
                    right--;
                    //avoid duplicate triplets
                    while(left < right && nums[left] == nums[left-1]) left++;
                    while(left < right && nums[right] == nums[right+1]) right--;

                } else if (sum > target) {
                    right--;
                } else {
                    left++;
                }
            }
            //avoid duplicate triplets
            while(i < nums.length-1 && nums[i] == nums[i+1]) {
                ++i;
            }
        }
        return result;
    }
}