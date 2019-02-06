/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    ListNode lastTail = new ListNode(-1);
    public ListNode reverseKGroup(ListNode head, int k) {
        lastTail.next = head;
        ListNode dummy = lastTail;
        ListNode p = head;
        while(p != null){
            int i;
            for(i = 0; i < k && p != null; i++){
                p = p.next;
            }
            if(i < k){
                lastTail.next = head;
                break;
            };
            lastTail = reverseK(head, k);
            head = p;
        }
        return dummy.next;
    }

    private ListNode reverseK(ListNode curr, int k){
        if(k == 1){
            lastTail.next = curr;
            return curr;
        }
        ListNode nxt = reverseK(curr.next, k-1);
        nxt.next = curr;
        curr.next = null;
        return curr;
    }
}