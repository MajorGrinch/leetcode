class Solution {
    public String longestPalindrome(String s) {
        if(s.length() == 0){
            return "";
        }
        boolean[][] dp = getPalindromeDpArray(s);
        int len = s.length();
        for(int size = len; size > 0; size--){
            for(int i = 0; i < len+1-size; i++){
                if(dp[i][i+size-1]){
                    return s.substring(i, i+size);
                }
            }
        }
        return s.substring(0,1);
    }
    boolean[][] getPalindromeDpArray(String s){
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        char[] sc = s.toCharArray();
        for(int i = 0; i < n; i++){
            dp[i][i] = true;
        }
        for(int i = 0; i < n-1; i++)
            dp[i][i+1] = (sc[i] == sc[i+1]);
        for(int i = n-3; i >= 0; i--){
            for(int j = i+2; j < n; j++){
                dp[i][j] = dp[i+1][j-1] && (sc[i] == sc[j]);
            }
        }
        return dp;
    }
}
public class LongestPalindromicSubstring{
    public static void main(String[] args) {
        System.out.println(new Solution().longestPalindrome("abba"));
    }
}