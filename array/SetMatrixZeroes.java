package array;

/**
 * LeetCode73. Set Matrix Zeroes
 *
 * Given a m x n matrix, if an element is 0, set its entire row and column to 0. Do it in-place.
 *
 * Solution: Use the first row and first column to store the states of each row and column. That means when matrix[i][j] is zero,
 * set it's first row matrix[0][j] and it's first column matrix[i][0] to zero. Since matrix[0][0] is a conjuntion of first row
 * and first column, I could only store one state of row or column, here I choose to store the state of first row, and use
 * variable zeroInFirstColumn to store the state of first column. There is another trick should be noticed, that is when storing
 * the states of each row and column, I loop over the matrix in the top-down order, but in a bottom-up order to set values to
 * each element of the matrix according to the states stored in the first row and first column. Again, when doing the loop
 * over, the column index is between 1 to column size, the first column is exclued.
 */
public class SetMatrixZeroes {
    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        boolean zeroInFirstColumn = false;

        for (int i = 0; i < m; ++i) {
            if (matrix[i][0] == 0) {
                //store the state of first column
                zeroInFirstColumn = true;
            }
        }

        //top-down
        for (int i = 0; i < m; ++i) {
            // from column 1 to column n-1
            for (int j = 1; j < n; ++j) {
                if (matrix[i][j] == 0) {
                    // store the states of each row and column
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        //bottom-up
        for (int i = m-1; i >= 0; --i) {
            //from column n-1 to column 1
            for (int j = n-1; j >= 1; --j) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
            if (zeroInFirstColumn) {
                //if there is zero in first column, set all the elmenet in
                //first column to zero
                matrix[i][0] = 0;
            }
        }
    }
}