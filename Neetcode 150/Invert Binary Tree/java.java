class Solution {
    public TreeNode invertTree(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        if(root == null) return null;
        q.add(root);
        while(!q.isEmpty()) {
            TreeNode trail = q.remove();
            TreeNode temp = trail.left;
            trail.left = trail.right;
            trail.right = temp;
            if(trail.left != null) q.add(trail.left);
            if(trail.right != null) q.add(trail.right);

        }
        return root;
    }
}