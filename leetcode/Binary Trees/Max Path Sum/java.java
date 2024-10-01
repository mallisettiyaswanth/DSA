
class Solution {
    public int maxPathSum(TreeNode root) {
        int[] maxCost = {Integer.MIN_VALUE};
        maxSum(root, maxCost);
        return maxCost[0];
    }

    public int maxSum(TreeNode node, int[] maxCost) {
        if(node == null) return 0;
        int left = Math.max(0, maxSum(node.left, maxCost));
        int right = Math.max(0, maxSum(node.right, maxCost));
        maxCost[0] = Math.max(maxCost[0], left + right + node.val);
        return Math.max(left , right) + node.val;

    }
}
