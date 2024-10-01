class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        Stack<TreeNode> stk = new Stack<TreeNode>();
        List<Integer> ls = new ArrayList<Integer>();
        if(root == null) return ls;
        TreeNode tempNode = root;

        while(tempNode != null || !stk.isEmpty()) {
            while(tempNode != null) {
                stk.push(tempNode);
                tempNode = tempNode.left;
            }
            tempNode = stk.pop();
            ls.add(tempNode.val);
            tempNode = tempNode.right;
        }
        return ls;
    }
}
