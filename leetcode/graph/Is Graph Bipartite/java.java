class Solution {
    private boolean dfs(int[][] graph, int[] color, int node, int c) {
        color[node] = c;
        for (int neighbor : graph[node]) {
            if (color[neighbor] == 0) {
                if (!dfs(graph, color, neighbor, -c)) {
                    return false;
                }
            }
            else if (color[neighbor] == color[node]) {
                return false;
            }
        }
        return true;
    }

    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[] color = new int[n];
        for (int i = 0; i < n; i++) {
            if (color[i] == 0) {
                if (!dfs(graph, color, i, 1)) {
                    return false;
                }
            }
        }
        return true;
    }
}
