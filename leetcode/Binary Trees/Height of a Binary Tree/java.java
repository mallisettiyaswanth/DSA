class Solution {
    public int maxDepth(TreeNode root) {
        if(root == null) return 0;
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.add(root);
        List<List<Integer>> ls = new ArrayList<>();
        while(!q.isEmpty()) {
            int size = q.size();
            List<Integer> ar = new ArrayList<Integer>();
            for(int i = 0; i < size; i++) {
                TreeNode node = q.peek();
                q.remove();
                ar.add(node.val);
                if(node.left != null) {
                    q.add(node.left);
                }
                if(node.right != null) {
                    q.add(node.right);
                }
            }
            if(ar.size() > 0) {
                ls.add(ar);
            }
        }

        return ls.size();
    }
}
