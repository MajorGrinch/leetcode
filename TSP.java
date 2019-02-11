import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;

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

public class TSP{
    public static void main(String[] args) {
        int[][] input = {{2,9,10},{3,7,15},{5,12,12},{15,20,10},{19,24,8}};
        List<int[]> ans = new Solution2().getSkyline(input);
        for(int[] p : ans){
            System.out.printf("[%d, %d] ", p[0], p[1]);
        }
        System.out.println();
    }
}

class Solution2 {
    public List<int[]> getSkyline(int[][] buildings) {
        if(buildings.length == 0 || buildings[0].length == 0) return new ArrayList<>();

        int numX = 0;
        int n = buildings.length;
        int[] xAxis = new int[n * 2];
        SortedSet<Integer> xSet = new TreeSet<>();
        for(int[] bld : buildings){
            xSet.add(bld[0]);
            xSet.add(bld[1]);
        }
        for(int x : xSet){
            xAxis[numX++] = x;
        }
        LazySegTree lst = new LazySegTree(numX, xAxis);
        for(int[] bld : buildings){
            int l = lower_bound(xAxis, 0, numX-1, bld[0]);
            int r = lower_bound(xAxis, 0, numX-1, bld[1])-1;
            lst.updateRange(l, r, bld[2]);
        }
        List<int[]> ans = new ArrayList<>();
        lst.query(ans);
        return ans;
    }

    private int lower_bound(int[] h, int l, int r, int target){
        while(l < r){
            int mid = l + (r-l) / 2;
            if(h[mid] == target) return mid;
            else if(h[mid] > target) r = mid;
            else l = mid + 1;
        }
        return l;
    }
}

class LazySegTree{
    private int[] xAxis, heights;
    private int numX;
    private int left(int root){ return root << 1;}
    private int right(int root){ return (root << 1) + 1;};

    private void pushDown(int root){
        if(heights[root] > 0){
            int h = heights[root];
            heights[left(root)] = Math.max(heights[left(root)], h);
            heights[right(root)] = Math.max(heights[right(root)], h);
            heights[root] = 0;
        }
    }

    private void updateRange(int root, int L, int R, int ust, int ued, int h){
        if(heights[root] >= h) return; // maintain the highest

        if(ust > R || ued < L) return;

        if(ust <= L && R <= ued){
            heights[root] = h;
            return;
        }
        pushDown(root);
        int mid = L + (R-L)/2;
        updateRange(left(root), L, mid, ust, ued, h);
        updateRange(right(root), mid+1, R, ust, ued, h);
    }

    private void query(int root, int L, int R, List<int[]> ans){
        if(L == R){
            if(!ans.isEmpty() && heights[root] == ans.get(ans.size()-1)[1]) return;
            ans.add(new int[]{xAxis[L], heights[root]});
            return;
        }
        pushDown(root);
        int mid = L + (R-L)/2;
        query(left(root), L, mid, ans);
        query(right(root), mid+1, R, ans);
    }

    public void query(List<int[]> ans){
        query(1, 0, numX-1, ans);
    }

    public void updateRange(int ust, int ued, int h){
        updateRange(1, 0, numX-1, ust, ued, h);
    }

    public LazySegTree(int _numX, int[] _xAxis){
        numX = _numX;
        xAxis = _xAxis;
        heights = new int[numX << 2];
    }
}