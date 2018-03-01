class Solution {
    List<List<Integer>> ans;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        ans = new LinkedList<>();
        if(candidates.length == 0){
            return ans;
        }
        Arrays.sort(candidates);
        LinkedList<Integer> combination = new LinkedList<>();
        dfs(candidates, 0, combination, 0, target);
        return ans;
    }
    void dfs(int[] candidates, int k, LinkedList<Integer> combination, int comb_sum, int target){
        if(comb_sum == target){
            ans.add(new LinkedList<>(combination));
            return;
        }
        for(int i = k; i < candidates.length; i++){
            
            if(comb_sum + candidates[i] <= target){
                combination.add(candidates[i]);
                dfs(candidates, i, combination, comb_sum+candidates[i], target);
                combination.removeLast();
            }
        }
    }
}