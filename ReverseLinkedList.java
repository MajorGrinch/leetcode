class Solution {
    ListNode dummyhead = new ListNode(-1);
    public ListNode reverseList(ListNode head) {
        // Listnode dummyhead = new ListNode(-1);
        dummyhead.next = head;
        reverse(head);
        return dummyhead.next;
    }

    private ListNode reverse(ListNode curr){
        if(curr == null || curr.next == null){
            dummyhead.next = curr;
            return curr;
        }
        ListNode nxt = reverse(curr.next);
        nxt.next = curr;
        curr.next = null;
        return curr;
    }
}

class Solution2{
    public ListNode reverseList(ListNode head){
        if(head == null){
            return head;
        }
        ListNode curr = null, prev = null;
        while(head != null){
            curr = head;
            head = head.next;
            curr.next = prev;
            prev = curr;
        }
        return curr;
    }
}