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
    public List<Interval> merge(List<Interval> intervals) {
        List<Interval> ans = new ArrayList<>();

        intervals.sort(Comparator.comparing(i -> i.start));  //lambda 匿名函数：输入i  返回i.start

        Interval last = null;
        for (Interval inter : intervals) {
            if (last == null) {
                ans.add(inter);
                last = inter;
            } else if(last.end < inter.start){
                ans.add(inter);
                last = inter;
            }else if(last.end >= inter.start){
                last.end = Math.max(last.end, inter.end); // Modify the element already in list
            }
        }
        return ans;
    }
}