import java.util.*;

class Point {
    int x;
    int y;
    Point() { x = 0; y = 0; }
    Point(int a, int b) { x = a; y = b; }
}

class Solution {
    public int maxPoints(Point[] points) {
        if(points == null || points.length == 0){
            return 0;
        }
        if(points.length == 1){
            return 1;
        }
        int ans = 0;
        for(int i = 0; i < points.length-1; i++){
            Map<String, Integer> hmap = new HashMap<>();
            int sloped = 0, overlapped = 0, vertical = 0;
            for(int j = i+1; j < points.length; j++){
                int x1 = points[i].x;
                int y1 = points[i].y;
                int x2 = points[j].x;
                int y2 = points[j].y;
                if(x1 == x2){
                    if(y1 == y2){
                        overlapped++;
                    }else{
                        vertical++;
                    }
                    continue;
                }
                int dx = x1 - x2;
                int dy = y1 - y2;
                int gcdN = gcd(dx, dy);
                dx /= gcdN;
                dy /= gcdN;
                String k = dy + "/" + dx;
                hmap.put(k, hmap.getOrDefault(k, 0) + 1);
                sloped = Math.max(sloped, hmap.get(k));
            }
            ans = Math.max(ans, Math.max(sloped, vertical) + overlapped + 1);
        }
        return ans; 
    }
    int gcd(int a, int b){
        return b==0 ? a : gcd(b, a%b);
    }
}
public class MaxPointsOnALine{
    public static void main(String[] args) {
        Point[] points = new Point[3];
        points[0] = new Point(0, 0);
        points[1] = new Point(94911151,94911150);
        points[2] = new Point(94911152,94911151);
        int ans = new Solution().maxPoints(points);
        System.out.println(ans);
    }
}