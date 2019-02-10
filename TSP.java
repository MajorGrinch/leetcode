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

class Solution2{

    public List<int[]> getSkyline(int[][] buildings) {
        if(buildings.length == 0 || buildings[0].length == 0) return new ArrayList<>();

        int cnt = 0;
        int n = buildings.length;
        int[] xaxis = new int[n << 1];
        // System.out.println(Arrays.toString(heights));

        List<int[]> ans = new ArrayList<>();
        SortedSet<Integer> xSet = new TreeSet<>();
        for(int[] bld : buildings){
            xSet.add(bld[0]);
            xSet.add(bld[1]);
        }

        for(int x : xSet){
            xaxis[cnt++] = x;
        }
        // System.out.println("cnt = " + cnt);
        SegTree st = new SegTree(cnt, xaxis);
        for(int[] bld : buildings){
            int l = lower_bound(xaxis, 0, cnt-1, bld[0]);
            int r = lower_bound(xaxis, 0, cnt-1, bld[1]) - 1;
            st.updateRange(l, r, bld[2]);
        }
        st.query(0, cnt-1, ans);
        return ans;
    }

    private int lower_bound(int[] h, int l, int r, int target){
        while(l < r){
            int mid = l + (r-l)/2;
            if(h[mid] == target) return mid;
            else if(h[mid] < target){
                l = mid + 1;
            }else{
                r = mid;
            }
        }
        return l;
    }
}

class SegTree{
    private int[] xaxis, height;
    private int numx;
    private int left(int root){ return root << 1;}
    private int right(int root){ return (root<<1)+1;}

    private void pushDown(int root){
        if(height[root] > 0){
            int h = height[root];
            height[left(root)] = Math.max(height[root], height[left(root)]);
            height[right(root)] = Math.max(height[root], height[right(root)]);
            height[root] = 0;
        }
    }

    private void updateRange(int root, int L, int R, int ust, int ued, int h){
        if(height[root] >= h) return;

        if(ust > R || ued < L) return;

        if(ust <= L && R <= ued){
            height[root] = h;
            return;
        }
        pushDown(root);
        int mid = L + (R-L)/2;
        updateRange(left(root), L, mid, ust, ued, h);
        updateRange(right(root), mid+1, R, ust, ued, h);
    }

    private void query(int root, int L, int R, List<int[]> ans){
        if(L == R){
            if(!ans.isEmpty() && height[root] == ans.get(ans.size()-1)[1]){
                return;
            }
            ans.add(new int[]{xaxis[L], height[root]});
            return;
        }
        pushDown(root);
        int mid = L + (R-L)/2;
        query(left(root), L, mid, ans);
        query(right(root), mid+1, R, ans);
    }

    public void query(int L, int R, List<int[]> ans){
        query(1, L, R, ans);
    }

    public void updateRange(int ust, int ued, int h){
        updateRange(1, 0, numx-1, ust, ued, h);
    }

    public SegTree(int _numx, int[] _xaxis){
        numx = _numx;
        xaxis = _xaxis;
        height = new int[numx * 4];
        System.out.println("height len = " + height.length);
    }

}