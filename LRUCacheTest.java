import java.util.HashMap;
import java.util.Map;
class DLinkedList{
    int key;
    int val;
    DLinkedList pre;
    DLinkedList next;
    public DLinkedList(int key, int val){
        this.val = val;
        this.key = key;
    }
}

class LRUCache {

    Map<Integer, DLinkedList> cache;
    final int cache_Cap;
    int currEleNum;
    DLinkedList lruhead;
    DLinkedList lrurear;
    public LRUCache(int capacity) {
        cache = new HashMap<>();
        cache_Cap = capacity;
        currEleNum = 0;
        lruhead = new DLinkedList(-1, -1);
        lrurear = new DLinkedList(-1, -1);
        lruhead.next = lrurear;
        lruhead.pre = null;
        lrurear.next = null;
        lrurear.pre = lruhead;
    }
    
    public int get(int key) {
        DLinkedList res = cache.getOrDefault(key, null);
        if(res == null){
            return -1;
        }
        move2First(res);
        return res.val;
    }
    
    public void put(int key, int value) {
        DLinkedList node = cache.getOrDefault(key, null);
        if(node != null){
            node.val = value;
            move2First(node);
        }else{
            node = new DLinkedList(key, value);
            addNode(node);
            cache.put(key, node);
            if(++currEleNum > cache_Cap){
                cache.remove(lrurear.pre.key);
                removeNode(lrurear.pre);
                currEleNum--;
            }
        }
    }

    private void addNode(DLinkedList node){
        node.next = lruhead.next;
        lruhead.next = node;
        node.pre = lruhead;
        node.next.pre = node;
    }
    private void removeNode(DLinkedList node){
        node.pre.next = node.next;
        node.next.pre = node.pre;
    }
    private void move2First(DLinkedList node){
        removeNode(node);
        addNode(node);
    }

    private void printList(){
        DLinkedList p = lruhead;
        while(p != null){
            System.out.print(p.key + "->");
            p = p.next;
        }
        System.out.println("null");
    }

}

public class LRUCacheTest{
    public static void main(String[] args) {
        LRUCache cache = new LRUCache(1);
        cache.put(2, 1);
        cache.get(2);       
        cache.put(3, 2);
        cache.get(2);       
        cache.get(3);
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */