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
        ListNode p1 = l1;
        ListNode p2 = l2;
        int count1 = 0, count2 = 0;
        while(p1 != null){
            count1++;
            p1 = p1.next;
        }
        while(p2 != null){
            count2++;
            p2 = p2.next;
        }
        if(count1 < count2){
            return addTwoNumbers(l2, l1);
        }
        p1 = l1;
        p2 = l2;
        ListNode ans = new ListNode(0);
        ListNode pa = ans;
        while(count1 > count2){
            pa.next = new ListNode(p1.val);
            pa = pa.next;
            p1 = p1.next;
            count1--;
        }
        while(p1 != null){
            pa.next = new ListNode(p1.val+p2.val);
            pa = pa.next;
            p1 = p1.next;
            p2 = p2.next;
        }
        pa = ans;
        while(pa.next != null){
            pa.val += pa.next.val / 10;
            pa.next.val %= 10;
            pa = pa.next;
        }
        
        boolean need_carry = containCarry(ans);
        while(need_carry){
            pa = ans;
            while(pa.next != null){
                pa.val += pa.next.val / 10;
                pa.next.val %= 10;
                pa = pa.next;
            }
            need_carry = containCarry(ans);
        }

        if(ans.val != 0){
            return ans;
        }else{
            return ans.next;
        }
    }
    boolean containCarry(ListNode l){
        ListNode p = l;
        while(p != null){
            if(p.val > 9){
                return true;
            }
            p = p.next;
        }
        return false;
    }
}