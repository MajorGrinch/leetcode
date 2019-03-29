import java.util.*;

class KthLargest {

    Queue<Integer> pq;
    int capacity = 0;
    public KthLargest(int k, int[] nums) {
        pq = new PriorityQueue<>(new Comparator<Integer>() {
            public int compare(Integer a, Integer b){
                return a-b;
            }
        });
        capacity = k;
        for(int num: nums){
            pq.offer(num);
            if(pq.size() > capacity){
                pq.poll();
            }
        }
    }
    public int add(int val) {
        pq.offer(val);
        if(pq.size() > capacity) pq.poll();
        return pq.peek();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */