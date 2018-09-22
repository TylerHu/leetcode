package hashtable;

/**
 * LeetCode36. Valid Sudoku(https://leetcode.com/problems/valid-sudoku/description/)
 *
 * Determine if a 9x9 Sudoku board is valid. Only the filled cells need to be validated according to the following rules:
 * Each row must contain the digits 1-9 without repetition.
 * Each column must contain the digits 1-9 without repetition.
 * Each of the 9 3x3 sub-boxes of the grid must contain the digits 1-9 without repetitio
 * The Sudoku board could be partially filled, where empty cells are filled with the character '.'.
 *
 * Solution: Use three hashset to store characters each row, each column and each cube respectivly. And iterate through
 * the board, check whether current character has already in these three sets. When checking in cubeSet, we need to get
 * the corresponding row and column index in the cube.
 */
public class ValidSudoku {

    public boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < board.length; ++i) {
            Set<Character> rowSet = new HashSet<>();
            Set<Character> colSet = new HashSet<>();
            Set<Character> cubeSet = new HashSet<>();
            for (int j = 0; j < board[0].length; ++j) {
                if (board[i][j] != '.' && !rowSet.add(board[i][j])) {
                    return false;
                }
                if (board[j][i] != '.' && !colSet.add(board[j][i])) {
                    return false;
                }

                int cubeRowIndex = (i / 3) * 3 + j / 3;
                int cubeColIndex = (i % 3) * 3 + j % 3;
                if (board[cubeRowIndex][cubeColIndex] != '.' && !cubeSet.add(board[cubeRowIndex][cubeColIndex])) {
                    return false;
                }
            }
        }
        return true;
    }
}