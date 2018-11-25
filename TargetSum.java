class Solution {
    int ans;
    public int findTargetSumWays(int[] nums, int S) {
        ans = 0;
        dfs(nums, 0, nums.length, 0, S);
        return ans;
    }

    private void dfs(int[] nums, int pos, int len, int currSum, int S){
        if(pos == len && currSum == S){
            ans++;
            return;
        }
        if(pos < len){
            dfs(nums, pos+1, len, currSum+nums[pos], S);
            dfs(nums, pos+1, len, currSum-nums[pos], S);
        }
    }
}