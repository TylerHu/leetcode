package array;

/**
 * Leetcode41. First Missing Positive(https://leetcode.com/problems/first-missing-positive/)
 *
 * Given an unsorted integer array, find the smallest missing positive integer.
 * Your algorithm should run in O(n) time and uses constant extra space.
 *
 * Solution: The basic idea is put the number in the right place of the array, for example, put number 3 in nums[2] slot.
 * And then find the first number that is in the wrong place. If not found, return the numbers.length+1
 */
public class FirstMissingPositive {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 1;
        }
        for (int i = 0; i < n; ++i) {
            while (nums[i] > 0 && nums[i] <= n && nums[nums[i] - 1] != nums[i]) {
                //swap nums[i] and nums[nums[i]-1]
                swap(nums, i, nums[i]-1);
            }
        }
        for (int i = 0; i < n; ++i) {
            if (nums[i] != i+1) {
                //find the first number not in the right place
                return i+1;
            }
        }
        return n+1;
    }

    public void swap(int[] nums, int i, int j) {
        if (i != j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
    }
}