/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
class Solution {
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        List<Interval> res = new ArrayList<>();
        intervals.add(newInterval);
        intervals.sort(Comparator.comparing(i->i.start));
        Interval last = null;
        for(Interval intv : intervals){
            if(last == null || last.end < intv.start){
                res.add(intv);
                last = intv;
            }else{
                last.end = Math.max(intv.end, last.end);
            }
        }
        return res;
    }
}