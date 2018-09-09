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