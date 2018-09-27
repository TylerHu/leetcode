package dfs;

/**
 * LeetCode200. Number of Islands(https://leetcode.com/problems/number-of-islands/description/)
 *
 * Given a 2d grid map of '1's (land) and '0's (water), count the number of islands. An island is surrounded by water
 * and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.
 *
 * Solution: Use dfs to mark current cell(i,j)'s adjacent cells[(i-1,j), (i+1,j), (i,j-1), (i,j+1)] to be 0. And then count
 * how many cells are '1'.
 */
public class NumberOfIslands {
    int n = 0;
    int m = 0;
    public int numIslands(char[][] grid) {
        n = grid.length;
        if (n == 0) {
            return 0;
        }
        m = grid[0].length;
        int count = 0;
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                if (grid[i][j] == '1') {
                    //increase island count
                    count++;
                    //mark adjacent cells to be 0
                    DFSMark(grid, i, j);
                }
            }
        }
        return count;
    }

    public void DFSMark(char[][] grid, int i , int j) {
        if (grid[i][j] != '1') {
            //not lands, do nothing
            return;
        }
        //mark lands to be water
        grid[i][j] = '0';
        if (i > 0) {
            DFSMark(grid, i-1, j);
        }
        if (i < n-1) {
            DFSMark(grid, i+1, j);
        }
        if (j > 0) {
            DFSMark(grid, i, j-1);
        }
        if (j < m-1) {
            DFSMark(grid, i, j+1);
        }
    }
}