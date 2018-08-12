package recursive;

/**
 * LeetCode79. Word Search(https://leetcode.com/problems/word-search/description/)
 *
 * Given a 2D board and a word, find if the word exists in the grid.
 * The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally
 * or vertically neighboring. The same letter cell may not be used more than once.
 *
 * Solution: Do it in an recursive way to check the whether one of the upper, lower, left, and right element is equals to
 * the next character of the word. First, find an element that is equal to the begining of the word, and search it's adjacent
 * cells for next character of the word. Define a 2D array to mark whether current element is already visited(There is one trick
 * that do not need to define a 2D array, just set the result of board[x][y] xor 256 to board[x][y], why 256? Because the
 * biggest alphabet letter is 122(0111 1010), when xor with 256(1111 1111), it will become a non-alphabet letter(1xxx xxxx), also
 * when xor with 256 the second time, can get the original character in board[x][y], so can continue the searching.
 *
 */
public class WordSearch {

    static boolean[][] visited;
    public boolean exist(char[][] board, String word) {
        if (word == null || word.length() == 0) {
            return false;
        }
        int m = board.length;
        int n = board[0].length;
        visited = new boolean[m][n];
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                //find an element that is equals to the begining of the word, and start searching with index zero
                if (board[i][j] == word.charAt(0) && search(board, word, i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean search(char[][] board, String word, int x, int y, int index) {
        if (index == word.length()) {
            //found the word
            return true;
        }

        if (x < 0 || x >= board.length || y < 0 || y >= board[0].length || board[x][y] != word.charAt(index) || visited[x][y]) {
            return false;
        }
        //mark the element in board[x][y] is already visited in this round
        // here can use a trick: board[x][y] ^= 256;
        visited[x][y] = true;
        //search the ajacent cells
        boolean exist = search(board, word, x+1, y, index+1)
                || search(board, word, x-1, y, index+1)
                || search(board, word, x, y+1, index+1)
                || search(board, word, x, y-1, index+1);
        // mark the element in board[x][y] not visited for next round
        // if using the trick: board[x][y] ^= 256;
        visited[x][y] = false;
        return exist;
    }
}