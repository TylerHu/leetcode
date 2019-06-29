package array;

/**
 * LeetCode31. Next Permutaion(https://leetcode.com/problems/next-permutation/)
 *
 * Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.
 * If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending order).
 * The replacement must be in-place and use only constant extra memory.
 * Here are some examples. Inputs are in the left-hand column and its corresponding outputs are in the right-hand column.
 * 1,2,3 → 1,3,2
 * 3,2,1 → 1,2,3
 * 1,1,5 → 1,5,1
 *
 * Solution:
 * Step 1. we start from right to left, find the first number that is not in sorted order, saved the index as swapPoint.
 * Step 2. If number in step1 is not found, reverse the whole array.
 * Step 3. If number in step1 is found, start from right to left again to find the first number that is larger than it,
 * and swap these two numbers.
 * Step 4. reverse the numbers which are to the right of the swapped number in the array.
 */
public class NextPermutation {
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return;
        }
        int swapPoint = -1;
        //star from right(the last two number) to left
        for (int i = n-2; i >= 0; --i) {
            if (nums[i] < nums[i+1]) {
                //found the swap number
                swapPoint = i;
                break;
            }
        }
        if (swapPoint == -1) {
            //not found the swap number, reverse the whole string
            reverse(nums, 0, n-1);
            return;
        }
        for (int i = n-1; i >= 0; --i) {
            if (nums[i] > nums[swapPoint]) {
                //swap the "swap number" with the first bigger number
                swap(nums, i, swapPoint);
                break;
            }
        }
        //reverse the right side of the swap number in the array
        reverse(nums, swapPoint+1, n-1);
    }

    public void reverse(int[] nums, int i, int j) {
        while (i <= j) {
            swap(nums, i, j);
            i++;
            j--;
        }
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}