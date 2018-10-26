package array;

/**
 * LeetCode80. Remove Duplicates from Sorted Array 2(https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii/)
 *
 * Given a sorted array nums, remove the duplicates in-place such that duplicates appeared at most twice and return the new length.
 * Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.
 *
 * Solution: Define a count variable to store the counts of current duplicate numbers. And define a index variable
 * to keep track of new array index. Start from the second element, and check whether it is the same with
 * it's previous one, if they are the same, and current count of duplicate number is less than 2, set it to the right position
 * of the array. If meet more than 2 same elements, skip it. If they are not the same, reset count to 1, and set current element to
 * the right position. At the end return the index as the length of the array
 */
public class RemoveDuplicatesFromSortedArray2 {
    public int removeDuplicates(int[] nums) {
        //store the current counts of duplicate numbers
        int count = 1;
        //keep track of the new array index
        int index = 1;
        for (int i = 1; i < nums.length; ++i) {
            if (nums[i] != nums[i-1]) {
                //reset count
                count = 1;
                nums[index++] = nums[i];
            } else {
                if (count < 2) {
                    //less than 2 times, so put it to the right position
                    nums[index++] = nums[i];
                    //increase count
                    count++;
                }
            }
        }
        return index;
    }
}