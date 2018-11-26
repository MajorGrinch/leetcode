class Solution {
    public int countSubstrings(String s) {
        boolean[][] dp = calcPalindrome(s);
        int ans = 0;
        for(boolean[] row : dp){
            for(boolean isPalin : row){
                if(isPalin) ans++;
            }
        }
        return ans;
    }
    boolean[][] calcPalindrome(String s){
        int n = s.length();
        char[] sc = s.toCharArray();
        boolean[][] dp = new boolean[n][n];
        for(int i = 0; i < n; i++){
            dp[i][i] = true;
        }
        for(int i = 0; i < n-1; i++){
            dp[i][i+1] = (sc[i] == sc[i+1]);
        }
        for(int i = n-3; i >= 0; i--){
            for(int j = i + 2; j < n; j++){
                dp[i][j] = dp[i+1][j-1] && (sc[i] == sc[j]);
            }
        }
        return dp;
    }
}

class Solution2{
    int ans;
    public int countSubstrings(String s) {
        ans = 0;
        char[] sc = s.toCharArray();
        for(int i = 0; i < s.length(); i++){
            extendPalindrome(sc, i, i);
            extendPalindrome(sc, i, i+1);
        }
        return ans;
    }
    private void extendPalindrome(char[] sc, int st, int ed){
        while(st >= 0 && ed < sc.length && sc[st] == sc[ed]){
            ans++;
            st--;
            ed++;
        }
    }
}