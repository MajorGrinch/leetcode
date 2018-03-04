/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        if(head == null){
            return null;
        }
        RandomListNode new_head = new RandomListNode(head.label);
        RandomListNode p = head, q = new_head;
        HashMap<RandomListNode, RandomListNode> hmap = new HashMap<>();
        hmap.put(p, q);
        while(p.next != null){
            q.next = new RandomListNode(p.next.label);
            q = q.next;
            p = p.next;
            hmap.put(p, q);
        }
        p = head;q = new_head;
        while(p != null){
            if(p.random != null){
                q.random = hmap.get(p.random);
            }
            p = p.next;
            q = q.next;
        }
        return new_head;
    }
}