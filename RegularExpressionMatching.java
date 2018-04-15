import java.util.Arrays;

class Solution {
    public boolean isMatch(String s, String p) {
        boolean[][] dp = new boolean[s.length()+1][p.length()+1];
        dp[s.length()][p.length()] = true;
        for(int i = s.length(); i >= 0; i--){
            for(int j = p.length()-1; j >= 0; j--){
                boolean curr_match = (i < s.length()) && ((s.charAt(i) == p.charAt(j)) || p.charAt(j) == '.');
                if(j+1 < p.length() && p.charAt(j+1) == '*'){
                    dp[i][j] = dp[i][j+2] || (curr_match && dp[i+1][j]);
                }else{
                    dp[i][j] = curr_match && dp[i+1][j+1];
                }
            }
        }
        for(int i = 0; i < dp.length; i++)
            System.out.println(Arrays.toString(dp[i]));
        return dp[0][0];
    }
}
public class RegularExpressionMatching{
    public static void main(String[] args) {
        System.out.println(new Solution().isMatch("ab", ".*"));
    }
}