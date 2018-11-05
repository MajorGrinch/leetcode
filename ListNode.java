public class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }

    public static void printList(ListNode head){
        while(head != null){
            System.out.print(head.val + "->");
        }
        System.out.println("null");
    }
}
