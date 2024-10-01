 class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ls = new ArrayList<>();
        if(root == null) return ls;
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.add(root);
        while(!q.isEmpty()) {
            int size = q.size();
            List<Integer> ar = new ArrayList<>();
            for(int i = 0; i < size; i++) {
                TreeNode node = q.poll();
                ar.add(node.val);


                if(node.left != null) {
                    q.add(node.left);
                }
                if(node.right != null) {
                    q.add(node.right);
                }
            }
            ls.add(ar);
        }
        return ls;
    }
}
