import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

class Solution {
    public List<Integer> countSmaller(int[] nums) {
        // Deque<Integer> dq = new ArrayDeque<>();
        List<Integer> ans = new LinkedList<>();
        int minV = Integer.MAX_VALUE;
        int maxV = Integer.MIN_VALUE;
        for(int num : nums){
            minV = Math.min(minV, num);
            maxV = Math.max(maxV, num);
        }
        maxV -= minV - 1;
        for(int i = 0; i < nums.length; i++){
            nums[i] -= minV-1;
        }
        FenwickTree fent = new FenwickTree(maxV);
        for(int i = nums.length-1; i >= 0; i--){
            ans.add(0, fent.rsq(nums[i]-1));
            fent.adjust(nums[i], 1);
        }
        return ans;
    }
}

class FenwickTree{
    private List<Integer> ft;

    private int LSOne(int num){return num&(-num);}

    public FenwickTree(int n){
        ft = new ArrayList<>();
        for(int i = 0; i <= n; i++) ft.add(0);
    }

    public void adjust(int k, int v){
        for(; k < ft.size(); k += LSOne(k)) ft.set(k, ft.get(k)+v);
    }

    public int rsq(int b){
        int sum = 0;
        for(; b > 0; b -= LSOne(b)) sum += ft.get(b);
        return sum;
    }
}

class SegTree{
    private int[] st, A;
    private int n;
    private int left(int p){return p << 1;}
    private int right(int p){ return (p<<1) + 1;}

    private void build(int p, int L, int R){
        System.out.printf("p = %d, L = %d, R = %d\n", p, L, R);
        if(L == R){
            st[p] = 0;
        }else{
            int mid = L+R >> 1;
            build(left(p), L, mid);
            build(right(p), mid+1, R);
            st[p] = st[left(p)] + st[right(p)];
        }
    }

    private int update(int p, int L, int R, int idx, int val){
        if(idx > R || idx < L) return st[p];
        
        if(L == idx && R == idx){
            // System.out.printf("p = %d, L = %d, R = %d\n", p, L, R);
            st[p] += val;
            return st[p] ;
        }
        int v1, v2, mid = L + R >> 1;
        v1 = update(left(p), L, mid, idx, val);
        v2 = update(right(p), mid+1, R, idx, val);
        st[p] = v1 + v2;
        return st[p];
    }

    public int update(int idx, int val){
        int res = update(1, 0, n-1, idx, val);
        // System.out.println(Arrays.toString(st));
        return res;
    }

    private int rsq(int p, int L, int R, int i, int j){
        if(i > R || j < L) return 0;
        if(i <= L && R <= j) return st[p];

        int mid = L+R >> 1;
        int p1 = rsq(left(p), L, mid, i, j);
        int p2 = rsq(right(p), mid+1, R, i, j);
        return (p1 + p2);
    }

    public int rsq(int i, int j){ 
        if(i > j) return 0;
        int res = rsq(1, 0, n-1, i, j);
        return res;
    }

    public SegTree(int _n){
        n = _n;
        st = new int[n << 2];
        build(1, 0, n-1);
    }

}

class Solution2 {
    public List<Integer> countSmaller(int[] nums) {
        List<Integer> ans = new LinkedList<>();
        int minV = Integer.MAX_VALUE;
        int maxV = Integer.MIN_VALUE;
        for(int num : nums){
            minV = Math.min(minV, num);
            maxV = Math.max(maxV, num);
        }
        SegTree segt = new SegTree(maxV-minV+2);
        maxV -= minV-1;
        for(int i = 0; i < nums.length; i++){
            nums[i] -= minV-1;
        }
        for(int i = nums.length-1; i >= 0; i--){
            ans.add(0, segt.rsq(1, nums[i]-1));
            segt.update(nums[i], 1);
        }
        return ans;
    }
}

public class CSNAS{
    public static void main(String[] args) {
        int[] input = {5,2,6,1};
        System.out.println(new Solution2().countSmaller(input));
    }
}