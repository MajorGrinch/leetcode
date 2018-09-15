public class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}


public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

class Solution {
    private ListNode l;
    public TreeNode sortedListToBST(ListNode head) {
        ListNode p = head;
        int n = 0;
        while(p != null){
            p = p.next;
            n++;
        }
        l = head;
        return sortedListToBST(0, n-1);
    }

    private TreeNode sortedListToBST(int st, int ed){
        if(st > ed) return null;
        int mid = st + (ed-st)/2;
        TreeNode left = sortedListToBST(st, mid-1);
        TreeNode curr = new TreeNode(l.val);
        curr.left = left;
        l = l.next;
        TreeNode right = sortedListToBST(mid+1, ed);
        curr.right = right;
        return curr;
    }
}