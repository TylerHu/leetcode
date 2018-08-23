package bitmanipulation;

/**
 * LeetCode289. Game of Life(https://leetcode.com/problems/game-of-life/description/)
 *
 * According to the Wikipedia's article: "The Game of Life, also known simply as Life, is a cellular automaton devised by the
 * British mathematician John Horton Conway in 1970."
 * Given a board with m by n cells, each cell has an initial state live (1) or dead (0). Each cell interacts with its eight neighbors
 * (horizontal, vertical, diagonal) using the following four rules (taken from the above Wikipedia article):
 *      Any live cell with fewer than two live neighbors dies, as if caused by under-population.
 *      Any live cell with two or three live neighbors lives on to the next generation.
 *      Any live cell with more than three live neighbors dies, as if by over-population..
 *      Any dead cell with exactly three live neighbors becomes a live cell, as if by reproduction.
 * Write a function to compute the next state (after one update) of the board given its current state. The next state is created by
 * applying the above rules simultaneously to every cell in the current state, where births and deaths occur simultaneously.
 *
 * Solution: Use 2-bits to store the current state and next state like this [nextstate, currentstate], and bit-0 represents dead,
 * bit-1 represents alive. so there are for states [00] dead->dead, [10] deal->alive, [01] alive->dead, [11] alive->alive. To get
 * the current state, just board[i][j] & 1 to get the second bit of the value, and to get the next state, just board[i][j] >>= 1 to
 * get the first bit of the value. At first, board[i][j] can either be 0(00) or 1(01), and the first bit is 0 by default, we don't
 * have to deal with 01->00 situation. So we only need to consider 1(01) -> 11, and 0(00)-> 10 these two situation.
 */
public class GameOfLife {
    public void gameOfLife(int[][] board) {
        if (board.length == 0 || board[0].length == 0) {
            return;
        }
        int m = board.length;
        int n = board[0].length;
        for (int i = 0; i < m; i ++) {
            for (int j = 0; j < n; j ++) {
                // get the number of live neighbors
                int lives = neighborLives(board, m, n, i, j);
                if (board[i][j] == 1 && (lives == 2 || lives == 3)) {
                    //Any live cell with two or three live neighbors lives on to the next generation.
                    //transition from 01 to 11
                    board[i][j] = 3;
                }
                if (board[i][j] == 0 && lives == 3) {
                    //Any dead cell with exactly three live neighbors becomes a live cell
                    //transition from 00 to 10
                    board[i][j] = 2;
                }
            }
        }
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                //move one bit right to get the next state
                board[i][j] = board[i][j] >> 1;
            }
        }
    }

    public int neighborLives(int[][] board, int m, int n, int i, int j) {
        int lives = 0;
        //This pattern is very consice and elegant to deal with corner cases
        for (int x = Math.max(0, i-1); x <= Math.min(m-1, i+1); ++x) {
            for (int y = Math.max(0, j-1); y <= Math.min(n-1, j+1); ++y) {
                //board[x][y] & 1 is the current state, if current state is 1, plus 1, else pluse 0
                lives += board[x][y] & 1;
            }
        }
        //in last step, board[i][j] is also inclued, so we need to exclude board[i][j] from the result
        lives -= board[i][j] & 1;
        return lives;
    }
}