class Solution {
    class Pair {
        int row;
        int col;
        Pair(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }
    private int bfs(int[][] grid, int[][] vis, int row, int col, int[] delRow, int[] delCol) {
        vis[row][col] = 1;
        Queue<Pair> queue = new LinkedList<Pair>();
        queue.add(new Pair(row, col));
        int area = 1;

        while(!queue.isEmpty()) {
            int qrow = queue.peek().row;
            int qcol = queue.peek().col;
            queue.remove();

            for(int i = 0; i < 4; i++) {
                int nrow = qrow + delRow[i];
                int ncol = qcol + delCol[i];
                if(nrow >= 0 && nrow < grid.length && ncol >= 0 && ncol < grid[0].length && vis[nrow][ncol] != 1
                && grid[nrow][ncol] == 1) {
                    queue.add(new Pair(nrow, ncol));
                    vis[nrow][ncol] = 1;
                    area++;
                }
            }
        }

        return area;
    }
    public int maxAreaOfIsland(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] vis = new int[m][n];
        int[] delRow = {-1, 0, 1, 0};
        int[] delCol = {0, 1, 0, -1};
        int maxArea = 0;

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(vis[i][j] != 1 && grid[i][j] == 1) {
                    int area = bfs(grid, vis, i, j, delRow, delCol);
                    maxArea = Math.max(maxArea, area);
                }
            }
        }

        return maxArea;
    }
}
