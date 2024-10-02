class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ret  = new ArrayList<>();
        if (root == null) return ret;

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            int size = q.size();
            TreeNode rightMost = null;

            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll(); // Dequeue the node
                rightMost = node; // Keep updating to track the last node at this level

                if (node.left != null) q.add(node.left);
                if (node.right != null) q.add(node.right);
            }

            // The last node processed at this level is the rightmost node
            ret.add(rightMost.val);
        }

        return ret;
    }
}
