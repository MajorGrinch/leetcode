public class EditDistance {
    public static void main(String[] args) {
        String a = "liusongshan";
        String b = "wangziyang";
        System.out.println(new Solution().minDistance(a, b));
    }
}

class Solution {
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        int[][] dp = new int[m + 1][n + 1];
        char[] aword1 = word1.toCharArray();
        char[] aword2 = word2.toCharArray();
        for (int i = 0; i <= m; i++)
            dp[i][0] = i;
        for (int j = 0; j <= n; j++)
            dp[0][j] = j;
        for (int i = 1; i <= m; i++)
            for (int j = 1; j <= n; j++) {
                if (aword1[i-1] == aword2[j-1])
                    dp[i][j] = dp[i - 1][j - 1];
                else {
                    dp[i][j] = Math.min(dp[i - 1][j] + 1, dp[i][j - 1] + 1);
                    dp[i][j] = Math.min(dp[i][j], dp[i-1][j-1]+1);
                }
            }
        return dp[m][n];
    }
}