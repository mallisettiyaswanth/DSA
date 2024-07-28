import java.util.*;
public class Solution {
    public ListNode detectCycle(ListNode head) {
        Hashtable<ListNode, Integer> hs = new Hashtable<ListNode, Integer>();
        ListNode temp = head;
        while(temp != null) {
            if(hs.containsKey(temp)) {
                return temp;
            } else {
                hs.put(temp, temp.val);   
            }
            temp = temp.next;
        }
        return null;
    }
}