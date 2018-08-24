package array;

/**
 * LeetCode566. Reshape the Matrix(https://leetcode.com/problems/reshape-the-matrix/description/)
 *
 * In MATLAB, there is a very useful function called 'reshape', which can reshape a matrix into a new one with different size but keep its original data.
 * You're given a matrix represented by a two-dimensional array, and two positive integers r and c representing the row number and column number of the wanted reshaped matrix, respectively.
 * The reshaped matrix need to be filled with all the elements of the original matrix in the same row-traversing order as they were.
 * If the 'reshape' operation with given parameters is possible and legal, output the new reshaped matrix; Otherwise, output the original matrix.
 *
 * Solution: Since the row-traversing order of the origin matrix and the reshaped matrix should be the same, we could get the position
 * in row-traversing order of current cell, and get it's row and column index in the origin matrix. Let's assume the row index is x, and column
 * index is y, i * c + j = x * n + y, so x = (i * c + j) / n, y = (i * c + j) % n
 */
public class ReshapeTheMatrix {
    public int[][] matrixReshape(int[][] nums, int r, int c) {
        int m = nums.length;
        int n = nums[0].length;
        if (m * n != r * c) {
            return nums;
        }
        int[][] result = new int[r][c];
        for (int i = 0; i < r; ++i) {
            for (int j = 0; j < c; ++j) {
                //get the position in row-traversing order
                int positionInRowTraverseOrder = i * c + j;
                //get the row index and column index in the origin matrix
                result[i][j] = nums[positionInRowTraverseOrder / n][positionInRowTraverseOrder % n];
            }
        }
        return result;
    }
}