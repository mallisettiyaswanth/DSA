 */
class Solution {
    public boolean isBalanced(TreeNode root) {
        if(root == null) return true;

        int res = height(root);
        if(res == -1) return false;
        return true;
    }

    public int height(TreeNode node) {
        if(node == null) return 0;

        int left = height(node.left);
        int right = height(node.right);

        if(left == -1 || right == -1) return -1;
        int res = Math.abs(left - right);
        if(res > 1) return -1;

        return Math.max(left, right) + 1;
    }
}
