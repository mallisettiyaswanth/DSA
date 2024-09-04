// dfs
class Solution {
    private void dfs(char[][] board, int[][] vis, int row, int col, int[] delRow, int[] delCol) {
        vis[row][col] = 1;
        for(int i = 0; i < 4; i++) {
            int nrow = row + delRow[i];
            int ncol = col + delCol[i];
            if(nrow >= 0 && nrow < board.length && ncol >= 0 && ncol < board[0].length && vis[nrow][ncol] != 1
            && board[nrow][ncol] == 'O') {
                dfs(board, vis, nrow, ncol, delRow, delCol);
            }
        }
    }

    public void solve(char[][] board) {
        if (board == null || board.length == 0 || board[0].length == 0) {
            return;
        }
        int[][] vis = new int[board.length][board[0].length];
        int[] delRow = {-1, 0, 1, 0};
        int[] delCol = {0, 1, 0, -1};
        for(int j = 0; j < board[0].length; j++) {
            if(vis[0][j] == 0 && board[0][j] == 'O') {
                dfs(board, vis, 0, j, delRow, delCol);
            }
            if(vis[board.length - 1][j] == 0 && board[board.length - 1][j] == 'O') {
                dfs(board, vis, board.length - 1, j, delRow, delCol);
            }
        }
        for(int i = 0; i < board.length; i++) {
            if(vis[i][0] == 0 && board[i][0] == 'O') {
                dfs(board, vis, i, 0, delRow, delCol);
            }
            if(vis[i][board[0].length - 1] == 0 && board[i][board[0].length - 1] == 'O') {
                dfs(board, vis, i, board[0].length - 1, delRow, delCol);
            }
        }
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                if(vis[i][j] != 1 && board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }
    }
}


//bfs
import java.util.LinkedList;
import java.util.Queue;

class Solution {
    private void bfs(char[][] board, int[][] vis, int startRow, int startCol, int[] delRow, int[] delCol) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{startRow, startCol});
        vis[startRow][startCol] = 1;

        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            int row = cell[0];
            int col = cell[1];

            for (int i = 0; i < 4; i++) {
                int nrow = row + delRow[i];
                int ncol = col + delCol[i];

                if (nrow >= 0 && nrow < board.length && ncol >= 0 && ncol < board[0].length
                    && vis[nrow][ncol] == 0 && board[nrow][ncol] == 'O') {
                    vis[nrow][ncol] = 1;
                    queue.add(new int[]{nrow, ncol});
                }
            }
        }
    }

    public void solve(char[][] board) {
        if (board == null || board.length == 0 || board[0].length == 0) {
            return;
        }

        int[][] vis = new int[board.length][board[0].length];
        int[] delRow = {-1, 0, 1, 0};
        int[] delCol = {0, 1, 0, -1};

        // Traverse the first and last row
        for (int j = 0; j < board[0].length; j++) {
            if (vis[0][j] == 0 && board[0][j] == 'O') {
                bfs(board, vis, 0, j, delRow, delCol);
            }
            if (vis[board.length - 1][j] == 0 && board[board.length - 1][j] == 'O') {
                bfs(board, vis, board.length - 1, j, delRow, delCol);
            }
        }

        // Traverse the first and last column
        for (int i = 0; i < board.length; i++) {
            if (vis[i][0] == 0 && board[i][0] == 'O') {
                bfs(board, vis, i, 0, delRow, delCol);
            }
            if (vis[i][board[0].length - 1] == 0 && board[i][board[0].length - 1] == 'O') {
                bfs(board, vis, i, board[0].length - 1, delRow, delCol);
            }
        }

        // Convert all unvisited 'O' to 'X'
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (vis[i][j] == 0 && board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }
    }
}
