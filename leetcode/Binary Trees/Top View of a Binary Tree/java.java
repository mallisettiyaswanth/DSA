class Solution {
    // Function to return a list of nodes visible from the top view
    // from left to right in Binary Tree.
    static class Pair {
        int col, level;
        Node node;
        Pair(Node node, int col, int level) {
            this.node = node;
            this.col = col;
            this.level = level;
        }
    }

    static ArrayList<Integer> topView(Node root) {
        // add your code
        ArrayList<Integer> arr = new ArrayList<>();
        if(root == null) return arr;

        PriorityQueue<Pair> pq = new PriorityQueue<Pair>((a, b) -> {
            if(a.col == b.col) return a.level - b.level;
            return a.col - b.col;
        });

        Queue<Pair> q = new LinkedList<>();
        Map<Integer, Pair> map = new HashMap<>();
        q.add(new Pair(root, 0, 0));

        while(!q.isEmpty()) {
            int size = q.size();
            for(int i = 0; i < size; i++) {
                Pair pair = q.peek();
                q.remove();
                if(!map.containsKey(pair.col)) {
                    map.put(pair.col, pair);
                }
                if(pair.node.left != null) {
                    q.add(new Pair(pair.node.left, pair.col - 1, pair.level + 1));
                }
                if(pair.node.right != null) {
                    q.add(new Pair(pair.node.right, pair.col + 1, pair.level + 1));
                }
            }
        }

        for(Map.Entry<Integer, Pair> entry: map.entrySet()) {
            pq.add(entry.getValue());
        }

        while(!pq.isEmpty()) {
            arr.add(pq.poll().node.data);
        }

        return arr;

    }
}
