class Solution {

    class Node {
        int node;
        long cost;
        Node(int node, long cost) {
            this.node = node;
            this.cost = cost;
        }
    }

    class Pair {
        long cost;
        long reachCount;
        Pair(long cost, long reachCount) {
            this.cost = cost;
            this.reachCount = reachCount;
        }
    }

    class AdjPair {
        int node;
        long cost;
        AdjPair(int node, long cost) {
            this.node = node;
            this.cost = cost;
        }
    }

    private static final int MOD = 1_000_000_007;

    public int countPaths(int n, int[][] roads) {
        ArrayList<ArrayList<AdjPair>> adjList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }
        for (int[] road : roads) {
            adjList.get(road[0]).add(new AdjPair(road[1], road[2]));
            adjList.get(road[1]).add(new AdjPair(road[0], road[2]));
        }
        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingLong(a -> a.cost));
        pq.add(new Node(0, 0));
        Pair[] arr = new Pair[n];
        for (int i = 0; i < n; i++) {
            arr[i] = new Pair(Long.MAX_VALUE, 0);
        }
        arr[0] = new Pair(0, 1);

        while (!pq.isEmpty()) {
            Node curr = pq.poll();
            long cost = curr.cost;
            int node = curr.node;

            if (cost > arr[node].cost) {
                continue;
            }

            for (AdjPair adj : adjList.get(node)) {
                int neighbourNode = adj.node;
                long neighbourCost = adj.cost;
                long newCost = cost + neighbourCost;

                if (newCost == arr[neighbourNode].cost) {
                    arr[neighbourNode].reachCount = (arr[neighbourNode].reachCount + arr[node].reachCount) % MOD;
                } else if (newCost < arr[neighbourNode].cost) {
                    arr[neighbourNode].cost = newCost;
                    arr[neighbourNode].reachCount = arr[node].reachCount;
                    pq.add(new Node(neighbourNode, newCost));
                }
            }
        }


        return (int) arr[n - 1].reachCount;
    }
}
