class Solution {
    public int minPathSum(int[][] grid) {
        if (grid.length == 0) {
            return 0;
        }
        int[][] dp = new int[grid.length][grid[0].length];
        int m = dp.length, n = dp[0].length;
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (i == m - 1 && j != n - 1) {
                    dp[i][j] = grid[i][j] + dp[i][j + 1];
                } else if (j == n - 1 && i != m - 1) {
                    dp[i][j] = grid[i][j] + dp[i + 1][j];
                } else if (i == m - 1 && j == n - 1) {
                    dp[i][j] = grid[i][j];
                } else {
                    dp[i][j] = grid[i][j] + Math.min(dp[i + 1][j], dp[i][j + 1]);
                }
            }
        }
        return dp[0][0];
    }
}

class Solution2 {
    public int minPathSum(int[][] grid) {
        if (grid.length == 0)
            return 0;
        int[] dp = new int[grid[0].length];
        int m = grid.length, n = grid[0].length;
        for (int i = m - 1; i >= 0; i--)
            for (int j = n - 1; j >= 0; j--) {
                if (i == m - 1 && j != n - 1) {
                    dp[j] = grid[i][j] + dp[j + 1];
                } else if (i != m - 1 && j == n - 1) {
                    dp[j] = grid[i][j] + dp[j];
                } else if (i == m - 1 && j == n - 1) {
                    dp[j] = grid[i][j];
                } else {
                    dp[j] = grid[i][j] + Math.min(dp[j + 1], dp[j]);
                }
            }
        return 0;
    }
}