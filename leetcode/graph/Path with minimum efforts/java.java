class Solution {
    class Node {
        int row, col, effort;
        Node(int row, int col, int effort) {
            this.row = row;
            this.col = col;
            this.effort = effort;
        }
    }
    public int minimumEffortPath(int[][] heights) {
        int m = heights.length;
        int n = heights[0].length;
        PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> a.effort - b.effort);
        int[][] effort = new int[m][n];
        for (int[] row : effort) Arrays.fill(row, Integer.MAX_VALUE);
        pq.add(new Node(0, 0, 0));
        effort[0][0] = 0;
        int[] delRow = {-1, 0, 1, 0};
        int[] delCol = {0, 1, 0, -1};

        while (!pq.isEmpty()) {
            Node current = pq.poll();
            int row = current.row;
            int col = current.col;
            int currentEffort = current.effort;

            if (row == m - 1 && col == n - 1) {
                return currentEffort;
            }

            for (int i = 0; i < 4; i++) {
                int newRow = row + delRow[i];
                int newCol = col + delCol[i];
                if (newRow >= 0 && newRow < m && newCol >= 0 && newCol < n) {
                    int newEffort = Math.max(currentEffort, Math.abs(heights[row][col] - heights[newRow][newCol]));
                    if (newEffort < effort[newRow][newCol]) {
                        effort[newRow][newCol] = newEffort;
                        pq.add(new Node(newRow, newCol, newEffort));
                    }
                }
            }
        }

        return effort[m - 1][n - 1];
    }
}
