package binarysearch;

/**
 * LeetCode240. Search a 2D Matrix II(https://leetcode.com/problems/search-a-2d-matrix-ii/description/)
 *
 * Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:
 * Integers in each row are sorted in ascending from left to right.
 * Integers in each column are sorted in ascending from top to bottom.
 *
 * Solution: The searching starts from the last element in the first row, if it's bigger than the target number, search
 * it's leftside elements, if it's smaller than the target number, seach it's downside elements.
 */
public class SearchA2DMatrix2 {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0) {
            return false;
        }

        int row = 0;
        int col = matrix[0].length - 1;
        //start from the last element in the first row
        while(row < matrix.length && col >= 0) {
            if (matrix[row][col] == target) {
                //found it
                return true;
            } else if (matrix[row][col] > target) {
                //search leftside
                col--;
            } else {
                //search downside
                row++;
            }
        }
        return false;
    }
}