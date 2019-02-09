import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.TreeMap;

class Solution {
    public List<int[]> getSkyline(int[][] buildings) {
        List<int[]> skyline = new ArrayList<>();
        List<int[]> heights = new ArrayList<>();
        for(int[] b : buildings){
            heights.add(new int[]{b[0], -b[2]});
            heights.add(new int[]{b[1], b[2]});
        }
        Collections.sort(heights, (a, b) -> {
            if(a[0] != b[0]) return a[0] - b[0];
            return a[1] - b[1];
        });
        for(int[] h : heights){
            System.out.print(h[0] + " " + h[1] + " | ");
        }
        System.out.println();
        TreeMap<Integer, Integer> vertical = new TreeMap<>();
        int prevTop = 0;
        vertical.put(prevTop, 0);
        for(int[] h : heights){
            int h1 = h[1];
            if(h1 < 0){
                vertical.put(-h1, vertical.getOrDefault(-h1, 0)+1);
            }else{
                if(vertical.get(h1) > 1) vertical.put(h1, vertical.get(h1)-1);
                else vertical.remove(h1);
            }
            int currTop = vertical.lastKey();
            if(currTop != prevTop){
                skyline.add(new int[]{h[0], currTop});
                prevTop = currTop;
            }
        }
        return skyline;
    }
}