class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        if(nums.length == 0){
            ans.add(new ArrayList<>());
            return ans;
        }
        boolean[] vis = new boolean[nums.length];
        List<Integer> path = new ArrayList<>();
        dfs(nums, vis, path, ans);
        return ans;
    }
    void dfs(int[] nums, boolean[] vis, List<Integer> path, List<List<Integer>> ans){
        if(path.size() == nums.length){
            ans.add(new ArrayList<>(path));
            return;
        }
        for(int i = 0; i < nums.length; i++){
            if(!vis[i]){
                vis[i] = true;
                path.add(nums[i]);
                dfs(nums, vis, path, ans);
                vis[i] = false;
                path.remove(path.size()-1);
            }
        }
    }
}