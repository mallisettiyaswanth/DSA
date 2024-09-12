class Solution {
    private int minPathCost(int[][] grid, int m, int n, int i, int j) {
        if(m >= i  || n >= j) return Integer.MAX_VALUE;
        if(m == i - 1 && n == j - 1) return grid[m][n];
        int right = minPathCost(grid, m + 1, n, i, j);
        int left = minPathCost(grid, m, n + 1, i, j);
        return grid[m][n] + Math.min(right, left);
    }

    public int minPathSum(int[][] grid) {
        int i = grid.length;
        int j = grid[0].length;
        return minPathCost(grid, 0, 0, i, j);
    }
}



// memoization
class Solution {
    private int minPathCost(int[][] grid, int m, int n, int i, int j, int[][] dp) {
        if(m >= i  || n >= j) return Integer.MAX_VALUE;
        if(m == i - 1 && n == j - 1) return grid[m][n];
        if(dp[m][n] != -1) return dp[m][n];
        int right = minPathCost(grid, m + 1, n, i, j, dp);
        int left = minPathCost(grid, m, n + 1, i, j, dp);
        dp[m][n] = grid[m][n] + Math.min(right, left);
        return dp[m][n];
    }

    public int minPathSum(int[][] grid) {
        int i = grid.length;
        int j = grid[0].length;
        int[][] dp = new int[i][j];
        for(int[] row: dp) Arrays.fill(row, -1);
        return minPathCost(grid, 0, 0, i, j, dp);
    }
}
