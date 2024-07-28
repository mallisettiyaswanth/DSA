
class Solution {
    public void deleteNode(ListNode node) {
        int val = node.next.val;
        node.val = val;
        ListNode nextNode = node.next.next;
        node.next = nextNode;
    }
}