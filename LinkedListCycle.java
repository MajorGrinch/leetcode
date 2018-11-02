import java.util.HashSet;
import java.util.Set;

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
}

class Solution {
    public boolean hasCycle(ListNode head) {
        Set<ListNode> s = new HashSet<>();
        ListNode p = head;
        while(p != null){
            if(s.contains(p)) return true;
            s.add(p);
            p = p.next;
        }
        return false;
    }
}