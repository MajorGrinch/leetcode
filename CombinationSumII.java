import java.util.*;
class Solution {
    /*
     * @param num: Given the candidate numbers
     * @param target: Given the target number
     * @return: All the combinations that sum to target
     */
    List<List<Integer>> ans;
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        // write your code here
        ans = new LinkedList<>();
        if(candidates.length == 0){
            return ans;
        }
        Arrays.sort(candidates);
        boolean[] vis = new boolean[candidates.length];
        // System.err.println(Arrays.toString(candidates));
        dfs(candidates, 0, vis, new LinkedList<Integer>(), 0, target);
        return ans;
    }
    /**
     * k is start index
     * vis record the visiting status of each node
     * comb is combination
     * comb_sum is the sum of combination
     * target is target
     */
    void dfs(int[] candidates, int k, boolean[] vis, LinkedList<Integer> comb, int comb_sum, int target){
        if(comb_sum == target){
            ans.add(new LinkedList<>(comb));
            return;
        }
        for(int i = k; i < candidates.length; i++){
            if( i != 0 && candidates[i] == candidates[i-1] && !vis[i-1]){
                continue;
            }
            if(comb_sum + candidates[i] <= target){
                comb.add(candidates[i]);
                vis[i] = true;
                dfs(candidates, i+1, vis, comb, comb_sum+candidates[i], target);
                vis[i] = false;
                comb.removeLast();
            }
        }
    }
}

public class CombinationSumII{
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] num = {7,1,2,5,1,6,10};
        int target = 8;
        List<List<Integer>> ans = solution.combinationSum2(num, target);
        for(List<Integer> l : ans){
            System.out.println(l);
        }
    }
}