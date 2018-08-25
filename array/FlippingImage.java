package array;

/**
 * LeetCode832. Flipping an Image(https://leetcode.com/problems/flipping-an-image/description/)
 *
 * Given a binary matrix A, we want to flip the image horizontally, then invert it, and return the resulting image.
 * To flip an image horizontally means that each row of the image is reversed.  For example, flipping [1, 1, 0] horizontally
 * results in [0, 1, 1].
 * To invert an image means that each 0 is replaced by 1, and each 1 is replaced by 0. For example, inverting [0, 1, 1] results in [1, 0, 0].
 *
 *
 * Solution: First reverse the image from row to row, and then toggle all the cells.
 */
public class FlippingImage {
    public int[][] flipAndInvertImage(int[][] A) {
        int m = A.length;
        int n = A[0].length;
        for (int[] row : A) {
            //reverse rows
            reverse(row);
        }

        //toggle cells
        for (int i = 0; i < m; ++i) {
            for(int j = 0; j < n; ++j) {
                A[i][j] = A[i][j] == 0 ? 1 : 0;
            }
        }
        return A;
    }

    public void reverse(int[] row) {
        int left = 0, right = row.length-1;
        int temp = 0;
        while(left <= right) {
            temp = row[left];
            row[left] = row[right];
            row[right] = temp;
            left++;
            right--;
        }
    }
}