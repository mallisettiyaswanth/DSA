class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        Map<Integer, Integer> inMap = new HashMap<>();
        for(int i = 0; i < inorder.length; i++) {
            inMap.put(inorder[i], i);
        }

        return buildBinTree(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1,  inMap);
    }

    public TreeNode buildBinTree(int[] inorder, int is, int ie, int[] postorder, int ps, int pe, Map<Integer, Integer> inMap) {
        if(is > ie || ps > pe)  {
            return null;
        }
        TreeNode root = new TreeNode(postorder[pe]);
        int indRoot = inMap.get(root.val);
        int numRight = ie - indRoot;
        root.left = buildBinTree(inorder, is, indRoot - 1, postorder, ps, pe - numRight - 1, inMap);
        root.right = buildBinTree(inorder, indRoot + 1, ie, postorder, pe - numRight, pe - 1, inMap);
        return root;
    }
}
