import java.util.*;
class Solution {
    List<List<Integer>> ans;
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        ans = new ArrayList<>();
        // Arrays.sort(nums);
        boolean[] vis = new boolean[nums.length];
        dfs2(nums, vis, 0, new ArrayList<>());
        return ans;
    }
    void dfs2(int[] nums, boolean[] vis, int start, List<Integer> subset){
        ans.add(new ArrayList<>(subset));
        for(int i = start; i < nums.length; i++){
            if(i != 0 && nums[i] == nums[i-1] && !vis[i-1]){
                continue;
            }
            subset.add(nums[i]);
            vis[i] = true;
            dfs2(nums, vis, i+1, subset);
            vis[i] = false;
            subset.remove(subset.size()-1);
        }
    }
}
public class Subsets2{
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {1,2,2};
        List<List<Integer>> ans = solution.subsetsWithDup(nums);
        for(List<Integer> l : ans){
            System.out.println(l);
        }
    }
}