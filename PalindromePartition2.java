class Solution {
    public int minCut(String s) {
        int len = s.length();
        boolean[][] palindromeDPArray = getPalindromeDpArray(s);
        int[] dp = new int[len+1];
        dp[0] = 0;
        for(int i = 1; i <= len; i++){
            int temp = i;
            for(int j = 0; j < i; j++){
                if(palindromeDPArray[j][i-1]){
                    temp = Math.min(temp, dp[j] + 1);
                }
            }
            dp[i] = temp;
        }
        return dp[len]-1;
    }
    boolean[][] getPalindromeDpArray(String s){
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        char[] sc = s.toCharArray();
        for(int i = 0; i < n; i++){
            dp[i][i] = true;
        }
        for(int i = 0; i < n-1; i++){
            dp[i][i+1] = sc[i] == sc[i+1];
        }
        for(int i = n-3; i >= 0; i--){
            for(int j = i+2; j < n; j++){
                dp[i][j] = dp[i+1][j-1] && (sc[i] == sc[j]);
            }
        }
        return dp;
    }
}