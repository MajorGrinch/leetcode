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