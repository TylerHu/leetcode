package stack;

/**
 * LeetCode42. Trapping Rain Water(https://leetcode.com/problems/trapping-rain-water/description/)
 *
 * Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it is able to trap after raining.
 *
 * Solution: Inspired by the LargestRectangleInHistogram solution, use stack to store the index of each bar according to their height. If the height of current
 * bar is lower than the top the stack, push it into the stack, so the top of the stack is the lowest bar. In order to trap water, there should be a lower bar
 * and two left and right higher bar. And the area is (min(leftBar, rightBar)-lowerBar) * (rightBarIndex-leftBarIndex-1). The bar which is just pop from the stack is
 * the lower bar, and current top bar at the stack is it's left higher bar, the current iterating bar is the right higher bar.
 */
public class TrappingRainWater {
    public int trap(int[] height) {
        int n = height.length;
        if (n == 0) {
            return 0;
        }
        Stack<Integer> stack = new Stack<>();
        int area = 0;
        for (int i = 0; i < height.length; ++i) {
            if (stack.isEmpty() || height[i] < height[stack.peek()]) {
                //if stack is empty or current bar is lower than the top of the stack, push it into stack
                stack.push(i);
            } else {
                //the top of the stack is a lowest bar
                int bottom = stack.pop();
                //stack.peek() is left higher bar, i is right higher bar
                //height is (min(height[stack.peek()], height[i])-height[bottom]
                //width is i - stack.peek() - 1
                area += stack.isEmpty() ? 0 : (Math.min(height[stack.peek()], height[i]) -height[bottom]) * (i - stack.peek() - 1);
                --i;
            }
        }
        return area;
    }
}