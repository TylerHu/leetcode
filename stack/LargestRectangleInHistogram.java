package stack;

/**
 * LeetCode84. Largest Rectangle in Histogram
 *
 * Given n non-negative integers representing the histogram's bar height where the width of each bar is 1, find the area
 * of largest rectangle in the histogram.
 *
 * Solution: Maintain a stack of index of each heigh in the array. Loop over the array, when the stack is empty or the
 * current height is taller than the top of the stack, push it into the stack. Otherwise, pop the top element of the stack
 * until the current element is taller than the top of the stack. Each time when pop from the stack, use it's height as
 * the height of the rectangle to calculate the area, and the width of the rectangle is (i-stack.peek()-1), which is the
 * length between the current element and the first left element that is lower than the pop element. There are two tricks
 * to make the code more concise, first is setting the height of the first element beyond the array to zero, the second is
 * when the stack is empty, the last pop element is the lowest one, so can just use the index i as the width of the rectangle.
 *
 *
 */
public class LargestRectangleInHistogram {

    public int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack();
        int maxArea = 0;
        int len = heights.length;
        for (int i = 0; i <= len; ++i) {
            int h = (i == len ? 0 : heights[i]);
            if (stack.isEmpty() || h >= heights[stack.peek()]) {
                stack.push(i);
            } else {
                int top = stack.pop();
                maxArea = Math.max(maxArea, heights[top] * (stack.isEmpty() ? i : (i - stack.peek() - 1)));
                i--;
            }
        }
        return maxArea;
    }
}