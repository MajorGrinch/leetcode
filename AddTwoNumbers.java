/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode p1 = l1, p2 = l2;
        ListNode nxt1 = l1.next, nxt2 = l2.next;
        ListNode ans = new ListNode(p1.val+p2.val);
        ListNode pa = ans;
        while(nxt1 != null || nxt2 != null){
            int sum = 0;
            sum += (nxt1==null) ? 0 : nxt1.val;
            sum += (nxt2==null) ? 0 : nxt2.val;
            pa.next = new ListNode(sum);
            pa = pa.next;
            if(nxt1 != null){
                nxt1 = nxt1.next;
            }
            if(nxt2 != null){
                nxt2 = nxt2.next;
            }
        }
        pa = ans;
        while(pa != null){
            if(pa.next != null){
                pa.next.val += pa.val / 10;
            }else if(pa.val >= 10){
                pa.next = new ListNode(pa.val/10);
            }
            pa.val %= 10;
            pa = pa.next;
        }
        return ans;
    }
}