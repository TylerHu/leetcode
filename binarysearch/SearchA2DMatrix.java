package binarysearch;

/**
 * LeetCode74. Search a 2D Matrix
 *
 * Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:
 * Integers in each row are sorted from left to right.
 * The first integer of each row is greater than the last integer of the previous row.
 *
 * Solution: Treat the matrix as an sorted array, and do binary search. There is a convertion between matrix and the array.
 * Let's assum the row size and column size of the matrix is m and n. Then matrix[i][j] = array[i*n+j], and
 * array[index] = matrix[index/n][index%n]
 */
public class SearchA2DMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0) {
            return false;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        int left = 0;
        int right = m*n-1;
        while (left <= right) {
            //binary search
            int middle = (left + right) >>> 1;
            //the corresponding element to the middle element in the matrix is [middle/n][middle%n]
            if (matrix[middle/n][middle%n] == target) {
                return true;
            } else if (matrix[middle/n][middle%n] > target) {
                right = middle-1;
            } else {
                left = middle+1;
            }
        }
        return false;
    }
}