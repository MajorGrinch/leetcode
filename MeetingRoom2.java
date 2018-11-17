import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * priority queue stores the rooms currently holds meetings
 */
class Solution {
    public int minMeetingRooms(Interval[] intervals) {
        if(intervals.length == 0) return 0;
        Arrays.sort(intervals, (x,y)->(x.start-y.start));
        PriorityQueue<Interval> pq = new PriorityQueue<>((a,b)->(a.end-b.end));
        int ans = 1;
        pq.offer(intervals[0]);
        for(int i = 1; i < intervals.length; i++){
            Interval peek = pq.peek();
            if(peek.end <= intervals[i].start){
                pq.poll();
            }
            pq.offer(intervals[i]);
            ans = Math.max(ans, pq.size());
        }
        return ans;
    }
}

public class MeetingRoom2{
    public static void main(String[] args) {
        
    }
}