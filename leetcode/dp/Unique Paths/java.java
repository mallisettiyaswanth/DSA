// memo

class Solution {
    private int paths(int m, int n, int[][] arr, int i, int j) {
        if(i>=m || j>=n) return 0;
        if(i==m-1 || j==n-1) return 1;
        if(arr[i][j] != -1) return arr[i][j];
        arr[i][j] = paths(m, n, arr, i+1, j) + paths(m, n, arr, i, j+1);
        return arr[i][j];
    }

    public int uniquePaths(int m, int n) {
        int[][] arr = new int[m][n];
        for(int[] row: arr) {
            Arrays.fill(row, -1);
        }
        return paths(m, n, arr, 0, 0);
    }
}
