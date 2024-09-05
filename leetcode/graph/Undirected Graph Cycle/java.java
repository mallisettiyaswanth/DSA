//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String[] s = br.readLine().trim().split(" ");
            int V = Integer.parseInt(s[0]);
            int E = Integer.parseInt(s[1]);
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            for (int i = 0; i < V; i++) adj.add(i, new ArrayList<Integer>());
            for (int i = 0; i < E; i++) {
                String[] S = br.readLine().trim().split(" ");
                int u = Integer.parseInt(S[0]);
                int v = Integer.parseInt(S[1]);
                adj.get(u).add(v);
                adj.get(v).add(u);
            }
            Solution obj = new Solution();
            boolean ans = obj.isCycle(V, adj);
            if (ans)
                System.out.println("1");
            else
                System.out.println("0");
        }
    }
}
// } Driver Code Ends


class Solution {
    // Function to detect cycle in an undirected graph.
    class Pair {
        int child;
        int parent;
        Pair(int child, int parent) {
            this.child = child;
            this.parent = parent;
        }
    }
    private boolean checkForCycle(int i, ArrayList<ArrayList<Integer>> adj, int[] vis) {
        Queue<Pair> queue =  new LinkedList<Pair>();
        queue.add(new Pair(i, -1));
        vis[i] = 1;

        while(!queue.isEmpty()) {
            int child = queue.peek().child;
            int parent = queue.peek().parent;
            queue.remove();

            for(int val: adj.get(child)) {
                if(vis[val] == 0) {
                    vis[val] = 1;
                    queue.add(new Pair(val, child));
                }  else if (parent != val) {
                    return true;
                }
            }
        }

        return false;
    }

    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        int[] vis = new int[V];
        for(int i = 0; i < V; i++) {
            if(vis[i] != 1) {
                if(checkForCycle(i, adj, vis)) return true;
            }
        }

        return false;
    }
}
