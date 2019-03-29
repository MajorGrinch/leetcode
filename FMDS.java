import java.util.*;
class MedianFinder {

    /** initialize your data structure here. */
    private Queue<Integer> smallHalf, largeHalf;
    public MedianFinder() {
        smallHalf = new PriorityQueue<>(new Comparator<Integer>(){
            public int compare(Integer a, Integer b){
                return b-a;
            }
        });
        largeHalf = new PriorityQueue<>(new Comparator<Integer>() {
            public int compare(Integer a, Integer b){
                return a - b;
            }
        });
    }

    public void addNum(int num) {
        largeHalf.offer(num);
        smallHalf.offer(largeHalf.poll());
        if(smallHalf.size() > largeHalf.size()+1){
            largeHalf.offer(smallHalf.poll());
        }
    }

    public double findMedian() {
        if(smallHalf.size() == largeHalf.size()){
            return (smallHalf.peek() + largeHalf.peek()) / 2.0;
        }else{
            return smallHalf.peek();
        }
    }
}

public class FMDS{
    public static void main(String[] args) {
        MedianFinder mf = new MedianFinder();
        mf.addNum(-1);
        System.out.println(mf.findMedian());
        mf.addNum(-2);
        System.out.println(mf.findMedian());
        mf.addNum(-3);
        System.out.println(mf.findMedian());
        mf.addNum(-4);
        System.out.println(mf.findMedian());
        mf.addNum(-5);
        System.out.println(mf.findMedian());
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */