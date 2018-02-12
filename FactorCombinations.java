class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    List<Integer> current_factors = new ArrayList<>();
    public List<List<Integer>> getFactors(int n) {
        if(n == 1){
            return ans;
        }
        dfs(2, n);
        return ans;
    }
    
    void dfs(int start, int remain){
        if(remain == 1){
            if(current_factors.size() != 1){
                ans.add(new ArrayList<>(current_factors));
            }
            return;
        }
        for(int i = start; i <= remain; i++){
            if(i > remain/i){
                break;
            }
            if(remain % i == 0){
                current_factors.add(i);
                dfs(i, remain/i);
                current_factors.remove(current_factors.size()-1);    
            }
        }
        current_factors.add(remain);
        dfs(remain, 1);
        current_factors.remove(current_factors.size()-1);
    }
    
}