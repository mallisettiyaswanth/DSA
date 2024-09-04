class Solution {
    private void dfs(int[][] grid, int[][] vis, int row, int col, int[] delRow, int[] delCol) {
        vis[row][col] = 1;
        grid[row][col] = 0;
        for(int i = 0; i < 4; i++) {
            int nrow = row + delRow[i];
            int ncol = col + delCol[i];
            if(nrow >= 0 && nrow < grid.length && ncol >= 0 && ncol < grid[0].length && vis[nrow][ncol] != 1
            && grid[nrow][ncol] == 1) {
                dfs(grid, vis, nrow, ncol, delRow, delCol);
            }
        }
    }

    public int numEnclaves(int[][] grid) {
        int[][] vis = new int[grid.length][grid[0].length];
        int[] delRow = {-1, 0, 1, 0};
        int[] delCol = {0, 1, 0, -1};

        for(int j = 0; j < grid[0].length; j++) {
            if(vis[0][j] != 1 && grid[0][j] == 1) {
                dfs(grid, vis, 0, j, delRow, delCol);
            }
            if(vis[grid.length - 1][j] != 1 && grid[grid.length - 1][j] == 1) {
                dfs(grid, vis, grid.length -1, j, delRow, delCol);
            }
        }

        for(int i = 0; i < grid.length; i++) {
            if(vis[i][0] != 1 && grid[i][0] == 1) {
                dfs(grid, vis, i, 0, delRow, delCol);
            }
            if(vis[i][grid[0].length - 1] != 1 && grid[i][grid[0].length -1] == 1) {
                dfs(grid, vis, i, grid[0].length -1, delRow, delCol);
            }
        }
        int cnt = 0;
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == 1) {
                    cnt++;
                }
            }
        }

        return cnt;

    }
}
