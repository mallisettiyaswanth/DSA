class Solution {
    class Node {
        int dis;
        int node;
        Node(int dis, int node) {
            this.dis = dis;
            this.node = node;
        }
    }
    static int[] dijkstra(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj, int S) {
        PriorityQueue<Node> pq = new PriorityQueue<Node>((x, y) -> x.dis - y.dis);
        pq.add(new Solution().new Node(0, S));
        int[] distance = new int[V];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[S] = 0;

        while(!pq.isEmpty()) {
            Node node = pq.poll();
            int dis = node.dis;
            int vertex = node.node;
            for (ArrayList<Integer> neighbor : adj.get(vertex)) {
                int adjNode = neighbor.get(0);
                int edgeWeight = neighbor.get(1);
                if (dis + edgeWeight < distance[adjNode]) {
                    distance[adjNode] = dis + edgeWeight;
                    pq.add(new Solution().new Node(distance[adjNode], adjNode));
                }
            }
        }

        return distance;
    }
}
