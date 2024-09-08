class Solution {
    // Function to detect cycle in a directed graph.
    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
        // code here

        int[] indegree = new int[V];
        for(int i = 0; i < V; i++) {
            for(int j: adj.get(i)) {
                indegree[j]++;
            }
        }

        Queue<Integer> queue = new LinkedList<Integer>();
        for(int i = 0; i < indegree.length; i++) {
            if(indegree[i] == 0) {
                queue.add(i);
            }
        }

        while(!queue.isEmpty()) {
            int n = queue.peek();
            queue.remove();

            for(int i: adj.get(n)) {
                indegree[i]--;
                if(indegree[i] == 0) queue.add(i);
            }
        }

        for(int i = 0; i < indegree.length; i++) {
            if(indegree[i] != 0) {
                return true;
            }
        }

        return false;
    }
}
