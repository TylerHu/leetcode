package array;

/**
 * LeetCode48. Rotate Image(https://leetcode.com/problems/rotate-image/description/)
 *
 * You are given an n x n 2D matrix representing an image.
 * Rotate the image by 90 degrees (clockwise).
 * Note:
 * You have to rotate the image in-place, which means you have to modify the input 2D matrix directly. DO NOT allocate another 2D matrix and do the rotation.
 *
 * Solution: For clockwise rotate, reverse rows in up-down direction, then swap the symmetry. For counter clockwise rotate, reverse column in left to right
 * direction, then swap the symmetry.
 */
public class RotateImage {
    public void rotate(int[][] matrix) {
        int m = matrix.length;
        if (m == 0) {
            return;
        }
        int n = matrix[0].length;
        int temp = 0;
        //reverse rows in up-dom direction
        for(int i = 0; i < m / 2; ++i) {
            for (int j = 0; j < n; ++j) {
                temp = matrix[i][j];
                matrix[i][j] = matrix[m-i-1][j];
                matrix[m-i-1][j] = temp;
            }

        }

        //swap the symmetry
        for(int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                //should match i < j condition to swap only once
                if (i < j) {
                    temp = matrix[i][j];
                    matrix[i][j] = matrix[j][i];
                    matrix[j][i] = temp;
                }
            }
        }
    }
}