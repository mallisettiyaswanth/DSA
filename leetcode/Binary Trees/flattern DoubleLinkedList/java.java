
class Solution {

    public void attachChild(Node root, Node node) {
        Node childNode = node;
        while(childNode.next != null) {
            childNode = childNode.next;
        }
        childNode.next = root.next;
        if (root.next != null) {
            root.next.prev = childNode;
        }
        root.next = node;
        node.prev = root;
    }

    public Node flatten(Node head) {
        if(head == null) return null;
        Node tempNode = head;
        while(tempNode != null) {
            if(tempNode.child != null) {
                Node node = flatten(tempNode.child);
                attachChild(tempNode, node);
                tempNode.child = null;
            }
            tempNode = tempNode.next;

        }
        return head;
    }
}
