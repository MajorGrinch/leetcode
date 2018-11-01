class Solution {
    /*
    mathmatical problem.  for i from 1 to n, every point i could be the root 
    with i - 1 nodes on the left subtree and n - i on the right subtree, which
    as a whole forms bsts.
    dp[n] is answer for n.
    F(j, n) is number of unique bsts of n points with 
    jth point be the root. F(j, n) = dp[j-1] * dp[n-j]
    dp[n] = sum^{n}_{j=1} dp[j-1] * dp[n-j]
    */
    public int numTrees(int n) {
        int ans = 0;
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;
        for(int i = 2; i <= n; i++){
            for(int j = 1; j <= i; j++){
                dp[i] += dp[j-1] * dp[i-j];
            }
        }
        return dp[n];   
    }
}