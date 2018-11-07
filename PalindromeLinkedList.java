import java.util.Stack;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    /** 
     * cur the list into half and reverse the second half
     * then compare
     */
    public boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null) return true;
        //cut the list into half
        ListNode slow = head, fast = head.next.next;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        //if fast is null means even nodes else odd nodes
        ListNode right = (fast == null ? slow.next : slow.next.next);
        ListNode left = head;
        //reverse right half
        ListNode curr = null, prev = null;
        while(right != null){
            curr = right;
            right = right.next;
            curr.next = prev;
            prev = curr;
        }
        while(curr != null){
            if(curr.val != left.val){
                return false;
            }
            curr = curr.next;
            left = left.next;
        }
        return true;
    }
}