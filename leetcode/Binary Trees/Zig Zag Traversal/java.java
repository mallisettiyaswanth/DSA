
class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        int direction = -1;
        Deque<TreeNode> q=new ArrayDeque<TreeNode>();
        List<List<Integer>> ls = new ArrayList<>();
        if(root == null) return ls;
        q.addFirst(root);
        while(!q.isEmpty()) {
            int size = q.size();
            List<Integer> ar = new ArrayList<>();
            for(int i = 0; i < size; i++) {
                TreeNode node;
                if(direction == 1) {
                    node = q.removeFirst();
                ar.add(node.val);
                if(node.right != null) {
                    q.addLast(node.right);
                }
                if(node.left != null) {
                    q.addLast(node.left);
                }
                } else {
                    node = q.removeLast();
                ar.add(node.val);
                    if(node.left != null) {
                    q.addFirst(node.left);
                }
                if(node.right != null) {
                    q.addFirst(node.right);
                }
                }

            }
            direction *= -1;
            ls.add(ar);
        }
        return ls;
    }
}
