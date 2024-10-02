
class Solution {
    class Node {
        TreeNode node;
        int col;
        int row;
        Node(int col, int row, TreeNode node) {
            this.node = node;
            this.col = col;
            this.row = row;
        }
    }

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> ls2 = new ArrayList<>();
        if (root == null) return ls2;
        TreeMap<Integer, PriorityQueue<int[]>> map = new TreeMap<>();
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(0, 0, root));
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                Node curr = q.remove();
                TreeNode node = curr.node;
                int col = curr.col;
                int row = curr.row;
                map.putIfAbsent(col, new PriorityQueue<>((a, b) -> {
                    if (a[1] == b[1]) {
                        return a[0] - b[0];
                    } else {
                        return a[1] - b[1];
                    }
                }));
                map.get(col).add(new int[]{node.val, row});
                if (node.left != null) {
                    q.add(new Node(col - 1, row + 1, node.left));
                }
                if (node.right != null) {
                    q.add(new Node(col + 1, row + 1, node.right));
                }
            }
        }
        for (Map.Entry<Integer, PriorityQueue<int[]>> entry : map.entrySet()) {
            PriorityQueue<int[]> pq = entry.getValue();
            List<Integer> columnList = new ArrayList<>();
            while (!pq.isEmpty()) {
                columnList.add(pq.poll()[0]);
            }
            ls2.add(columnList);
        }

        return ls2;
    }


}
