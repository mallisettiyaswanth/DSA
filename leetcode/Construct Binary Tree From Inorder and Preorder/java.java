class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> inMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inMap.put(inorder[i], i);
        }
        return buildBinTree(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1, inMap);
    }
    public TreeNode buildBinTree(int[] preorder, int ps, int pe, int[] inorder, int is,
                                 int ie, Map<Integer, Integer> inMap) {
        if (ps > pe || is > ie) {
            return null;
        }
        TreeNode node = new TreeNode(preorder[ps]);
        int inRoot = inMap.get(node.val);
        int numLeft = inRoot - is;
        node.left = buildBinTree(preorder, ps + 1, ps + numLeft, inorder, is, inRoot - 1, inMap);
        node.right = buildBinTree(preorder, ps + numLeft + 1, pe, inorder, inRoot + 1, ie, inMap);
        return node;
    }
}
