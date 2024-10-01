class Solution {
    public int diameterOfBinaryTree(TreeNode root) {
        if(root == null) return 0;
        int[] diameter = new int[1];
        findDiameter(root, diameter);
        return diameter[0];
    }

    public int findDiameter(TreeNode node, int[] diameter) {
        if(node == null) return 0;
        int left = findDiameter(node.left, diameter);
        int right = findDiameter(node.right, diameter);
        diameter[0] = Math.max(diameter[0], right + left);

        return Math.max(left, right) + 1;
    }
}
