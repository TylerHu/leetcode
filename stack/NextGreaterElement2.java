package stack;

/**
 * LeetCode503.Next Greater Element II(https://leetcode.com/submissions/detail/183664163/)
 *
 * Given a circular array (the next element of the last element is the first element of the array), print the Next Greater
 * Number for every element. The Next Greater Number of a number x is the first greater number to its traversing-order
 * next in the array, which means you could search circularly to find its next greater number. If it doesn't exist,
 * output -1 for this number.
 *
 * Solution: The basic idea is the same with leetcode 496, use a stack to store elements, and when we meet a number that
 * is greater than current top element of the stack, pop the elements from the stack until the stack is empty or the top
 * element in the stack is greater or equal to the given number. And this time, since it's a circular array, we could
 * traverse the array twice, for example, array [1, 2, 1], after traversing, it will be [1, 2, 1, 1, 2], so we could treat
 * it like a normal array to get element's next greater element.
 */
public class NextGreaterElement2 {

    public int[] nextGreaterElements(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        int result[] = new int[nums.length];
        //init the result array with -1
        Arrays.fill(result, -1);
        int n = nums.length;
        //traverse twice
        for (int i = 0; i < n * 2; ++i) {
            //index is i % n
            int number = nums[i % n];
            while(!stack.isEmpty() && nums[stack.peek()] < number) {
                //the next greater element of the number at index stack.pop() is current number
                result[stack.pop()] = number;
            }
            //push the current number's index into stack
            stack.push(i % n);
        }
        return result;
    }
}