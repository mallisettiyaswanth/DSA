class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || head.next == null || k == 0) return head;
        int length = 1;
        ListNode tail = head;
        while (tail.next != null) {
            tail = tail.next;
            length++;
        }
        k = k % length;
        if (k == 0) {
            return head;
        }
        for(int i = 0; i < k; i++) {
            head = removeLastAddFirst(head);
        }
        return head;
    }

    public ListNode removeLastAddFirst(ListNode head) {
        ListNode temp = head;
        while(temp.next.next != null) {
            temp = temp.next;
        }
        ListNode tempHead = temp.next;
        temp.next = null;
        tempHead.next = head;
        return tempHead;
    }
}