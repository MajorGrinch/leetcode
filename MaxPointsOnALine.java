import java.util.Arrays;
import java.util.HashMap;
import java.math.BigDecimal;
import java.util.*;

class Point {
    int x;
    int y;
    Point() { x = 0; y = 0; }
    Point(int a, int b) { x = a; y = b; }
}

class FunctionPara{
    // double k;
    BigDecimal k;
    double yp;
    double b;
    FunctionPara(BigDecimal k, double yp, double b){
        this.k = k;
        this.yp = yp;
        this.b = b;
    }
    @Override
    public boolean equals(Object o){
        if( !(o instanceof FunctionPara)){
            return false;
        }
        FunctionPara fp = (FunctionPara)o;
        return k.compareTo(fp.k) == 0 && Math.abs(fp.yp-this.yp) < 1e-16  && Math.abs(fp.b-this.b) < 1e-16;
    }
    @Override
    public int hashCode(){
        return (int)(1000000 * this.k.doubleValue());
    }
}
 
class Solution {
    public int maxPoints(Point[] points) {
        if(points == null || points.length == 0){
            return 0;
        }
        if(points.length == 1){
            return 1;
        }
        HashMap<FunctionPara, HashSet<Point>> lmap = new HashMap<>();
        HashSet<FunctionPara> fpset = new HashSet<>();
        for(int i = 0; i < points.length-1; i++){
            for(int j = i+1; j < points.length; j++){
                int x1 = points[i].x;
                int y1 = points[i].y;
                int x2 = points[j].x;
                int y2 = points[j].y;
                FunctionPara fp;
                if(x1 == x2){
                    fp = new FunctionPara(new BigDecimal(1.0), 0.0, -x1);
                }else{

                    BigDecimal k = new BigDecimal(y1-y2).divide(new BigDecimal(x1-x2), 20, BigDecimal.ROUND_HALF_UP);
                    double b = y1 - k.doubleValue()*x1;
                    fp = new FunctionPara(k, -1.0, b);
                }
                lmap.putIfAbsent(fp, new HashSet<>());
                lmap.get(fp).add(points[i]);
                lmap.get(fp).add(points[j]);
                System.out.println(fp.k);
                // for(FunctionPara f : lmap.keySet()){
                //     System.out.println(f.k + " " + f.yp + " " + f.b + " " + lmap.get(f));
                // }
                // System.out.println("---------------");
            }
        }
        int count = 0;
        for(FunctionPara fp : lmap.keySet()){
            count = Math.max(lmap.get(fp).size(), count);
            System.out.println(fp.k + " " + fp.yp + " " + fp.b + " " + lmap.get(fp));
        }
        return count; 
    }
}
public class MaxPointsOnALine{
    public static void main(String[] args) {
        Point[] points = new Point[3];
        points[1] = new Point(94911151,94911150);
        points[0] = new Point(0, 0);
        points[2] = new Point(94911152,94911151);
        int ans = new Solution().maxPoints(points);
        System.out.println(ans);
    }
}