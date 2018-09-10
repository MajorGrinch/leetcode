import java.util.HashMap;
import java.util.Random;

class RandomListNode {
    int label;
    RandomListNode next, random;
    RandomListNode(int x) { this.label = x; }
}
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

class SOlution2{
    public RandomListNode copyRandomList(RandomListNode head) {
        if(head == null) return head;
        RandomListNode newHead = new RandomListNode(head.label);
        RandomListNode cop = newHead, ori = head;
        HashMap<RandomListNode, RandomListNode> hmap = new HashMap<>();
        hmap.put(ori, cop);
        while(ori.next != null){
            cop.next = new RandomListNode(ori.next.label);
            cop = cop.next;
            ori = ori.next;
            hmap.put(ori, cop);
        }
        cop = newHead;
        ori = head;
        while(ori != null){
            if(ori.random != null){
                cop.random = hmap.get(ori.random);
            }
            ori = ori.next;
            cop = cop.next;
        }
        return cop;
    }
}