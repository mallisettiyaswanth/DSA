class Solution {
    private void dfs(char[][] grid, int[][] vis, int row, int col, int[] delRow, int[] delCol) {
        vis[row][col] = 1;
        for(int i = 0; i < 4; i++) {
            int nrow = row + delRow[i];
            int ncol = col + delCol[i];
            if(nrow >= 0 && nrow < grid.length && ncol >= 0 && ncol < grid[0].length && vis[nrow][ncol] != 1
            && grid[nrow][ncol] == '1') {
                dfs(grid, vis, nrow, ncol, delRow, delCol);
            }
        }
    }

    public int numIslands(char[][] grid) {
        int[][] vis = new int[grid.length][grid[0].length];
        int[] delRow = {-1, 0, 1, 0};-
        int[] delCol = {0, 1, 0, -1};
        int cnt = 0;
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if(vis[i][j] != 1 && grid[i][j] == '1') {
                    dfs(grid, vis, i, j, delRow, delCol);
                    cnt++;
                }
            }
        }

        return cnt;
    }
}
