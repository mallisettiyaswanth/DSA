class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> ls = new ArrayList<Integer>();
        if(root == null) return ls;
        Stack<TreeNode> stk = new Stack<TreeNode>();
        stk.push(root);

        while(!stk.isEmpty()) {
            TreeNode node = stk.peek();
            stk.pop();
            ls.add(node.val);
            if(node.right != null) {
                stk.push(node.right);
            }
            if(node.left != null) {
                stk.push(node.left);
            }
        }

        return ls;
    }
}
