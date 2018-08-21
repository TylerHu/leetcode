package twopointers;

/**
 * LeetCode287. Find the Duplicate Number(https://leetcode.com/problems/find-the-duplicate-number/description/)
 *
 * Given an array nums containing n + 1 integers where each integer is between 1 and n (inclusive), prove that at least one duplicate
 * number must exist. Assume that there is only one duplicate number, find the duplicate one.
 * Note:
 * You must not modify the array (assume the array is read only).
 * You must use only constant, O(1) extra space.
 * Your runtime complexity should be less than O(n2).
 * There is only one duplicate number in the array, but it could be repeated more than once.
 *
 * Solution: In fact, this is a circle detection problem. The main idea is simliar to find the entry point of a circle linked list.
 * Defind two pointers fast and slow, the fast pointer move forwards two step each time, and the slow pointer move one step. If there
 * is duplicate number, the fast and slow pointer must meet at some point. Reset the fast pointer to the beginning of the array, and move
 * both the fast pointer and slow pointer one step each time, when the fast and slow pointer meet each other again, the meeting point is
 * the entry point of the circle.
 */
public class FindTheDuplicateNumber {
    public int findDuplicate(int[] nums) {
        int slow = nums[0];
        int fast = nums[nums[0]];
        while (slow != fast) {
            //slow pointer move one step
            slow = nums[slow];
            //fast pointer move two steps
            fast = nums[nums[fast]];
        }
        //reset fast pointer to the beginning
        fast = 0;
        while(slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }
        //when slow pointer and fast meet again, the meeting point is the entry point of the circle
        return slow;
    }
}