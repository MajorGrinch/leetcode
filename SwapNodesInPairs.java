class Solution {
    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode p1 = head, p2 = head.next;
        ListNode res = p2;
        while(p2 != null){
            p1.next = p2.next;
            p2.next = p1;
            ListNode prev = p1;
            p1 = p1.next;
            if(p1 == null) break;
            p2 = p1.next;
            if(p2 != null) prev.next = p2;
        }
        return res;
    }
}
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}
public class SwapNodesInPairs{
    public static void main(String[] args) {
        int[] a = {1,2,3,4, 5};
        Solution s = new Solution();
        ListNode head = createList(a);
        printList(head);
        ListNode newHead = s.swapPairs(head);
        printList(newHead);

    }

    public static void printList(ListNode head){
        while(head != null){
            System.out.print(head.val + "->");
            head = head.next;
        }
        System.out.println();
    }
    private static ListNode createList(int[] num){
        ListNode head = new ListNode(num[0]);
        ListNode p = head;
        for(int i = 1; i < num.length; i++){
            p.next = new ListNode(num[i]);
            p = p.next;
        }
        return head;
    }
}
