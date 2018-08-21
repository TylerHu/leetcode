package array;

/**
 * LeetCode229. Majority Element II(https://leetcode.com/problems/majority-element-ii/description/)
 *
 * Given an integer array of size n, find all elements that appear more than ⌊ n/3 ⌋ times.
 * Note: The algorithm should run in linear time and in O(1) space.
 *
 * Solution: Use Moore Voting Algorithm to find the two majority numbers int the array first, which are two numbers that appear
 * the most in the array. And during the second pass, get the exactly times of these two numbers appear. If appear more than
 * n/3 times, add it to the result list.
 */
public class MajorityElement2 {
    public List<Integer> majorityElement(int[] nums) {
        int n = nums.length;
        List<Integer> result = new ArrayList<>();
        if (n == 0) {
            return result;
        }
        //majorityNum1 is one of the marjority element in the array
        //majorityNum2 is the other one of the majority elment in the array
        int majorityNum1 = nums[0], majorityNum2 = nums[0], countOfMajorityNum1 = 0, countOfMajorityNum2 = 0;
        for (int num : nums) {
            if (num == majorityNum1) {
                countOfMajorityNum1++;
            } else if (num == majorityNum2) {
                countOfMajorityNum2++;
            } else if (countOfMajorityNum1 == 0) {
                majorityNum1 = num;
                countOfMajorityNum1 = 1;
            } else if (countOfMajorityNum2 == 0) {
                majorityNum2 = num;
                countOfMajorityNum2 = 1;
            } else {
                countOfMajorityNum1--;
                countOfMajorityNum2--;
            }
        }
        countOfMajorityNum1 = 0;
        countOfMajorityNum2 = 0;
        for (int num : nums) {
            //get the exactly times of these two numbers appear
            if (num == majorityNum1) {
                countOfMajorityNum1++;
            } else if (num == majorityNum2) {
                countOfMajorityNum2++;
            }
        }
        if (countOfMajorityNum1 > n / 3) {
            result.add(majorityNum1);
        }
        if (countOfMajorityNum2 > n / 3) {
            result.add(majorityNum2);
        }
        return result;
    }
}