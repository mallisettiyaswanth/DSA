class Solution {
    private void dfs(char[][] board, int[][] vis, int row, int col, int[] delRow, int[] delCol) {
        vis[row][col] = 1;
        for(int i = 0; i < 4; i++) {
            int nrow = row + delRow[i];
            int ncol = col + delCol[i];
            if(nrow >= 0 && nrow < board.length && ncol >= 0 && ncol < board[0].length && vis[nrow][ncol] != 1
            && board[nrow][ncol] == 'X') {
                vis[nrow][ncol] = 1;
                dfs(board, vis, nrow, ncol, delRow, delCol);
            }

        }
    }
    public int countBattleships(char[][] board) {
     int m = board.length;
     int n = board[0].length;
     int[][] vis = new int[m][n];
     int battleShips = 0;
     int[] delRow = {-1, 0, 1, 0};
     int[] delCol = {0, 1, 0, -1};

     for(int i = 0; i < m; i++) {
        for(int j = 0; j < n; j++) {
            if(vis[i][j] != 1 && board[i][j] == 'X') {
                dfs(board, vis, i, j, delRow, delCol);
                battleShips++;
            }
        }
     }
     return battleShips;
    }
}
