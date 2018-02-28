class Solution {
    List<List<Integer>> ans;
    public List<List<Integer>> permuteUnique(int[] nums) {
        ans = new ArrayList<>();
        if(nums.length == 0){
            ans.add(new ArrayList<>());
            return ans;
        }
        Arrays.sort(nums);
        boolean[] vis = new boolean[nums.length];
        List<Integer> path = new ArrayList<>();
        dfs(nums, vis, path);
        return ans;
    }
    void dfs(int[] nums, boolean[] vis, List<Integer> path){
        if(path.size() == nums.length){
            ans.add(new ArrayList<>(path));
            return;
        }
        for(int i = 0; i < nums.length; i++){
            if(vis[i] || (i != 0 && nums[i] == nums[i-1] && !vis[i-1])){
                continue;
            }
            vis[i] = true;
            path.add(nums[i]);
            dfs(nums, vis, path);
            vis[i] = false;
            path.remove(path.size()-1);
        }
    }
}