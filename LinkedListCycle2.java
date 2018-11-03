import java.util.HashSet;
import java.util.Set;

public class Solution {
    public ListNode detectCycle(ListNode head) {
        Set<ListNode> s = new HashSet<>();
        while(head != null){
            if(s.contains(head)){
                return head;
            }
            s.add(head);
            head = head.next;
        }
        return head;
    }
}

class Solution2{
    public ListNode detectCycle(ListNode head){
        if(head == null || head.next == null) return null;
        ListNode slow = head.next, fast = slow.next;
        while(slow != fast){
            if(fast == null || fast.next == null){
                return null;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode p = head;
        while(p != slow){
            p = p.next;
            slow = slow.next;
        }
        return p;
    }
}