class Solution {
    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null) return head;
        int n = getLength(head);
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode left, right, rear, cur;
        for(int sz = 1; sz < n; sz += sz){
            cur = dummy.next;
            rear = dummy;
            while(cur != null){
                left = cur;
                right = splitList(cur, sz);
                cur = splitList(right, sz);
                rear = mergeList(left, right, rear);
            }
        }
        return dummy.next;
    }

    private int getLength(ListNode head){
        int len = 0;
        while(head != null){
            len++;
            head = head.next;
        }
        return len;
    }

    //split the list from the node len+1
    private ListNode splitList(ListNode head, int len){
        for(int i = 1; i < len && head != null; i++){
            head = head.next;
        }
        if(head == null) return head;
        ListNode right = head.next;
        head.next = null;
        return right;
    }

    private ListNode mergeList(ListNode l1, ListNode l2, ListNode tmphead){
        while(l1 != null && l2 != null){
            if(l1.val > l2.val){
                tmphead.next = l2;
                l2 = l2.next;
                tmphead = tmphead.next;
            }else{
                tmphead.next = l1;
                l1 = l1.next;
                tmphead = tmphead.next;
            }
        }
        tmphead.next = (l1 == null ? l2 : l1);
        while(tmphead.next != null){
            tmphead = tmphead.next;
        }
        return tmphead;
    }
}

class Solution2{
    public ListNode sortList(ListNode head) {
        return splitList(head);
    }
    private ListNode splitList(ListNode node){
        // printList(node);
        if(node == null || node.next == null){
            return node;
        }
        ListNode slow = node, fast = node.next.next;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode right = slow.next;
        slow.next = null;
        return mergeList(splitList(node), splitList(right));
    }

    private ListNode mergeList(ListNode l1, ListNode l2){
        ListNode start, tmphead;
        if(l2 == null || l1 == null){
            return l1;
        }
        if(l1.val < l2.val){
            start = l1;
            l1 = l1.next;
        }else{
            start = l2;
            l2 = l2.next;
        }
        tmphead = start;
        while(l1 != null && l2 != null){
            if(l1.val > l2.val){
                tmphead.next = l2;
                l2 = l2.next;
                tmphead = tmphead.next;
            }else{
                tmphead.next = l1;
                l1 = l1.next;
                tmphead = tmphead.next;
            }
        }
        tmphead.next = (l1 == null ? l2 : l1);
        return start;
    }
    void printList(ListNode head){
        while(head != null){
            System.out.print(head.val + "->");
        }
        System.out.println("null");
    }
}