class Solution {

    private static void dfs(int num, ArrayList<ArrayList<Integer>> adj, Stack<Integer> stk, int[] vis) {
        vis[num] = 1;
        for(int i: adj.get(num)) {
            if(vis[i] != 1) {
                dfs(i, adj, stk, vis);
            }
        }
        stk.push(num);
    }

    // Function to return list containing vertices in Topological order.
    static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) {
        int[] vis = new int[V];
        Stack<Integer> stk = new Stack<Integer>();

        for(int i = 0 ; i < V; i++) {
            if(vis[i] != 1) {
                dfs(i, adj, stk, vis);
            }
        }

        int[] ans = new int[V];
        int i = 0;
        while(!stk.isEmpty()) {
            ans[i++] = stk.pop();
        }

        return ans;
    }
}
