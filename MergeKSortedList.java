import java.util.Comparator;
import java.util.Queue;

class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length == 0) return null;
        Queue<ListNode> q = new PriorityQueue(lists.length, listComparator);
        for(ListNode l: lists){
            if(l != null)
                q.add(l);
        }
        ListNode p = new ListNode(0);
        ListNode ans = p;
        while(!q.isEmpty()){
            ListNode tmp = q.poll();
            p.next = tmp;
            if(tmp.next != null)
                q.add(tmp.next);
            p = p.next;
        }
        return ans.next;
    }

    private Comparator<ListNode> listComparator = new Comparator<ListNode>(){
        @Override
        public int compare(ListNode a, ListNode b){
            return a.val - b.val;
        }
    };
    
}
public class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}
class Solution2{
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length == 0) return null;
        return mergeKLists(lists, 0, lists.length-1);
    }
    private ListNode mergeKLists(ListNode[] lists, int start, int end){
        if(start == end) return lists[start];
        else if(start < end){
            int mid = start + (start-end)/2;
            ListNode left = mergeKLists(lists, start, mid);
            ListNode right = mergeKLists(lists, mid+1, end);
            return merge(left, right);
        }else return null;
    }
    private ListNode merge(ListNode l1, ListNode l2){
        ListNode l = new ListNode(0);
        ListNode p = l;
        while(l1 != null && l2 != null){
            if(l1.val <= l2.val){
                p.next = l1;
                l1 = l1.next;
            }else{
                p.next = l2;
                l2 = l2.next;
            }
            p = p.next;
        }
        if(l1 != null) p.next = l1;
        if(l2 != null) p.next = l2;
        return l.next;
    }
}