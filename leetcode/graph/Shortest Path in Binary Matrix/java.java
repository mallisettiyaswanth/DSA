class Solution {
    class Node {
        int row;
        int col;
        Node(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }
    public int shortestPathBinaryMatrix(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        if(grid[0][0]==1 || grid[n-1][m-1]==1){
            return -1;
        }

        int[][] dis = new int[m][n];
        Queue<Node> q = new LinkedList<Node>();
        q.add(new Node(0, 0));
        int[] delRow = {-1, -1, -1, 0, 1, 1, 1, 0};
        int[] delCol = {-1, 0, 1, 1, 1, 0, -1, -1};
        int ans = 1;
        while(!q.isEmpty()) {
            int size = q.size();
            while(size > 0) {
                int row = q.peek().row;
                int col = q.peek().col;
                q.remove();
                if(row == m - 1 && col == n - 1) return ans;
                for(int i = 0; i < 8; i++) {
                    int nrow = row + delRow[i];
                    int ncol = col + delCol[i];
                    if(nrow >= 0 && nrow < m && ncol >= 0 && ncol < n && dis[nrow][ncol] != 1
                    && grid[nrow][ncol] == 0) {
                        q.add(new Node(nrow, ncol));
                        dis[nrow][ncol] = 1;
                    }
                }
                size--;
            }
            if(q.isEmpty()) return -1;
            ans++;
        }
        return ans;
    }
}
