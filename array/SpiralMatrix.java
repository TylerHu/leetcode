package array;

/**
 * LeetCode54. Spiral Matrix(https://leetcode.com/problems/spiral-matrix/description/)
 *
 * Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.
 *
 * Solutuion: First traverse from left to right and increse upper low index, then traverse from up to down and decrease the right column index,
 * then traverse from right to left and decrease lower low index, then traverse from bottom to up and increase left column index. There is one
 * one need to note to prevent duplicate result. That is when traverse from right to left, also need to check whether the row condition is matched,
 * when traverse from bottom to up, also need to check whether the column condition is matched.
 */
public class SpiralMatrix {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        int m = matrix.length;
        if (m == 0) {
            return result;
        }
        int n = matrix[0].length;

        //init left column, right column, upper low, bottom low;
        int left = 0, right = n-1, upper = 0, lower = m-1;
        while(left <= right && upper <= lower) {
            //traverse from left to right
            for (int j = left; j <= right; ++j) {
                result.add(matrix[upper][j]);
            }
            //increase upper row index
            upper++;

            //traverse from up to bottom
            for (int i = upper; i <= lower; ++i) {
                result.add(matrix[i][right]);
            }
            //decrease rigth column index
            right--;

            //traverse from right to left, also need to check the row condition
            for (int j = right; j >= left && upper <= lower; --j) {
                result.add(matrix[lower][j]);
            }
            //decrease bottom row index
            lower--;

            //traverse from bottom to up, also need to check the column condition
            for (int i = lower; i >= upper && left <= right; --i) {
                result.add(matrix[i][left]);
            }
            //increase left column index
            left++;

        }
        return result;
    }
}