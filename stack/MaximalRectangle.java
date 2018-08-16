package stack;

/**
 * LeetCode85. Maximal Rectangle(https://leetcode.com/problems/maximal-rectangle/description/)
 *
 * Given a 2D binary matrix filled with 0's and 1's, find the largest rectangle containing only 1's and return its area.
 *
 * Solution: The basic idea is similar to leetcode84, when loop over the matrix from top to down, define a stack to store
 * the index of the each column, and also increase the height of the column when current element is '1'. When the stack is
 * empty or the current column hight is taller than the top of the stack column, push the column index to the stack, otherwise
 * pop the element from the stack and calcutate the area. Here also use a trick, when j is beyond the length of columns, set
 * it's height to zero.
 */
public class MaximalRectangle {
    public int maximalRectangle(char[][] matrix) {
        int maxArea = 0;
        int row = matrix.length;
        if (row == 0) {
            return 0;
        }
        int col = matrix[0].length;
        //heights array to store the height of each column
        int[] heights = new int[col+1];
        for (int i = 0; i < row; ++i) {
            Stack<Integer> stack = new Stack();
            //note j <= col, not j < col
            for (int j = 0; j <= col; ++j) {
                if (j < col && matrix[i][j] == '1') {
                    //increase height
                    heights[j] += 1;
                } else {
                    //reset height
                    heights[j] = 0;
                }
                if (stack.isEmpty() || heights[j] >= heights[stack.peek()]) {
                    stack.push(j);
                } else {
                    while(!stack.isEmpty() && heights[j] < heights[stack.peek()]) {
                        int top = stack.pop();
                        //use the pop column height to calculate the area
                        maxArea = Math.max(maxArea, heights[top] * (stack.isEmpty() ? j : j-stack.peek()-1));
                    }
                    //push the current column index to stack
                    stack.push(j);
                }
            }
        }
        return maxArea;
    }
}