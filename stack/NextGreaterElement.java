package stack;

/**
 * LeetCode496. Next Greater Element I(https://leetcode.com/problems/next-greater-element-i/submissions/)
 *
 * You are given two arrays (without duplicates) nums1 and nums2 where nums1’s elements are subset of nums2.
 * Find all the next greater numbers for nums1's elements in the corresponding places of nums2.
 * The Next Greater Number of a number x in nums1 is the first greater number to its right in nums2. If it does not exist,
 * output -1 for this number.
 *
 * Solution: For a decreasing sequence followed by a greater number, take sequence [5, 4, 3, 2, 1, 6] as an example, the
 * greater number 6 is the next greater elment for all the previous elements. So we could use a stack to store the element
 * in the sequence, when we see a number x is greater than stack.peek(), pop all the elements that is less than x, and all these
 * elements' next greater elemnet is x
 */
public class NextGreaterElement {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        //store the mapping of the element and it's next greater element
        Map<Integer, Integer> map = new HashMap<>();
        Stack<Integer> stack = new Stack<>();
        for (int num : nums2) {
            while (!stack.isEmpty() && stack.peek() < num) {
                //pop all the elements that is smaller than current number, and store their mappping into a map
                map.put(stack.pop(), num);
            }
            //push current number into the stack
            stack.push(num);
        }
        for (int i = 0; i < nums1.length; ++i) {
            //get the next greater elemnt from the map
            nums1[i] = map.getOrDefault(nums1[i], -1);
        }
        return nums1;
    }
}