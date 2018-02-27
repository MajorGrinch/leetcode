class Solution {
    List<List<String>> ans;
    boolean[][] palindrome;
    public List<List<String>> partition(String s) {
        ans = new ArrayList<>();
        palindrome = getPalindromeArray(s);
        List<String> path = new ArrayList<>();
        dfs(s, 0, path);
        return ans;
    }
    boolean[][] getPalindromeArray(String s){
        int n = s.length();
        char[] sc = s.toCharArray();
        boolean[][] dp = new boolean[n][n];
        for(int i = 0; i < n; i++){
            dp[i][i] = true;
        }
        for(int i = 0; i < n-1; i++){
            dp[i][i+1] = sc[i] == sc[i+1];
        }
        for(int i = n-3; i >= 0; i--){
            for(int j = i + 2; j < n; j++){
                dp[i][j] = dp[i+1][j-1] && (sc[i] == sc[j]);
            }
        }
        return dp;
    }
    void dfs(String s, int start, List<String> path){
        if(start == s.length()){
            ans.add(new ArrayList<>(path));
            return;
        }
        for(int i = start; i < s.length(); i++){
            if(palindrome[start][i]){
                path.add(s.substring(start, i+1));
                dfs(s, i+1, path);
                path.remove(path.size()-1);
            }
        }
    }
}