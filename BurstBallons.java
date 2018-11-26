class Solution {
    public int maxCoins(int[] nums) {
        int[] mynums = new int[nums.length+2];
        mynums[0] = 1;
        int n = 1;
        for(int num : nums){
            mynums[n++] = num;
        }
        mynums[n++] = 1;
        int[][] dp = new int[n][n];
        for(int k = 2; k < n; k++){
            for(int l = 0; l < n-k; l++){
                int r = l + k;
                for(int i = l + 1; i < r; i++){
                    dp[l][r] = Math.max(dp[l][r], dp[l][i] + dp[i][r] + mynums[i] * mynums[r] * mynums[l]);
                }
            }
        }
        return dp[0][n-1];
    }
    
}